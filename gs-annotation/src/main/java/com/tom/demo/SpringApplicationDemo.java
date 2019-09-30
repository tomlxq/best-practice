package com.tom.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringApplicationDemo
 *
 * @author TomLuo
 * @date 2019/9/3
 */
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class SpringApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationDemo.class, args);
    }


}
