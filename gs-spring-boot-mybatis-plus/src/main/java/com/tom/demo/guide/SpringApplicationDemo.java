package com.tom.demo.guide;

import com.google.common.collect.ImmutableMap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        args = new String[]{"--spring.config.location=classpath:guide/application.yml"};
        SpringApplication app = new SpringApplication(SpringApplicationDemo.class);
        app.setDefaultProperties(ImmutableMap.of("mpw.key", "816992b4d56f4614"));
        app.run(args);

    }
}
