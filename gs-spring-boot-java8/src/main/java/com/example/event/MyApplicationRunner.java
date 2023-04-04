package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * eeee
 *
 * @author TomLuo
 * @date 2023年03月24日 0:06
 */
@Component
@Order(-2000)
@Slf4j
public class MyApplicationRunner implements ApplicationRunner {



    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner#run() -- @Order(-2000) {}",args.getOptionValues("foo"));
    }

}