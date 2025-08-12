package com.inabananami.japanesedemo.dao.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(groups = {Find.class})
    private int id;

    @Pattern(regexp = "^\\S{1,10}$", message = "账号不得为空")
    private String account;

    @Pattern(regexp = "^\\S{7,12}$", groups= {Update.class}, message = "密码不得为空")
    private String password;

    @Pattern(regexp = "^\\d{11}$", message = "手机号必须是11位数字")
    private String phoneNumber;

    @NotEmpty(groups = {Update.class})
    private String email;

    @Pattern(regexp = "^(男|女|其他)$", message = "必须为“男”、“女”、“其他”")
    private String gender;

    private String avatar;

    @Pattern(regexp = "^\\S{5,11}$")
    private String nickname;

    private LocalDate birthday;

    @Pattern(regexp = "^(N1|N2|N3|N4|N5)$", message = "必须为“N1-N5”的其中一个等级")
    private String languageLevel;

    private Integer dailyTarget;

    private Integer knownWordCount;

    private Integer streak;

    private short admin;

    @Pattern(regexp = "^(active|inactive|banned|)$", message = "必须为active，inactive，banned的一种")
    private String status;

    private LocalDate createDate;

    private LocalDateTime lastLogin;

    public interface Update {}
    public interface Find {}
}
