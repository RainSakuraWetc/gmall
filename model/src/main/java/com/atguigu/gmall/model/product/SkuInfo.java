package com.atguigu.gmall.model.product;

import lombok.Data;

/**
 * @author wentao.xie
 * @date 2022/1/23 16:21
 * @Verssion 1.0
 * @Desc
 */
@Data
public class SkuInfo {

    private Long id;

    private Long spuId;

    private Long category3Id;

    private Integer isSale;
}
