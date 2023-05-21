package com.tom.example1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * ThreadPoolConfig ThreadPoolConfig.java 定义线程池，交给spring管理
 *
 * @author TomLuo
 * @date 2023年03月06日 21:54
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    /**
     * 声明一个线程池
     *
     * @return 执行器
     */
    @Bean("MyExecutor")
    public Executor asyncExecutor() {
        MyThreadPoolTaskExecutor executor = new MyThreadPoolTaskExecutor();
        //核心线程数5：线程池创建时候初始化的线程数
        executor.setCorePoolSize(5);
        //最大线程数5：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(5);
        //缓冲队列500：用来缓冲执行任务的队列
        executor.setQueueCapacity(500);
        //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        executor.setKeepAliveSeconds(60);
        //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("asyncTom");
        executor.initialize();
        return executor;
    }
}