package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);
}
