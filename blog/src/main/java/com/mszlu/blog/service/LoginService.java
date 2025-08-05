package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginParams;

public interface LoginService {

    Result login(LoginParams loginParams);

    //校验token
    SysUser checkToken(String token);

    //退出登录
    Result logout(String token);

    //注册
    Result register(LoginParams loginParams);
}
