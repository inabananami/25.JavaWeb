package com.itheima.anno;

import com.itheima.validator.ArticleStateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ArticleStateValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "文章状态只能是“草稿”或“已发布”";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}