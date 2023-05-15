package com.guide.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * a222
 *
 * @author TomLuo
 * @date 2023年05月14日 19:06
 */
@SpringBootApplication
@MapperScan("com.guide.example.mapper")
public class ExcelUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelUtilsApplication.class, args);
    }

}