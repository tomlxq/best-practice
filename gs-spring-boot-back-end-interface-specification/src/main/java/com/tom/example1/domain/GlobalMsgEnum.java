package com.tom.example1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * GlobalMsgEnum
 *
 * @author TomLuo
 * @date 2023年05月13日 4:44
 */
@Getter
@AllArgsConstructor
public enum GlobalMsgEnum {
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
