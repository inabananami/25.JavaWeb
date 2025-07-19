package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static jdk.internal.org.jline.utils.Colors.s;


@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper UserMapper;
    @Override
    public User findByUserName(String username) {
        User u = UserMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        //添加
        UserMapper.add(username, md5String);
    }
}
