package com.tom.example2.service;

import org.springframework.scheduling.annotation.Async;

/**
 * UseService
 *
 * @author TomLuo
 * @date 2023年03月06日 21:46
 */
public interface UseService {
    @Async("myExecutor")
    void insertUser() throws InterruptedException;
}
