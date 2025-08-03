package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;

public interface UserService {
    SysUser findUserById(Long userId);

    //登录
    SysUser findUser(String account, String password);
}