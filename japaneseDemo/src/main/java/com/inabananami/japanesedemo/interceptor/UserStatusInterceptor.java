package com.inabananami.japanesedemo.interceptor;

import com.inabananami.japanesedemo.dao.mapper.UserMapper;
import com.inabananami.japanesedemo.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.inabananami.japanesedemo.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserStatusInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer userId = (Integer) request.getSession().getAttribute("user");
        if (userId == null) {
            throw new UnauthorizedException("未登录");
        }
        User user = userMapper.findUserById(userId);
        if (user == null) {
            throw new UnauthorizedException("无效用户");
        }
        String status = user.getStatus();
        if ("inactive".equals(status) || "banned".equals(status)) {
            throw new UnauthorizedException("您的账户状态异常，无法操作");
        }
        return true;
    }
}