package com.inabananami.japanesedemo;

import com.inabananami.japanesedemo.utils.BCryptUtil;

class JapaneseDemoApplicationTests {
    public static void main(String[] args) {
        System.out.println(BCryptUtil.encode("password123"));
    }
}
