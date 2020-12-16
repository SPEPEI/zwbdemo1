package com.example.demo.entity;

import com.example.demo.enums.ErrCode;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public JsonResult() {
        this.code = ErrCode.OK.getCode();
        this.msg = ErrCode.OK.getMsg();
    }

    public JsonResult(ErrCode err) {
        this(err, null);
    }

    public JsonResult(ErrCode err, T data) {
        this.code = err.getCode();
        this.msg = err.getMsg();
        this.data = data;
    }

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
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
}
