package com.atguigu.gmall.item.service;

import java.util.Map;

/**
 * @author wentao.xie
 * @date 2022/1/23 2:30
 * @Verssion 1.0
 * @Desc
 */
public interface ItemService {

    Map<String, Object> getBySkuId(Long skuId);
}
