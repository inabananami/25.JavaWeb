package com.inabananami.japanesedemo.exception;

import com.inabananami.japanesedemo.vo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.fail(403, errorMsg);
    }
    @ExceptionHandler(Exception.class)
    public Result handleDuplicateKey(DuplicateKeyException e) {
        return Result.fail(403, "用户名已存在，请更换");
    }
    @ExceptionHandler(UnauthorizedException.class)
    public Result handleUnauthorizedException(UnauthorizedException e) {
        return Result.fail(403, e.getMessage());
    }
    @ExceptionHandler(ForbiddenException.class)
    public Result handleForbiddenException(ForbiddenException e) {
        return Result.fail(403, e.getMessage());
    }
}