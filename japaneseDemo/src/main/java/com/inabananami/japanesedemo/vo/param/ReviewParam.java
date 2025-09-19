package com.inabananami.japanesedemo.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewParam {
    private double easefactor;
    private int repetition;
    private int interval;
}