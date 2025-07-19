package com.itheima.mybatisdemo.mapper;

import com.itheima.mybatisdemo.project.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //根据id动态删除数据
//    @Delete("delete from emp where id = #{id}")
//    public void delete(int id);

    //新增操作
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
//                "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
//    public void insert(Emp emp);

    //更新操作
//    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
//    public void update(Emp emp);

    //查询操作
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(int id);

    //方案一：给字段起别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id" +
//            "create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

    //方案二：通过@Results，@Result注解手动映射封装
//    @Select("select * from emp where id = #{id}")
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "update_time", property = "updateTime"),
//            @Result(column = "create_time", property = "createTime")
//    })
//    public Emp getById(Integer id);

    //条件查询
    @Select("select * from emp where name like concat('%','张','%') and gender = #{gender} " +
                 "and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);
}