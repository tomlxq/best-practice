package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * eeee
 *
 * @author TomLuo
 * @date 2023年03月23日 23:31
 */
@Component
@Slf4j
public class MyNoAnnotationListener implements ApplicationListener<MyTestEvent> {

    @Override
    public void onApplicationEvent(MyTestEvent event) {
        log.info("非注解监听器：{} {}" ,event.getClass().getName(), event.getMsg());
    }

}
