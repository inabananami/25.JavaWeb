package com.inabananami.japanesedemo.vo.param;

import jakarta.validation.constraints.Pattern;
import jdk.jfr.Percentage;
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