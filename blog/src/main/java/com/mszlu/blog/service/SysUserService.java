package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.vo.Result;

public interface SysUserService {
    SysUser findUserById(Long userId);

    //登录
    SysUser findUser(String account, String password);

    //根据token查询用户信息
    Result findUserByToken(String token);

    //根据账号查询用户信息
    SysUser findUserByAccount(String account);

    //保存注册信息
    void save(SysUser sysUser);
}