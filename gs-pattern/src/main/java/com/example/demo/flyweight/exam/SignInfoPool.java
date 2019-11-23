package com.example.demo.flyweight.exam;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
@Data
public class SignInfoPool extends SignInfo {
    public SignInfoPool(String key) {
        this.key = key;
    }

    private String key;
}
