package com.atguigu.gmall.model.user;

import lombok.Data;

/**
 * @author wentao.xie
 * @date 2022/1/23 21:47
 * @Verssion 1.0
 * @Desc
 */
@Data
public class UserInfo {

    private String loginName;

    private String passwd;

    private String nickName;

    private Long id;
}
