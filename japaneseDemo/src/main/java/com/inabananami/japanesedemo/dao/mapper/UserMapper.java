package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询用户(by id)
    User findUserById(Integer userId);
    //模糊查询用户
    List<UserVo> search(String keyword);
    //更新用户
    void update(User user);
    //注销用户
    void delete(Integer id);
    //管理员封禁
    void ban(Integer id);
}