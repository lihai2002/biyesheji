package com.lihai.biyesheji.common;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Result<T> {
    /*响应码*/
    private int code;
    /*响应消息*/
    private String msg;
    /*数据单元*/
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    操作成功
    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

//    操作成功并返回数据
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }


//    操作失败返回
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
