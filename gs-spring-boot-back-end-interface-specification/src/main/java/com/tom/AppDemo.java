package com.tom;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * AppDemo 使用 SpringBoot 配置 FTP 服务器，上传、删除、下载文件
 *
 * @author TomLuo
 * @date 2023年04月19日 6:26
 */
@SpringBootApplication
@Slf4j
@ComponentScan({"springfox.documentation.schema"})
public class AppDemo {
    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class, args);
    }


}