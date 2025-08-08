package com.inabananami.japanesedemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserVo extends UserVo {
    private Integer id;
    private Boolean banned;
    private Boolean admin;
    private String email;
    private String phoneNumber;
}