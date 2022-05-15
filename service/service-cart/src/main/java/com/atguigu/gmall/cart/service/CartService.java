package com.atguigu.gmall.cart.service;

import com.atguigu.gmall.model.car.CartInfo;

import java.util.List;

/**
 * @author wentao.xie
 * @date 2022/1/23 2:30
 * @Verssion 1.0
 * @Desc
 */
public interface CartService {

    /**
     * 根据用户Id 查询购物车列表
     *
     * @param userId
     * @return
     */
    List<CartInfo> getCartCheckedList(String userId);
}
