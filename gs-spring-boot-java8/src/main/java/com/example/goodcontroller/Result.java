package com.example.goodcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回数据结构
 *
 * @author TomLuo
 * @date 2023年03月24日 6:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static Result<?> failed() {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
    }

    public static Result<?> failed(String message) {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), message, null);
    }

    public static Result<?> failed(IResult errorResult) {
        return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result<?> failed(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }
}