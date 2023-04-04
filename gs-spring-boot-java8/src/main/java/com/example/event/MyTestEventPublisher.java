package com.example.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * MyTestEventPublisher
 *
 * @author TomLuo
 * @date 2023年03月23日 23:33
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MyTestEventPublisher {

    private final ApplicationEventPublisher publisher;

    /**
     * 事件发布方法
     */
    public void pushListener(String msg) {
        publisher.publishEvent(new MyTestEvent(this, msg));
    }

}
