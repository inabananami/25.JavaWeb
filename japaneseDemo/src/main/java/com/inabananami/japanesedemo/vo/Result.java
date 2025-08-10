package com.inabananami.japanesedemo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return new Result(true,200,"操作成功",data);
    }
    public static Result fail(Integer code, String msg) {
        return new Result(false,code,msg,null);
    }
}