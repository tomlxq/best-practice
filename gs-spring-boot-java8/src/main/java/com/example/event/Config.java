package com.example.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月23日 23:43
 */
@Configuration
@Slf4j
public class Config {
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        log.info("@EventListener ApplicationEvent事件触发：{}" , event.getClass().getName());
    }


    @EventListener
    public void listener1(MyTestEvent event) {
        log.info("@EventListener MyTestEvent事件触发:{}" , event.getMsg());
    }



}
