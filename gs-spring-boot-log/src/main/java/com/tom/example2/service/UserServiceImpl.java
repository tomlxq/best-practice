package com.tom.example2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年03月06日 21:48
 */
@Slf4j
@Service
public class UserServiceImpl implements UseService {
    @Async("MyExecutor")
    @Override
    public void insertUser() throws InterruptedException {
        sleep(2000);
        log.info("executing insert user...");
    }
}