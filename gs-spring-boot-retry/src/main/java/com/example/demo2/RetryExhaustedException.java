package com.example.demo2;

/**
 * RetryExhaustedExceptton
 *
 * @author TomLuo
 * @date 2023年05月27日 13:27
 */
public class RetryExhaustedException extends RuntimeException {
    public RetryExhaustedException(String msg, Throwable error) {
        super(msg, error);
    }
}