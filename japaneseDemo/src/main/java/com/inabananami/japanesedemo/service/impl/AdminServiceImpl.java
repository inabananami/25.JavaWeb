package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.AdminMapper;
import com.inabananami.japanesedemo.service.AdminService;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import com.inabananami.japanesedemo.vo.AdminUserVo;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    //管理员查询
    @Override
    public Result findUserByAccount(String account) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Boolean isAdmin = (Boolean) map.get("role");
        System.out.println(isAdmin);
        if(!Boolean.TRUE.equals(isAdmin)){
            return Result.fail(411, "权限不足");
        }
        AdminUserVo adminUserVo = adminMapper.findUserByAccount(account);
        return Result.success(adminUserVo);
    }

    //管理员封禁
    @Override
    public Result ban(String account) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Boolean isAdmin = (Boolean) map.get("role");
        if(!Boolean.TRUE.equals(isAdmin)){
            return Result.fail(411, "权限不足");
        }
        adminMapper.banUserByAccount(account);
        return Result.success(null);
    }
}