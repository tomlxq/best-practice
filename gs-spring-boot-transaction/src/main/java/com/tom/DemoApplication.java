package com.tom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UserApplication
 *
 * @author TomLuo
 * @date 2023年05月14日 9:23
 */
//@EnableDiscoveryClient
@MapperScan("com.tom.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


    }

}