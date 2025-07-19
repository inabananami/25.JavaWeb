package com.itheima.springbootmybatis.controller;

import com.itheima.springbootmybatis.pojo.Emp;
import com.itheima.springbootmybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;


    @RequestMapping("/info")
    public Emp findById(Integer id) {
        return empService.getById(10);
    }
}
