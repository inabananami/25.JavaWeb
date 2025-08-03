package com.mszlu.blog.others;

import org.apache.commons.codec.digest.DigestUtils;

public class PassWordEncryptMain {
    public static void main(String[] args) {
        String password = "146146";
        String salt = "mszlu!@#";

        String encryptedPassword = DigestUtils.md5Hex(password + salt);
        System.out.println(encryptedPassword);
    }
}
