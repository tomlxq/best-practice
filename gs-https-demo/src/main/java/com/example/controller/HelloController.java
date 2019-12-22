package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.config.MultienvConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/18
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private ApplicationArguments args;
    @Autowired
    private MultienvConfig multienvConfig;

    @GetMapping("/hello")
    public String hello() {
        return JSON.toJSONString(args.getNonOptionArgs());
    }

    @GetMapping
    public String index() {
        log.info("测试的域名：" + multienvConfig.getDomain());
        return multienvConfig.getDomain();
    }
}
