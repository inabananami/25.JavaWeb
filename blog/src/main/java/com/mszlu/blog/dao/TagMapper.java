package com.mszlu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    //分页
    List<Tag> findTagsByArticleId(Long articleId);


    //最热标签
    List<Long> findHotsTagIds(int limit);

    //最热标签
    @Select("select * from tag where id in #{tagIds}")
    List<Tag> findTagsByTagIds(List<Long> tagIds);
}