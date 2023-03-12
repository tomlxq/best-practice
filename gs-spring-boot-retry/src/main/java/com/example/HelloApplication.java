package com.example;

import com.example.service.RetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * eeee
 *
 * @author TomLuo
 * @date 2023年03月12日 21:54
 */
@EnableRetry
@SpringBootApplication
@RequiredArgsConstructor
public class HelloApplication implements CommandLineRunner {
    private final RetryService retryService;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        retryService.test(0);
    }
}