package com.inabananami.japanesedemo.config;

import com.inabananami.japanesedemo.interceptor.LoginInterceptor;
import com.inabananami.japanesedemo.interceptor.UserStatusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/user/**", "/review/**")  //需要登录的接口
                .excludePathPatterns("/user/login", "/user/sign-up");  //不拦截这些路径
        registry.addInterceptor(new UserStatusInterceptor())
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/user/login", "/user/sign-up");   //排除登录注册等不需要的路径
    }

    //注册已封禁/已注销用户拦截器
    @Bean
    public UserStatusInterceptor userStatusInterceptor() {
        return new UserStatusInterceptor();
    }
}