package com.itheima.mapper;

import com.itheima.pojo.User;

public interface UserMapper {
    //根据用户名查询用户
    public User findByUserName(String username);

    //添加加密后的md5密码
    void add(String username, String md5String);
}