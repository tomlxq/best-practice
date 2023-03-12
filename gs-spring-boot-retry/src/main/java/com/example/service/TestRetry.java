package com.example.service;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月12日 23:13
 */
@Component
@Slf4j
public class TestRetry {

    int a = 0;

    @Retryable(recover = "recoverTest1", value = {RuntimeException.class}, maxAttempts = 5, backoff = @Backoff(delay = 1000, multiplier = 2))
    public String test() {
        a++;
        log.info(a + " - " + System.currentTimeMillis());
        Preconditions.checkArgument(a >= 10, "未满足条件");
        return "执行成功";
    }

    @Recover
    public String recoverTest(RuntimeException e) {
        return "回调方法-" + e.getMessage();
    }

    @Recover
    public String recoverTest1(RuntimeException e) {
        return "回调方法1-" + e.getMessage();
    }
}