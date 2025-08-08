package com.inabananami.japanesedemo.dao.pojo;

import com.inabananami.japanesedemo.vo.param.ReviewParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLog {
    private int id;
    private int userId;
    private int wordId;
    private int quality;
    private LocalDateTime reviewTime;
    private double easeFactor;
    private int intervalDays;
    private LocalDateTime nextReviewTime;
    private int repetition;

    public static ReviewLog defaultSet(Word word) {
        ReviewLog reviewLog = new ReviewLog();
        reviewLog.setWordId(word.getId());
        reviewLog.setUserId(word.getCreateUser());
        reviewLog.setReviewTime(now());
        reviewLog.setNextReviewTime(reviewLog.getReviewTime().plusDays(1));
        return reviewLog;
    }

    public static ReviewLog updateReviewLog(ReviewParam reviewParam, ReviewLog reviewLog, int quality) {
        reviewLog.setReviewTime(LocalDateTime.now());
        reviewLog.setEaseFactor(reviewParam.getEasefactor());
        reviewLog.setRepetition(reviewParam.getRepetition());
        reviewLog.setIntervalDays(reviewParam.getInterval());
        reviewLog.setQuality(quality);
        reviewLog.setNextReviewTime(reviewLog.getReviewTime().plusDays(reviewLog.getIntervalDays()));
        return reviewLog;
    }
}