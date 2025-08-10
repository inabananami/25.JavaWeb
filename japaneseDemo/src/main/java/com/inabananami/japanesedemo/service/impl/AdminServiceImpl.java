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
        boolean isAdmin = (boolean) map.get("admin");

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