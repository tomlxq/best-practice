package com.example.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ee
 *
 * @author TomLuo
 * @date 2023年03月23日 23:34
 */
@RestController
@RequiredArgsConstructor
public class TestEventListenerController {
    private final MyTestEventPublisher publisher;
    @RequestMapping(value = "/test/testPublishEvent1" )
    public void testPublishEvent(){
        publisher.pushListener("我来了！");
    }
}
