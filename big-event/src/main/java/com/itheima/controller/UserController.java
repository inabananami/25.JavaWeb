package com.itheima.controller;

import com.itheima.exception.GlobalExceptionHandler;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private com.itheima.service.UserService UserService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        //用户名是否已被占用
        User u = UserService.findByUserName(username);
        if (u == null) {
            //没有占用
            //注册
            UserService.register(username, password);
            return Result.success();
        } else {
            //占用
            return Result.error("用户名已被占用！");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //根据用户名查询User
        User loginUser = UserService.findByUserName(username);
        //判断是否查询到
        if(loginUser == null) {
            return Result.error("用户名错误");
        }else{
            //判断密码是否正确 loginUser对象中的password是密文
            if(Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
                //登录成功
                //生成token
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", loginUser.getId());
                claims.put("username", loginUser.getUsername());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            }
            return Result.error("密码错误！");
        }
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        //根据用户名查询用户
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = UserService.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        UserService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl) {
        UserService.updateAvatar(avatarUrl);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        //1. 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("密码不能为空！");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = UserService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码填写不正确！");
        }
        //newPwd和rePwd是否一样
        if(!rePwd.equals(newPwd)) {
            return Result.error("两次填写的新密码不一样");
        }
        //2.调用service完成密码更新
        UserService.updatePwd(newPwd);
        return Result.success();
    }
}