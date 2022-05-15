package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuInfo;

/**
 * @author wentao.xie
 * @date 2022/1/23 16:45
 * @Verssion 1.0
 * @Desc
 */
public interface SkuInfoService {

    SkuInfo getSkuInfoRedis(Long skuId);

    SkuInfo getSkuInfoDB(Long skuId);

    SkuInfo getSkuInfoRedisson(Long skuId);

    void onSale(Long skuId);

    void cancelSale(Long skuId);

}
