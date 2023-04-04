package com.example.event;

import com.example.other.GsConsumingRestApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AppDemo
 *
 * @author TomLuo
 * @date 2023年03月23日 23:27
 */
@SpringBootApplication(scanBasePackages ="com.example.event" )
public class AppDemo {
    public static void main(String args[]) {
        SpringApplication.run(AppDemo.class);
    }
}