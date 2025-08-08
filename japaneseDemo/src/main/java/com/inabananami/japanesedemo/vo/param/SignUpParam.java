package com.inabananami.japanesedemo.vo.param;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpParam {
    @NotNull(message = "电邮不得为空")
    private String email;
    @Pattern(regexp = "^\\S{1,12}", message = "用户名介于1-12个字符")
    private String account;
    @Pattern(regexp = "^\\S{7,12}", message = "密码介于7-12位")
    private String password;
    @Pattern(regexp = "^\\S{1,12}", message = "昵称介于1-12个字符")
    private String nickname;
}