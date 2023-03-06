package com.tom.web;

import com.tom.service.UseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tom on 2016/5/1.
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    final UseService useService;

    @PostMapping("doTest")
    public String doTest(@RequestParam("name") String name) throws InterruptedException {
        log.info("入参 name={}", name);
        testTrace();
        useService.insertUser();
        log.info("调用结束 name={}", name);
        return "Hello," + name;
    }

    private void testTrace() {
        log.info("这是一行info日志");
        log.error("这是一行error日志");
        testTrace2();
    }

    private void testTrace2() {
        log.info("这也是一行info日志");

    }
}
