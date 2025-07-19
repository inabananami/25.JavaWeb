package com.itheima.springbootmybatis.mapper;

import com.itheima.springbootmybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, " +
            "create_time createTime, update_time updateTime from emp where id = #{id}")
    public Emp getById(Integer id);
}