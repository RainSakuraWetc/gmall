package com.atguigu.gmall.list.repository;

import com.atguigu.gmall.model.list.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wentao.xie
 * @date 2022/1/23 20:55
 * @Verssion 1.0
 * @Desc
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {

}
