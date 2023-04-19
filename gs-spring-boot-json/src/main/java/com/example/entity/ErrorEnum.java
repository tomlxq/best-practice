package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 错误枚举，拒绝硬编码 ErrorEnum
 *
 * @author TomLuo
 * @date 2023年03月06日 20:09
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum ErrorEnum {
    // 数据操作错误定义
    SUCCESS(200, "成功"),
    NO_PERMISSION(403,"你没得权限"),
    NO_AUTH(401,"未登录"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器异常请联系管理员"),
    ;

    /** 错误码 */
    private Integer errorCode;

    /** 错误信息 */
    private String errorMsg;
}