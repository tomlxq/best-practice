package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * q
 *
 * @author TomLuo
 * @date 2023年04月06日 0:05
 */
@AllArgsConstructor
@Getter

public enum ResultCode implements StatusCode{
    SUCCESS(1000, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败"),
    ORDER_NOT_EXIST(1004, "定单没有找到"); ;
    private int code;
    private String msg;


}