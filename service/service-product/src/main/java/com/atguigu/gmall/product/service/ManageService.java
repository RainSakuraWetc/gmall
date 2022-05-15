package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;

import java.util.List;

/**
 * @author wentao.xie
 * @date 2022/1/23 2:30
 * @Verssion 1.0
 * @Desc
 */
public interface ManageService {

    List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id);
}
