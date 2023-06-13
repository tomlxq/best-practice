package com.example;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AppDemo
 * org.springframework.context.support.AbstractApplicationContext#refresh()
 * org.springframework.context.support.AbstractApplicationContext#finishBeanFactoryInitialization(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 * org.springframework.beans.factory.support.DefaultListableBeanFactory#preInstantiateSingletons()
 * public class ConfigurationClassPostProcessor implements BeanDefinitionRegistryPostProcessor
 *
 * @author TomLuo
 * @date 2023年04月19日 6:26
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.example.mapper")//扫描mapper文件夹
public class AppInitDemo {


    public static void main(String[] args) {

       // SpringApplication.run(AppInitDemo.class, args);
        SpringApplication application = new SpringApplication(AppInitDemo.class);
        // 通过 SpringApplication 注册 ApplicationContextInitializer
        //application.addInitializers(new MyApplicationContextInitializer());
        application.run(args);
    }


}