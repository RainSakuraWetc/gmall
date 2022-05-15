package com.atguigu.gmall.list.service;

import com.atguigu.gmall.model.list.SearchParam;
import com.atguigu.gmall.model.list.SearchResponseVo;

import java.io.IOException;

/**
 * @author wentao.xie
 * @date 2022/1/23 21:03
 * @Verssion 1.0
 * @Desc
 */
public interface SearchService {

    SearchResponseVo search(SearchParam searchParam) throws IOException;

    void upperGoods(Long skuId);

    void lowerGoods(Long skuId);
}
