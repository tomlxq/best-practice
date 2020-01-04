package com.tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:spring/dubbo.xml"})
public class GsSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(GsSiteApplication.class, args);
    }
}
