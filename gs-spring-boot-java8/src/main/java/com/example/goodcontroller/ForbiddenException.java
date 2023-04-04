package com.example.goodcontroller;

/**
 * 自定义异常
 *
 * @author TomLuo
 * @date 2023年03月24日 6:39
 */
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}