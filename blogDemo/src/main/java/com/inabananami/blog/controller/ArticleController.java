package com.inabananami.blog.controller;

import com.inabananami.blog.service.ArticleService;
import com.inabananami.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping()
    public void listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }
}
