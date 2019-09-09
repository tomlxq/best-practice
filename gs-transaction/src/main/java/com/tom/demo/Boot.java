package com.tom.demo;

import com.tom.demo.dto.Foo;
import com.tom.demo.service.FooService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/8
 */
@MapperScan(basePackages = "com.tom.demo.repository")
@SpringBootApplication
public  class Boot {

    public static void main(final String[] args) throws Exception {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context.xml");
        //FooService fooService = (FooService) ctx.getBean("fooService");
        // fooService.insertFoo (new Foo());
        SpringApplication.run(Boot.class, args);
    }
}


