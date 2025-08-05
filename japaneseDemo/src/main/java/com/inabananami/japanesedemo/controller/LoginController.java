package com.inabananami.japanesedemo.controller;

import com.inabananami.japanesedemo.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping()
    public Result login() {

        return Result.success(null);
    }
}
