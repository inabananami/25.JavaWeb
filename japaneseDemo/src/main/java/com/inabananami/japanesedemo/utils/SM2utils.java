package com.inabananami.japanesedemo.utils;

import com.inabananami.japanesedemo.dao.mapper.ReviewMapper;
import com.inabananami.japanesedemo.dao.pojo.ReviewLog;
import com.inabananami.japanesedemo.vo.param.ReviewParam;
import org.springframework.beans.factory.annotation.Autowired;

public class SM2utils {

    //SM2算法核心逻辑
    public static ReviewParam calculate(int quality, int prevInterval, int prevRepetition, double prevEaseFactor) {
        double newEaseFactor = calculateEaseFactor(prevEaseFactor,quality);
        int newRepetition = quality < 3 ? 0 : prevRepetition + 1;
        System.out.println("quality: " + quality);
        System.out.println("newRepetition:"+newRepetition);
        int newInterval = calculateInterval(newRepetition, prevInterval, newEaseFactor, quality);
        return new ReviewParam(newEaseFactor, newRepetition, newInterval);
    }

    //计算新的ef
    public static double calculateEaseFactor(double ef, int quality) {
        double newEf = ef + (0.1 - (5 - quality) * (0.08+ (5 - quality) * 0.02));
        return Math.max(1.3, newEf);
    }

    //计算间隔天数
    public static int calculateInterval(int prevrepetition, int prevInterval, double ef, int quality) {
        if (quality < 3) return 1;
        if (prevrepetition == 1) return 1;
        if (prevrepetition == 2) return 6;
        return (int) Math.round(prevInterval * ef);
    }
}
