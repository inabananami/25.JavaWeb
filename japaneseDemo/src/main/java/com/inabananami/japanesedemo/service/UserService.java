package com.inabananami.japanesedemo.service;

import com.inabananami.japanesedemo.dto.UserDto;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.param.SignUpParam;

public interface UserService {
    //用户注册
    Result signUp(SignUpParam signUpParam);
    //用户登录
    Result login(String account,String password);
    //查找用户（byid）
    Result findUserById(Integer id);
    //模糊查询
    Result search(String keyWord);
    //更新用户信息
    Result update(UserDto userDto);
    //注销用户
    Result delete();
}