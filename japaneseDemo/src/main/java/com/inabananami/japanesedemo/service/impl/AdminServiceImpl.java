package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.AdminMapper;
import com.inabananami.japanesedemo.service.AdminService;
import com.inabananami.japanesedemo.vo.AdminUserVo;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    //管理员查询
    @Override
    public Result findUserByAccount(String account) {
        AdminUserVo adminUserVo = adminMapper.findUserByAccount(account);
        return Result.success(adminUserVo);
    }

    //管理员封禁
    @Override
    public Result ban(Integer userId) {
        adminMapper.ban(userId);
        return Result.success(null);
    }
}