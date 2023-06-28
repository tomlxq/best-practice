package com.example.data.masking.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: xxx
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 11:28
 * @Version: V1.0
 */

@Data
public class TestDTO implements Serializable {
    /**
     * 手机号
     */
    @JsonSerialize(using = TestJacksonSerialize.class)
    private String phone;
}