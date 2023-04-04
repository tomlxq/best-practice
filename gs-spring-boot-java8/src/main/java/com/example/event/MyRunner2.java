package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * eeee
 *
 * @author TomLuo
 * @date 2023年03月23日 23:56
 */
@Component
@Order(value = 1000)
@Slf4j
public class MyRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        log.info("CommandLineRunner#run -- @Order(value = 1000)");
    }
}