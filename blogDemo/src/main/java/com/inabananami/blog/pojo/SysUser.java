package com.inabananami.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Long id;
    private String account;
    private Integer admin;
    private String avatar;
    private LocalDate createDate;
    private Integer deleted;
    private String email;
    private Long lastLogin;
    private String mobilePhoneNumber;
    private String nickname;
    private String password;
    private String salt;
    private String status;
}
