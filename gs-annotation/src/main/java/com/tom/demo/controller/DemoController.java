package com.tom.demo.controller;

import com.tom.demo.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/3
 */
@RestController
public class DemoController {
    @Autowired
    FooService fooService;

    @GetMapping
    public String index() throws Exception {
        fooService.add(22);
        fooService.del();
        fooService.query();
        fooService.update();
        return "hello";
    }
}
