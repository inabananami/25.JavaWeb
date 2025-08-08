package com.inabananami.japanesedemo.service;

import com.inabananami.japanesedemo.vo.Result;

public interface ReviewService {
    //复习单词算法
    Result review(Integer id, int quality);
    //判断可不可以复习
    Result canReview(Integer wordId);
}