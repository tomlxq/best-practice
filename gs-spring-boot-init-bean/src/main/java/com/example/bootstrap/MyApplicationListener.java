package com.example.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * qqq
 *
 * @author TomLuo
 * @date 2023年06月04日 15:39
 */
@Component
@Slf4j
public class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        log.info("事件触发：" + event.getClass().getName());
        final ApplicationContext application = event.getApplicationContext();
        // 通过 SpringApplication 注册 ApplicationContextInitializer
        //application.addBeanFactoryPostProcessor(new MyApplicationContextInitializer());
    }

}