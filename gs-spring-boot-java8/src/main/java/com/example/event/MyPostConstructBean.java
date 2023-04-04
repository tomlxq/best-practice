package com.example.event;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月24日 0:13
 */
@Component
@DependsOn("myApplicationListener")
@Slf4j
public class MyPostConstructBean {


    @PostConstruct
    void postConstruct(){
        log.info("@PostConstruct");
    }

}