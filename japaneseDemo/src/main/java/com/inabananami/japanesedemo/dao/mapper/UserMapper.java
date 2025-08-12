package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.dto.UserDto;
import com.inabananami.japanesedemo.vo.UserVo;
import com.inabananami.japanesedemo.vo.param.SignUpParam;
import com.inabananami.japanesedemo.vo.param.UserParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //用户注册
    void signUp(SignUpParam signUpParam);
    //通过用户名寻找用户
    User findUserByAccount(String account);
    //更新日期
    void setTimeWhenLogin(Integer userId);
    //查询用户(by id)
    User findUserById(Integer userId);
    //模糊查询用户
    List<UserVo> search(String keyword);
    //更新用户
    void update(UserDto userDto);
    //注销用户
    void delete(Integer id);
}