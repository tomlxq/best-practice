package com.tom.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class LoginRequest {
    private String name;
    private String password;
}
