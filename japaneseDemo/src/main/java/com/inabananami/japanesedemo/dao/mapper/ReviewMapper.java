package com.inabananami.japanesedemo.dao.mapper;

import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    //添加默认复习参数
    void defaultAdd(ReviewLog reviewLog);
}