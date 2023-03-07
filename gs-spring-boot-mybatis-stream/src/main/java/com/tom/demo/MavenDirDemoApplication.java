package com.tom.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.tom.demo.mapper")

public class MavenDirDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(MavenDirDemoApplication.class, args);
    }


}
