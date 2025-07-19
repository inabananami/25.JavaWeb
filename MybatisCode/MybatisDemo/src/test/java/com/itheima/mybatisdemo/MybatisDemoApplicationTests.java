package com.itheima.mybatisdemo;

import com.itheima.mybatisdemo.mapper.EmpMapper;
import com.itheima.mybatisdemo.project.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {
    @Autowired
    private EmpMapper EmpMapper;

    @Test
//    void contextLoads() {
////        List<Emp> empList = EmpMapper.list();
////        empList.stream().forEach(Emp -> {
////            System.out.println(Emp);
////        });
////    }
    //删除类
//    public void testDelete(){
//        EmpMapper.delete(16);
//    }

    //添加类
//    public void testIncert(){
//        Emp emp = new Emp();
//        emp.setId(1);
//        emp.setUsername("Tommao");
//        emp.setName("汤姆dada");
//        emp.setImage("1.jpg");
//        emp.setGender((short)1);
//        emp.setJob((short)1);
//        emp.setEntrydate(LocalDate.of(2025,07,15));
//        emp.setUpdateTime(LocalDateTime.now());
//        emp.setDeptId(1);
//
//        //执行新增员工信息操作
//        EmpMapper.update(emp);
//        System.out.println(emp.getId());
//    }

    //查询操作
//    public void testGetById() {
//        Emp emp = EmpMapper.getById(10);
//        System.out.println(emp);
//    }
    //条件查询
    public void testGet() {
        List<Emp> empList = EmpMapper.list("张", (short)1, LocalDate.of(2000,1,1),LocalDate.of(2020,1,1));
        empList.forEach(System.out::println);
    }
}