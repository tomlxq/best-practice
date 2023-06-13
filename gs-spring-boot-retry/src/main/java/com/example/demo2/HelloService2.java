package com.example.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * wwww
 *
 * @author TomLuo
 * @date 2023年05月26日 6:28
 */
@Slf4j
@Component
public class HelloService2  implements IHelloService{
    private static AtomicLong helloTimes = new AtomicLong();
    @Override
    public String hello() {
        long times = helloTimes.incrementAndGet();
        if (times % 4 != 0) {
            log.warn("发生异常，time：{}", LocalTime.now());
            throw new HelloRetryException("发生Hello异常");
        }
        return "hello";
    }

}