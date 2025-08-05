package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.UserMapper;
import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.service.UserService;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //查询用户（id）
    @Override
    public Result findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return Result.success(user);
    }
    //模糊查询
    public Result search(String keyWord) {
        return Result.success("null");
    }
    //更新用户信息
    public Result update(User user) {
        return Result.success("null");
    }
    //注销用户
    @Override
    public Result delete(Integer id) {
        userMapper.delete(id);
        return Result.success("null");
    }

    //管理员封禁
    @Override
    public Result ban(Integer id) {
        userMapper.ban(id);
        return Result.success("null");
    }
}