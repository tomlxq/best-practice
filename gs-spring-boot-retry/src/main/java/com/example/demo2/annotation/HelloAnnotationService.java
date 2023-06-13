package com.example.demo2.annotation;

import com.example.demo2.HelloRetryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年05月27日 13:29
 */
@Service
@Slf4j
public class HelloAnnotationService {
    private static AtomicLong helloTimes = new AtomicLong();
    @Retryable(retryCount = 4, retryInterval = 1)
    public String hello() {
        long times = helloTimes.incrementAndGet();
        if (times % 4 != 0) {
            log.warn("发生异常，time：{}", LocalTime.now());
            throw new HelloRetryException("发生Hello异常");
        }
        return "hello";
    }
}