package com.tom.demo;

import com.google.common.collect.ImmutableMap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringApplicationDemo
 *
 * @author TomLuo
 * @date 2019/9/3
 */
@SpringBootApplication
@MapperScan("com.tom.demo.mapper")
public class SpringApplicationDemo {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringApplicationDemo.class);
        app.setDefaultProperties(ImmutableMap.of("mpw.key", "816992b4d56f4614"));
        app.run(args);

    }
}
