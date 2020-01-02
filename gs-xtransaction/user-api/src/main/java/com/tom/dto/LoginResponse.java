package com.tom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Data
@NoArgsConstructor
public class LoginResponse {
    public LoginResponse(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    private String code;
    private String desc;
    private Object data;
}
