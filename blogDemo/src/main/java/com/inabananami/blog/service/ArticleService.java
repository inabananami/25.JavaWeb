package com.inabananami.blog.service;

import com.inabananami.blog.vo.params.PageParams;

public interface ArticleService {
    //实现分页查询
    void listArticle(PageParams pageParams);
}
