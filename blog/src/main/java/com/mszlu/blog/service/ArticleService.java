package com.mszlu.blog.service;

import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.pojo.Article;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> listArticlesPage(PageParams pageParams);
    //最热文章
    List<Article> hotArticles(int limit);

    //最新文章
    List<Article> newArticles(int limit);

    //文章归档
    Result listArticles();
}