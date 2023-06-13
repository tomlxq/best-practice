package com.example.demo2.annotation;

import com.example.demo2.HelloRetryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
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
public class HelloSpringRetryService {
    private static AtomicLong helloTimes = new AtomicLong();

    /**
     * 方法调用将会在抛出HelloRetryException异常后进行重试，最大重试次数为5，
     * 第一次重试间隔为1s，之后以2倍大小进行递增，
     * 第二次重试间隔为2s，
     * 第三次为4s，
     * 第四次为8s
     * @return
     */
    @org.springframework.retry.annotation.Retryable(
            value ={HelloRetryException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1000,multiplier = 2)

    )

    public String hello() {
        long times = helloTimes.incrementAndGet();
        log.info("hello times:{}", times);
        if (times % 4 != 0) {
            log.warn("发生异常，time：{}", LocalTime.now());
            throw new HelloRetryException("发生Hello异常");
        }
        return "hello";
    }
    @Recover
    public boolean recover(Exception e){
        log.error("达到最大重试次数",e);
        return false;
    }
}