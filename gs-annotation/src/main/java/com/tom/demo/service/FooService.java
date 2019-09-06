package com.tom.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/3
 */
@Service
@Slf4j
public class FooService {
    public void update() throws RuntimeException {
        log.info("update something");
        throw new RuntimeException("RuntimeException");
    }

    public Integer add(Integer param) {

        log.info("add something {}",param);
        return param;
    }

    public void del() {
        log.info("del something");
    }

    public void query() {
        log.info("query something");
    }
}
