package com.atguigu.gmall.model.list;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wentao.xie
 * @date 2022/1/23 21:01
 * @Verssion 1.0
 * @Desc
 */
@Data
public class SearchResponseTmVo implements Serializable {

    //当前属性值的所有值
    private Long tmId;
    //属性名称
    private String tmName;
    //网络制式，分类
    String tmLogoUrl;
}