package com.itheima.service;


import com.itheima.pojo.User;

public interface UserService {
    //根据注册名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password);
}