package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.vo.AdminUserVo;
import com.inabananami.japanesedemo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //根据用户名寻找用户
    AdminUserVo findUserByAccount(String account);
    //管理员封禁
    void ban(Integer id);
}