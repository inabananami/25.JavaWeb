package com.inabananami.japanesedemo.interceptor;

import com.inabananami.japanesedemo.utils.JwtUtil;
import com.inabananami.japanesedemo.utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String token = request.getHeader("Authorization");
         //校验token
         if (token == null || token.isEmpty()) {
             //Result.fail() errorcode: 406
             response.setStatus(406);
             return false;
         }
         //验证token并存入ThreadLocal
         try {
             Claims claims = JwtUtil.parseToken(token);
             Integer userId = ((Number) claims.get("userId")).intValue();
             String status = (String) claims.get("status");
             //存入ThreadLocal
             Map<String,Object> userInfo = new HashMap<>();
             userInfo.put("userId", userId);
             userInfo.put("status", status);
             ThreadLocalUtil.set(userInfo);
             return true;
         } catch(Exception e) {
             response.setStatus(406);
             return false;
         }
     }
}
