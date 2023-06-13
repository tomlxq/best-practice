package com.tom.redislimiter.controller;


import com.tom.redislimiter.annotation.MyRedisLimiter;
import com.tom.redislimiter.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试限流controller
 *
 * @author TomLuo
 * @date 2023年05月27日 20:58
 */

@RestController
public class TestLimiterController {


    @MyRedisLimiter(key = "limitTest", count = 2)
    @RequestMapping(value = "/limitTest")
    public Long limitTest() {
        System.out.println("limitTest");
        return 1L;
    }


    @MyRedisLimiter(key = "customer_limit_test", period = 10, count = 3, limitType = LimitType.CUSTOMER)
    @GetMapping("/limitTest2")
    public Integer testLimiter2() {
        System.out.println("limitTest2");

        return 1;
    }


    @MyRedisLimiter(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.IP)
    @GetMapping("/limitTest3")
    public Integer testLimiter3() {
        System.out.println("limitTest3");

        return 3;
    }
}
