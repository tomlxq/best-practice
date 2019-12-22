package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.config.MultienvConfig;
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
public class TestController {
    @GetMapping
    public String hello() {
        return "hello,world";
    }

    @Autowired
    private ApplicationArguments args;
    @Autowired
    private MultienvConfig multienvConfig;

    @GetMapping("/index")
    public String index() {
        System.out.println(multienvConfig.getPort());
        return JSON.toJSONString(args.getNonOptionArgs());
    }
}
