package com.itheima.springbootmybatis.service.impl;

import com.itheima.springbootmybatis.mapper.EmpMapper;
import com.itheima.springbootmybatis.pojo.Emp;
import com.itheima.springbootmybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }
}
