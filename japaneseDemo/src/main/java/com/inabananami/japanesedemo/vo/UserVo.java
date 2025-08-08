package com.inabananami.japanesedemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String nickname;
    private String gender;
    private String avatar;
    private String languageLevel;
    private Integer dailyTarget;
    private Integer knownWordCount;
}