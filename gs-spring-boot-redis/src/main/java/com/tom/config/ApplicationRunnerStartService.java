package com.tom.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月01日 23:05
 */
@Component  //被 spring 容器管理
@Order(1)
@Slf4j
//如果多个自定义的 ApplicationRunner  ，用来标明执行的顺序
public class ApplicationRunnerStartService implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("===SpringBoot项目启动后，执行ApplicationRunnerStartService方法，进行初始化操作 =============");
    }

}
