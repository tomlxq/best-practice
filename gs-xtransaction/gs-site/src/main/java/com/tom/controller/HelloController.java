package com.tom.controller;

import com.alibaba.fastjson.JSON;
import com.tom.dto.DoOrderRequest;
import com.tom.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/4
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    @Qualifier(value = "orderServices")
    private OrderService orderService;

    @GetMapping
    public String sayHello() {

        DoOrderRequest doOrderRequest = new DoOrderRequest("tom");
        log.info("请求到门户：{}", JSON.toJSONString(doOrderRequest));
        orderService.doOrder(doOrderRequest);
        return "hello";
    }

}
