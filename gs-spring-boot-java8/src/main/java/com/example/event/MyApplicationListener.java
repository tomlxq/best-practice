package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * aaa
 *
 * @author TomLuo
 * @date 2023年03月23日 23:28
 */
@Component
@Slf4j
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("事件触发：" + event.getClass().getName());
    }
}
