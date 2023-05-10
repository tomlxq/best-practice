package com.tom;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * QueueTest
 *
 * @author TomLuo
 * @date 2023年05月07日 21:56
 */
@SpringBootTest
@Slf4j
public class QueueTest {
    private static final String REDIS_LP_QUEUE = "redis:lp:queue";
    private static final String REDIS_RP_QUEUE = "redis:rp:queue";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 先进后出队列
     */
    @Test
    public void rightMonitor() {
        while (true) {
            Object o = stringRedisTemplate.opsForList().rightPop(REDIS_LP_QUEUE, 0, TimeUnit.SECONDS);
            logger.info("先进后出队列 接收到数据：{}", o);
        }
    }

    /**
     * 先进先出队列
     */
    @Test
    public void leftMonitor() {
        while (true) {
            Object o = stringRedisTemplate.opsForList().leftPop(REDIS_RP_QUEUE, 0, TimeUnit.SECONDS);
            logger.info("先进先出队列 接收到数据：{}", o);
        }
    }
}