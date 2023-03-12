package com.example.lib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskDecorator;

/**
 * CustomerTaskDecorator
 *
 * @author TomLuo
 * @date 2023年03月12日 4:47
 */
@Slf4j
public class CustomerTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        try {
            final Long userId = UserUtils.getUserId();
            log.info("master thread user Id {}", userId);
            return () -> {
                UserUtils.setUserId(userId);
                runnable.run();
            };
        }finally {
            UserUtils.clear();
        }
    }
}