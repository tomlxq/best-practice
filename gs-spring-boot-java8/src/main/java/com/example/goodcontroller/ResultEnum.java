package com.example.goodcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 常用结果的枚举
 *
 * @author TomLuo
 * @date 2023年03月24日 6:15
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum implements IResult {
    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");
    @Setter
    @Getter

    private Integer code;
    @Setter
    @Getter
    private String message;


}