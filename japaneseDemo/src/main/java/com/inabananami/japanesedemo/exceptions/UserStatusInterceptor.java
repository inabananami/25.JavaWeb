package com.inabananami.japanesedemo.exceptions;

import com.inabananami.japanesedemo.dao.mapper.UserMapper;
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
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未登录");
            return false;
        }
        User user = userMapper.findUserById(userId);
        if (user == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无效用户");
            return false;
        }
        String status = user.getStatus();
        if("inactive".equals(status) || "banned".equals(status)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "您的账户状态异常，无法操作");
            return false;
        }
        return true;
    }
}

