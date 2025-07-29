package com.itheima.japanesedemo.mapper;

import com.itheima.japanesedemo.pojo.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface WordMapper {
    @Insert("insert into word(japanese_word,chinese_word,romaji,kana,type,example_sentence,create_user,create_time,update_time)" +
            "values(#{japaneseWord},#{chineseWord},#{romaji},#{kana},#{type},#{exampleSentence},#{createUser},now(),now())")
    void add(Word word);

    void update(Word word);
}