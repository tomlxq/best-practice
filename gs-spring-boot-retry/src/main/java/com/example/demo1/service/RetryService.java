package com.example.demo1.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

/**
 * TestRetryService
 *
 * @author TomLuo
 * @date 2023年03月12日 21:57
 */
public interface RetryService {
    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    int test(int code) throws Exception;
}
