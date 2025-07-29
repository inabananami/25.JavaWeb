package com.inabananami.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inabananami.blog.mapper.ArticleMapper;
import com.inabananami.blog.pojo.Article;
import com.inabananami.blog.pojo.Result;
import com.inabananami.blog.service.ArticleService;
import com.inabananami.blog.vo.ArticleVo;
import com.inabananami.blog.vo.params.PageParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶进行排序
        queryWrapper.orderByDesc(Article::getWeight);

        //按照日期倒序排序
        queryWrapper.orderByDesc(Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page,queryWrapper);

        List<ArticleVo> articleVoList = copyList(records);
    }
    private List<ArticleVo> articleVoList = copyList(List<Article> records) {
        return null;
    }

    private ArticleVo copy(Article article) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        return articleVo;
    }
}
