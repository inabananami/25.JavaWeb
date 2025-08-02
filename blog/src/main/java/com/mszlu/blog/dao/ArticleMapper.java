package com.mszlu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    //最热文章
    List<Article> getArticleByViewCounts(int limit);

    //最新文章
    List<Article> getArticleByCreateDate(int limit);

    //文章归档
    List<Archives> listArticles();
}