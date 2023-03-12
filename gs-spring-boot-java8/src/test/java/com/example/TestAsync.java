package com.example;

import com.example.config.AppConfig;
import com.example.lib.UserTranUtils;
import com.example.lib.UserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TestAsync
 *
 * @author TomLuo
 * @date 2023年03月12日 4:34
 */
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class TestAsync {

    @Autowired
    @Qualifier(value = "taskExecutor")
     private  ThreadPoolTaskExecutor taskExecutor;

    @Test
    public  void name() {
        ThreadLocal<Integer> user = new ThreadLocal<>();
        user.set(123);
        int userId = user.get();
        log.info("master thread user Id {}", userId);
        CompletableFuture.runAsync(() -> {
            user.set(userId);
            log.info("user Id {}", user.get());
        });
    }

    @Test
    public  void name2() {
        UserUtils.setUserId(123L);
        Long userId = UserUtils.getUserId();
        log.info("master thread user Id {}", userId);
        CompletableFuture.runAsync(() -> {
            log.info("son thread user Id {}", UserUtils.getUserId());
        });
    }

    @Test
    public void name3() {
        UserUtils.setUserId(123L);
        Long userId = UserUtils.getUserId();
        log.info("master thread user Id {}", userId);
        CompletableFuture.runAsync(() -> {
            log.info("slave user Id {}", UserUtils.getUserId());
        }, taskExecutor);
    }
    @Test
   public void name4() {
        UserTranUtils.setUserId(123L);
        Long userId = UserTranUtils.getUserId();
        log.info("master thread user Id {}", userId);
        CompletableFuture.runAsync(() -> {
            log.info("slave user Id {}", UserTranUtils.getUserId());
        });
    }
}