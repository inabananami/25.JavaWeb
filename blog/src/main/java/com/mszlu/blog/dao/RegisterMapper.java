package com.mszlu.blog.dao;

import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.vo.params.LoginParams;

public interface RegisterMapper {

    //注册功能
    void register(SysUser sysUser);
}