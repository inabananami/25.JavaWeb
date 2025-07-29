package com.inabananami.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inabananami.blog.pojo.Article;
import com.inabananami.blog.vo.params.PageParams;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {


    void list(PageParams pageParams);
}
