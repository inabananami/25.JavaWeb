package com.inabananami.japanesedemo.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserParam {
    private String nickname;
    private String japaneseLevel;
    private Integer knownWordCount;
    private Integer streak;
    private boolean admin;
}