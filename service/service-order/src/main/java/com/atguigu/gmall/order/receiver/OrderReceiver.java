package com.atguigu.gmall.order.receiver;

import com.atguigu.gmall.common.ProcessStatus;
import com.atguigu.gmall.common.constant.MqConst;
import com.atguigu.gmall.model.order.OrderInfo;
import com.atguigu.gmall.order.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author wentao.xie
 * @date 2022/1/26 1:18
 * @Verssion 1.0
 * @Desc
 */
@Component
public class OrderReceiver {

    @Autowired
    private OrderService orderService;

    /**
     * 监听的消息
     * @param orderId
     * @param message
     * @param channel
     */
    @SneakyThrows
    @RabbitListener(queues = MqConst.QUEUE_ORDER_CANCEL)
    public void cancelOrder(Long orderId , Message message, Channel channel){
        //  判断当前订单Id 不能为空
        try {
            if (orderId!=null){
                //  发过来的是订单Id，那么你就需要判断一下当前的订单是否已经支付了。
                //  未支付的情况下：关闭订单
                //  根据订单Id 查询orderInfo select * from order_info where id = orderId
                //  利用这个接口IService  实现类ServiceImpl 完成根据订单Id 查询订单信息 ServiceImpl 类底层还是使用的mapper
                OrderInfo orderInfo = orderService.getById(orderId);
                //  判断支付状态,进度状态
                if (orderInfo!=null && "UNPAID".equals(orderInfo.getOrderStatus())
                        && "UNPAID".equals(orderInfo.getProcessStatus())){
                    //  关闭订单
                    //  int i = 1/0;
                    orderService.execExpiredOrder(orderId);
                }
            }
        } catch (Exception e) {
            //  消息没有正常被消费者处理： 记录日志后续跟踪处理!

            e.printStackTrace();
        }
        //  手动确认消息 如果不确认，有可能会到消息残留。
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @SneakyThrows
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConst.QUEUE_PAYMENT_PAY, durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_PAYMENT_PAY),
            key = {MqConst.ROUTING_PAYMENT_PAY}
    ))
    public void updateOrder(Long orderId, Message message, Channel channel) {
        if (!ObjectUtils.isEmpty(orderId)) {
            OrderInfo orderInfo = orderService.getById(orderId);
            if (!ObjectUtils.isEmpty(orderInfo) && orderInfo.getOrderStatus().equals(ProcessStatus.UNPAID)) {
                orderService.updateOrderStatus(orderId, ProcessStatus.PAID);
            }
        }

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
