package com.atguigu.gmall.order.client.fallback;

import com.atguigu.gmall.model.order.OrderInfo;
import com.atguigu.gmall.order.client.OrderFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author wentao.xie
 * @date 2022/1/23 20:28
 * @Verssion 1.0
 * @Desc
 */
@Component
public class OrderDegradeFeignClient implements OrderFeignClient {

    @Override
    public OrderInfo getOrderInfo(Long orderId) {
        return null;
    }
}
