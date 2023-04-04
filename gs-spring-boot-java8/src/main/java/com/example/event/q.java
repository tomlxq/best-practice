package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * q
 *
 * @author TomLuo
 * @date 2023年03月24日 0:16
 */
@Component
@Slf4j
class MyInitializingBean implements InitializingBean {



    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean#afterPropertiesSet()");
    }

}