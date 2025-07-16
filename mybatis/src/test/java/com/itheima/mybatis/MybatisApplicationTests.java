package com.itheima.mybatis;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest  //springboot整合单元测试的注释
class MybatisApplicationTests {
    @Autowired
    private UserMapper UserMapper;

    @Test
    void contextLoads() {
        List<User> userList = UserMapper.list();
        userList.stream().forEach(User -> {
            System.out.println(User);
        });
    }
}
