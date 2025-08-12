package com.inabananami.japanesedemo.service;

import com.inabananami.japanesedemo.vo.Result;

public interface AdminService {
    //管理员查询
    Result findUserByAccount(String account);

    //管理员封禁
    Result ban(String account);
}