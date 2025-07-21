package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username=#{username}")
    public User findByUserName(String username);

    //添加加密后的md5密码
    @Insert("insert into user(username,password,create_time,update_time)" +
                "values(#{username},#{password},now(),now())")
    void add(@Param("username") String username, @Param("password") String password);
}