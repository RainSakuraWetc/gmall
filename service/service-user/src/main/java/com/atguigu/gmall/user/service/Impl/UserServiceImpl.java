package com.atguigu.gmall.user.service.Impl;

import com.atguigu.gmall.model.user.UserInfo;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import com.atguigu.gmall.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author wentao.xie
 * @date 2022/1/23 2:31
 * @Verssion 1.0
 * @Desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserInfo userInfo) {
        // select * from userInfo where userName = ? and passwd = ?
        // 注意密码是加密：
        String passwd = userInfo.getPasswd(); //123
        // 将passwd 进行加密
        String newPasswd = DigestUtils.md5DigestAsHex(passwd.getBytes());

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", userInfo.getLoginName());
        queryWrapper.eq("passwd", newPasswd);
        UserInfo info = userInfoMapper.selectOne(queryWrapper);
        if (info != null) {
            return info;
        }
        return null;
    }
}
