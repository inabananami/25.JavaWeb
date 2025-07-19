package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper  //在运行是，会自动生成该接口的类对象，并且将该对象交给IOC容器管理
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from User")
    public List<User> list();
}