package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private com.itheima.service.UserService UserService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        //用户名是否已被占用
        User u = UserService.findByUserName(username);
        if (u == null) {
            //没有占用
            //注册
            UserService.register(username,password);
            return Result.success();
        }else {
            //占用
            return Result.error("用户名已被占用！");
        }
    }
}
