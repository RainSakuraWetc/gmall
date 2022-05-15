package com.atguigu.gmall.model.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wentao.xie
 * @date 2022/1/26 1:40
 * @Verssion 1.0
 * @Desc
 */
@Data
public class PaymentInfo {

    private Long orderId;

    private String paymentType;

    private String outTradeNo;

    private String paymentStatus;

    private String subject;

    private BigDecimal totalAmount;

    private Date createTime;

    private Date callbackTime;

    private String tradeNo;

    private String callbackContent;

}
