package com.inabananami.japanesedemo.interceptor;

import com.inabananami.japanesedemo.dao.mapper.UserMapper;
import com.inabananami.japanesedemo.exception.UnauthorizedException;
import com.inabananami.japanesedemo.utils.JwtUtil;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.inabananami.japanesedemo.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //没有token的情况
        if (token == null) {
            throw new UnauthorizedException("未登录");
        }

        //验证token
        Claims claims;
        try {
            claims = JwtUtil.parseToken(token);
        } catch (Exception e){
            throw new UnauthorizedException("登录状态无效或已过期");
        }

        Integer userId = ((Number) claims.get("userId")).intValue();
        String status = (String) claims.get("status");

        //检查账户状态
        if ("inactive".equals(status) || "banned".equals(status)) {
            throw new UnauthorizedException("账户状态异常，无法操作");
        }

        //存入ThreadLocal
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("status", status);
        ThreadLocalUtil.set(userInfo);

        return true;
    }
}
