package com.tom.redislimiter;

/**
 * RedisLimiterApplication
 *
 * @author TomLuo
 * @date 2023年05月27日 21:00
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLimiterApplication.class, args);
    }

}
