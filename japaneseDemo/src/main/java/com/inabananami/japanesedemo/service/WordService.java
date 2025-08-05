package com.inabananami.japanesedemo.service;

import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.WordVo;

import java.util.List;

public interface WordService {
    //添加单词
    Result add(Word word);

    //更新单词
    Result update(Word word);

    //删除单词
    Result delete(Integer id);

    //按照输入单词模糊查询单词卡
    Result search(String keyWord);
}