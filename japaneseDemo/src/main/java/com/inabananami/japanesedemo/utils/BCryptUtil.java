package com.inabananami.japanesedemo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //加密密码
    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }
    //校验密码
    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
