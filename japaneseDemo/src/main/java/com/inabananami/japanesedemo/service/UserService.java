package com.inabananami.japanesedemo.service;

import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.vo.Result;

public interface UserService {
    //查找用户（byid）
    Result findUserById(Integer id);
    //模糊查询
    Result search(String keyWord);
    //更新用户信息
    Result update(User user);
    //注销用户
    Result delete(Integer id);
    //管理员封禁
    Result ban(Integer id);
}
