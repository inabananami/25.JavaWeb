package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.UserMapper;
import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.dto.UserDto;
import com.inabananami.japanesedemo.service.UserService;
import com.inabananami.japanesedemo.utils.BCryptUtil;
import com.inabananami.japanesedemo.utils.JwtUtil;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.UserVo;
import com.inabananami.japanesedemo.vo.param.SignUpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //用户注册
    public Result signUp(SignUpParam signUpParam) {
        String encodedPassWord = BCryptUtil.encode(signUpParam.getPassword());
        signUpParam.setPassword(encodedPassWord);
        userMapper.signUp(signUpParam);
        return Result.success(null);
    }
    //用户登录(通过用户名查找用户)
    public Result login(String account, String password) {
        User user = userMapper.findUserByAccount(account);
        //判断用户是否存在/密码是否正确
        if (user == null || !BCryptUtil.checkPassword(password, user.getPassword())) {
            return Result.fail(405,"密码不正确");
        }
        //构建claims
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("status", user.getStatus());
        claims.put("role", user.getAdmin() == 1);

        //生成并返回token
        String token = JwtUtil.generateToken(claims);
        userMapper.setTimeWhenLogin(user.getId());
        return Result.success(token);
    }
    //更新用户信息
    @Override
    public Result update(UserDto userDto) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        userDto.setUserId(userId);
        userMapper.update(userDto);
        return Result.success(null);
    }
     //查询用户（id）
     @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }
    //模糊查询
    @Override
    public Result search(String keyWord) {
        List<UserVo> userVoList = userMapper.search(keyWord);
        return Result.success(userVoList);
    }
    //注销用户
    @Override
    public Result delete() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        userMapper.delete(userId);
        return Result.success(null);
    }
}