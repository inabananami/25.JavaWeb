package com.inabananami.japanesedemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordVo {
    private String japaneseWord;
    private String chineseWord;
    private String romaji;
    private String kana;
    private String type;
    private String exampleSentence;
}