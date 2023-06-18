package com.example.threadpooltaskexecutor.config;


import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 自定义线程池
 * 发现不是线程数越多越好，具体多少合适，网上有一个不成文的算法：CPU核心数量*2 +2 个线程。
 *
 * @author TomLuo
 * @date 2023年06月13日 20:54
 */
@Configuration
@ComponentScan("com.example.threadpooltaskexecutor")
@MapperScan("com.example.threadpooltaskexecutor.mapper")
@EnableAsync
@Slf4j
public class ThreadPoolConfig {
    //自定义使用参数
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;   //配置核心线程数
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;    //配置最大线程数
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;
    @Value("${async.executor.thread.name.prefix}")
    private String namePrefix;
    @Value("${async.executor.thread.keep_alive_seconds}")
    private int keepAliveSeconds;

    //1、自定义asyncServiceExecutor线程池
    @Bean(name = "asyncServiceExecutor")
    public ThreadPoolTaskExecutor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor......");
        //在这里修改
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //设置线程空闲等待时间 s
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //配置队列大小 设置任务等待队列的大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        //设置线程池内线程名称的前缀-------阿里编码规约推荐--方便出错后进行调试
        executor.setThreadNamePrefix(namePrefix);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    /**
     * 2、公共线程池,利用系统availableProcessors线程数量进行计算
     */
    @Bean(name = "commonThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor commonThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        int processNum = Runtime.getRuntime().availableProcessors(); // 返回可用处理器的Java虚拟机的数量
        int corePoolSize = (int) (processNum / (1 - 0.2));
        int maxPoolSize = (int) (processNum / (1 - 0.5));
        pool.setCorePoolSize(corePoolSize); // 核心池大小
        pool.setMaxPoolSize(maxPoolSize); // 最大线程数
        pool.setQueueCapacity(maxPoolSize * 1000); // 队列程度
        pool.setThreadPriority(Thread.MAX_PRIORITY);
        pool.setDaemon(false);
        pool.setKeepAliveSeconds(300);// 线程空闲时间
        return pool;
    }



    /**
     * 3自定义defaultThreadPoolExecutor线程池
     * @return
     */
    @Bean(name = "defaultThreadPoolExecutor", destroyMethod = "shutdown")
    public ThreadPoolExecutor systemCheckPoolExecutorService() {
        int maxNumPool = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(3,
                maxNumPool,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10000),
                //置线程名前缀，例如设置前缀为hutool-thread-，则线程名为hutool-thread-1之类。
                new ThreadFactoryBuilder().setNamePrefix("default-executor-thread-%d").build(),
                (r, executor) -> log.error("system pool is full! "));
    }

}