package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.dao.pojo.Word;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {
    //增加单词
    void add(Word word);
    //更新单词
    void update(Word word);
    //删除单词
    void delete(int id);
    //根据日语单词查询单词卡
    List<Word> search(String keyWord);
    //根据id名寻找单词
    Word findWordById(Integer id);
}