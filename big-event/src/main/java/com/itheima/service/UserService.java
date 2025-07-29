package com.itheima.service;


import com.itheima.pojo.User;

public interface UserService {
    //根据注册名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password);

    //更新用户基本信息
    void update(User user);

    //更新用户头像
    void updateAvatar(String url);

    //更新用户密码
    void updatePwd(String md5String);
}