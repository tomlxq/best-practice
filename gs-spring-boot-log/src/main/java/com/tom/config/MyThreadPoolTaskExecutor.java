package com.tom.config;

import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * MyThreadPoolTaskExecutor 将父线程的trackId传递下去给子线程即可
 *
 * @author TomLuo
 * @date 2023年03月06日 21:55
 */
public final class MyThreadPoolTaskExecutor  extends ThreadPoolTaskExecutor {
    public MyThreadPoolTaskExecutor() {
        super();
    }

    @Override
    public void execute(Runnable task) {
        super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }


    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }
}