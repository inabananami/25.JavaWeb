package com.inabananami.japanesedemo.service.impl;

import com.inabananami.japanesedemo.dao.mapper.ReviewMapper;
import com.inabananami.japanesedemo.dao.mapper.WordMapper;
import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import com.inabananami.japanesedemo.dao.pojo.Word;
import com.inabananami.japanesedemo.service.ReviewService;
import com.inabananami.japanesedemo.service.WordService;
import com.inabananami.japanesedemo.utils.SM2utils;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import com.inabananami.japanesedemo.vo.Result;
import com.inabananami.japanesedemo.vo.param.ReviewParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private WordService wordService;

    @Override
    public Result review(Integer id, int quality) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        Word word = wordService.findWordById(id);
        if (word.getCreateUser().equals(userId)) {
            return Result.fail(408, "无权访问这个单词");
        }
        ReviewLog reviewLog = reviewMapper.findReviewByWordId(word.getId());
        if(quality != 0 && quality != 3 && quality !=5) {
            return Result.fail(400, "quality不合法！");
        }else {
            //计算出review参数
            ReviewParam reviewParam= SM2utils.calculate(quality,reviewLog.getIntervalDays(),reviewLog.getRepetition(),reviewLog.getEaseFactor());
            System.out.println(reviewParam.getRepetition());
            //构造新的reviewLog并交给mapper
            reviewMapper.updateReviewLog(ReviewLog.updateReviewLog(reviewParam, reviewLog, quality));
            return Result.success(null);
        }
    }

    @Override
    public Result canReview(Integer wordId) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        ReviewLog reviewLog = reviewMapper.findByUserIdAndWordId(userId, wordId);
        //判断该不该复习
        boolean isCanReview = reviewLog != null && LocalDateTime.now().isAfter(reviewLog.getNextReviewTime());
        if (reviewLog == null) return Result.fail(401, "未找到复习记录");
        if (!isCanReview) return Result.fail(402, "复习时间未到");
        return Result.success(isCanReview);
    }
}