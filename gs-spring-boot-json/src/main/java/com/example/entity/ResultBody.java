package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * ResultBody
 *
 * @author TomLuo
 * @date 2023年04月19日 22:33
 */
@Data
public class ResultBody {
    public static <T> ResultBody success(T data) {
        return new ResultBody(data);
    }

    // 状态码
    private int code;

    // 状态信息
    private String msg;

    // 返回对象
    private Object data;

    // 手动设置返回vo
    public ResultBody(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 默认返回成功状态码，数据对象
    public ResultBody(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码，数据对象
    public ResultBody(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    // 只返回状态码
    public ResultBody(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}