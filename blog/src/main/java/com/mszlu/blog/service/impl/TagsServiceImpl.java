package com.mszlu.blog.service.impl;

import com.mszlu.blog.dao.TagMapper;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.dao.pojo.Tag;
import com.mszlu.blog.service.TagsService;
import com.mszlu.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        //标签所拥有的文章数最热
        //根据tag_id分组计数，从大到小排列，去前limit个
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(tagIds)) {
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        List<TagVo> tagVoList = copyList(tagList);
        return Result.success(tagVoList);
    }
}