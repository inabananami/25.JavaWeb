package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.dao.pojo.User;
import com.inabananami.japanesedemo.service.UserService;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //模糊查询用户
    @GetMapping("/search-user")
    public Result searchUser(String keyWord) {
        return userService.search(keyWord);
    }

    //更新用户信息
    @PostMapping("/update-user-info")
    public Result updateUser(@RequestParam @Validated User user) {
        return userService.update();
    }
    //注销用户
    @PostMapping("/delete-user")
    public Result deleteUser(@Validated Integer id) {
        return userService.delete(id);
    }
    //封禁用户
    @PostMapping("/ban-user")
    public Result banUser(@Validated Integer id) {
        return userService.ban(id);
    }
}