package com.atguigu.gmall.cart.client.impl;

import com.atguigu.gmall.cart.client.CartFeignClient;
import com.atguigu.gmall.model.car.CartInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wentao.xie
 * @date 2022/1/24 22:30
 * @Verssion 1.0
 * @Desc
 */
@Component
public class CartDegradeFeignClient implements CartFeignClient {
    @Override
    public List<CartInfo> getCartCheckedList(String userId) {
        return null;
    }
}
