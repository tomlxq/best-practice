package com.example.goodcontroller;

import lombok.Data;

/**
 * DTO
 *
 * @author TomLuo
 * @date 2023年03月24日 6:22
 */
@Data
public class TestDTO {
    private Integer num;
    private String type;

    public void setEmail(String email) {
    }
}