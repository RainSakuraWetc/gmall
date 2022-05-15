package com.atguigu.gmall.model.car;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wentao.xie
 * @date 2022/1/24 22:39
 * @Verssion 1.0
 * @Desc
 */
@Data
public class CartInfo {

    private Long isChecked;

    private Long skuId;

    private String skuName;

    private String imgUrl;

    private BigDecimal skuPrice;

    private Integer skuNum;
}
