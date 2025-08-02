package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.dao.pojo.Tag;
import com.mszlu.blog.vo.TagVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagsService {

    List<TagVo> findTagsByArticleId(Long id);

    //最热标签
    Result hots(int limit);
}
