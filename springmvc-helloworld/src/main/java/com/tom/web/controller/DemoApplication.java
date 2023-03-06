package com.tom.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * DemoApplication
 *
 * @author TomLuo
 * @date 2023年03月01日 21:02
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        //application.addListeners(new EnvironmentPreparedListener());
        //--mpw.key=7a10eda6bd25ae0c  --spring.profiles.active=pro
        application.run(args);
        //SpringApplication.run(DemoApplication.class,args);
    }
}