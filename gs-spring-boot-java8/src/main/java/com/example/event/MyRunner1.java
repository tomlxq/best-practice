package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * order的规则：
 *
 * order的值越小，优先级越高
 * order如果不标注数字，默认最低优先级，因为其默认值是int最大值
 * 该注解等同于实现Ordered接口getOrder方法，并返回数字。
 *
 * @author TomLuo
 * @date 2023年03月23日 23:56
 */
@Component
@Order(value = -1000)
@Slf4j
public class MyRunner1 implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {

        log.info("CommandLineRunner#run -- @Order(value = -1000)");
    }
}