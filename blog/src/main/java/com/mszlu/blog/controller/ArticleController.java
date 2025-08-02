package com.mszlu.blog.controller;

import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.pojo.Article;
import com.mszlu.blog.service.ArticleService;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //Result是统一结果返回
    @PostMapping()
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }

    //最热文章
    @PostMapping("/hot")
    public Result hotArticles() {
        int limit = 3;
        List<Article> hotArticles = articleService.hotArticles(limit);
        return Result.success(hotArticles);
    }
    //最新文章
    @PostMapping("/new")
    public Result newArticle() {
        int limit = 3;
        List<Article> newArticles = articleService.newArticles(limit);
        return Result.success(newArticles);
    }
    //文章归档
    @PostMapping("/listArchives")
    public Result listArticles() {
        return articleService.listArticles();
    }
}