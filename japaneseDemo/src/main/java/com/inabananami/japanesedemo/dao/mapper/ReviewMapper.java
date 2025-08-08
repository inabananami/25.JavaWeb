package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    //添加默认复习参数
    void defaultAdd(ReviewLog reviewLog);
    //寻找单词对应的复习表
    ReviewLog findReviewByWordId(Integer id);
    //更新复习状态
    void updateReviewLog(ReviewLog reviewLog);
    //通过用户id和单词id查询reviewLog表
    ReviewLog findByUserIdAndWordId(Integer userId, int wordId);
}