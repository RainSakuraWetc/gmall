package com.atguigu.gmall.order.client;

import com.atguigu.gmall.model.order.OrderInfo;
import com.atguigu.gmall.order.client.fallback.OrderDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wentao.xie
 * @date 2022/1/23 20:25
 * @Verssion 1.0
 * @Desc
 */
@FeignClient(value ="service-order", fallback = OrderDegradeFeignClient.class)
public interface OrderFeignClient {


    OrderInfo getOrderInfo(Long orderId);
}
