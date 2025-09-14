package com.inabananami.japanesedemo.config;

import com.inabananami.japanesedemo.interceptor.UserStatusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final UserStatusInterceptor userStatusInterceptor;

    public WebConfig(UserStatusInterceptor userStatusInterceptor) {
        this.userStatusInterceptor = userStatusInterceptor;
    }

    //全局CORS配置
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5501", "http://localhost:5501")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true)
                        .allowedHeaders("Authorization", "Content-Type")
                        .maxAge(3600);  // 缓存预检请求的有效时间
            }
        };
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userStatusInterceptor)
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/user/login", "/user/sign-up");   //排除登录注册等不需要的路径
    }
}