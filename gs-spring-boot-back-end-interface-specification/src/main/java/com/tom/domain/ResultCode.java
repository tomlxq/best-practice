package com.tom.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultCode
 *
 * @author TomLuo
 * @date 2023年05月11日 6:04
 */
@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(1000, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(5000, "未知错误");
    private int code;
    private String msg;
}
