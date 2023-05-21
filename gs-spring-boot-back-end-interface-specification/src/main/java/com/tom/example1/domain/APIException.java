package com.tom.example1.domain;

/**
 * ssss
 *
 * @author TomLuo
 * @date 2023年05月13日 4:46
 */
import lombok.Getter;

@Getter //只要getter方法，无需setter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}