package com.itheima.service;

import java.util.List;
import com.itheima.pojo.Category;

public interface CategoryService {
    //新增分类
    void add(Category category);

    //获取分类列表
    List<Category> list();

    //获取文章分类详情
    Category findById(Integer id);

    //更新文章分类
    void update(Category category);

    //删除文章分类
    void delete(Integer id);
}
