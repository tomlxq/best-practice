package com.tom.example1.config;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年03月01日 23:06
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Slf4j
@Component  //被 spring 容器管理
@Order(10)  //如果多个自定义的 CommandLineRunner，用来标明执行的顺序，数字越小，顺序越靠前
public class CommandLineRunnerStartService  implements CommandLineRunner{


    @Override
    public void run(String... args) throws Exception {
        logger.info("===SpringBoot项目启动后，执行CommandLineRunnerStartService方法，进行初始化操作 =============");

    }

}
