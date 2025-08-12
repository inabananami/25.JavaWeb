package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.dto.LoginDto;
import com.inabananami.japanesedemo.dto.UserDto;
import com.inabananami.japanesedemo.service.UserService;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.UserVo;
import com.inabananami.japanesedemo.vo.param.SignUpParam;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //用户注册
    @PostMapping("/sign-up")
    public Result signUp(@RequestBody @Validated SignUpParam signUpParam) {
        return userService.signUp(signUpParam);
    }
    //用户登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        String account = loginDto.getAccount();
        String password = loginDto.getPassword();
        return userService.login(account,password);
    }
    //模糊查询用户
    @GetMapping("/search-user")
    public Result searchUser(@RequestParam String keyWord) {
        return userService.search(keyWord);
    }
    //更新用户信息
    @PostMapping("/update-user-info")
    public Result updateUser(@RequestBody @Validated UserDto userDto) {
         return userService.update(userDto);
    }
    //注销用户
    @PostMapping("/delete-user")
    public Result deleteUser() {
        return userService.delete();
    }
}