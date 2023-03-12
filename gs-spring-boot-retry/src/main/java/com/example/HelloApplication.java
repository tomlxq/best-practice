package com.example;

import com.example.service.RetryService;
import com.example.service.TestRetry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 开启spring-retry 启动类上增加注解 @EnableRetry
 *
 * @author TomLuo
 * @date 2023年03月12日 21:54
 */
@EnableRetry
@SpringBootApplication
@RequiredArgsConstructor
public class HelloApplication implements CommandLineRunner {
    private final RetryService retryService;
    private final TestRetry testRetry;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        retryService.test(0);
        testRetry.test();
    }
}