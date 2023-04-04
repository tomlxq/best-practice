package com.example.calfuntime;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FunTimeTest
 *
 * @author TomLuo
 * @date 2023年03月24日 5:57
 */
@Slf4j
public class FunTimeTest {
    /**
     * ① StopWatch
     * 第一种玩法，spring util 里面提供的 StopWatch
     *
     * @throws InterruptedException
     */
    @Test
    public void stopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(5);
//doInsert();
//执行业务等
        stopWatch.stop();
        log.info("{}", stopWatch.getTotalTimeMillis());
    }

    /**
     * ②  System.nanoTime()
     *
     * @throws InterruptedException
     */
    @Test
    public void nanoTime() throws InterruptedException {
        long startTime = System.nanoTime();
        //执行业务
        TimeUnit.SECONDS.sleep(5);

        long endTime = System.nanoTime();
        log.info("{}", (endTime - startTime));
    }

    /**
     * ③ new Date()
     * 第三种玩法 ，平时偶尔也看到别人这么写 new Date
     *
     * @throws InterruptedException
     */
    @Test
    public void date() throws InterruptedException {
        Date startDate = new Date();
//执行业务等
        TimeUnit.SECONDS.sleep(5);
        Date endDate = new Date();
        log.info("{}", (endDate.getTime() - startDate.getTime()));
    }

    /**
     * ④  System.currentTimeMillis()
     *
     * @throws InterruptedException
     */
    @Test
    public void currentTimeMillis() throws InterruptedException {
        final long begin = System.currentTimeMillis();

        TimeUnit.SECONDS.sleep(5);
        log.info("{}", (System.currentTimeMillis() - begin));
    }

    @Test
    public void stopWatchPrettyPrint() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("任务名称");

        // 任务1
        stopWatch.start("任务一");
        Thread.sleep(1000);
        stopWatch.stop();

        // 任务2
        stopWatch.start("任务二");
        Thread.sleep(2000);
        stopWatch.stop();

        // 打印出耗时
        log.info("{}", stopWatch.prettyPrint());
    }


}