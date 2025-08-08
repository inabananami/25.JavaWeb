package com.inabananami.japanesedemo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Pattern(regexp = "^\\S{1,10}$", message = "账号不得为空")
    private String account;

    @Pattern(regexp = "^\\S{7,12}$", message = "密码长度应为7-12位")
    private String password;

    @Pattern(regexp = "^\\d{11}$", message = "手机号必须是11位数字")
    private String phoneNumber;

    @NotNull(message = "邮箱不能为空")
    private String email;

    @Pattern(regexp = "^(男|女|其他)$", message = "性别必须为“男”、“女”、“其他”")
    private String gender;

    private String avatar;

    @Pattern(regexp = "^\\S{5,11}$", message = "昵称长度应为5-11位")
    private String nickname;

    private LocalDate birthday;

    @Pattern(regexp = "^(N1|N2|N3|N4|N5)$", message = "语言等级必须是“N1-N5”之一")
    private String languageLevel;

    private Integer dailyTarget;
}
