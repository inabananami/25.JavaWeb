package com.mszlu.blog.controller;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.service.TagsService;
import com.mszlu.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/hot")
    public Result hot() {
        int limit = 6;
        return tagsService.hots(limit);
    }
}