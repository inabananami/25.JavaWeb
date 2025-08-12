package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.service.AdminService;
import com.inabananami.japanesedemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //根据account寻找用户
    @GetMapping("/search")
    public Result findUserByAccount(@RequestParam String account) {
        return adminService.findUserByAccount(account);
    }
    //封禁用户
    @PostMapping("/ban")
    public Result banUser(@RequestParam String account) {
        return adminService.ban(account);
    }
}