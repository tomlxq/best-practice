package com.example.async.A7第三方异步框架如Hutool的ThreadUtil;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 4.7 ThreadUtil异步工具类
 *
 * @author TomLuo
 * @date 2023年03月22日 23:29
 */
@Slf4j
public class ThreadUtils {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            ThreadUtil.execAsync(() -> {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                int number = threadLocalRandom.nextInt(20) + 1;
                System.out.println(number);
            });
            log.info("当前第：" + i + "个线程");
        }

        log.info("task finish!");
    }
}