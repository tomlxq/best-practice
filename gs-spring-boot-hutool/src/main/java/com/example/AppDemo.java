package com.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * AppDemo
 *
 * @author TomLuo
 * @date 2023年04月19日 6:26
 */
@SpringBootApplication
@Slf4j
public class AppDemo  {


    public static void main(String[] args) {

        SpringApplication.run(AppDemo.class, args);
    }


}