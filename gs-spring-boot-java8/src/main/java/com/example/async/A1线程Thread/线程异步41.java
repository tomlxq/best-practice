package com.example.async.A1线程Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * cccc
 *
 * @author TomLuo
 * @date 2023年03月22日 22:53
 */
@Slf4j
public class 线程异步41 {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void fun() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("执行业务逻辑...");
            }
        });
    }
}