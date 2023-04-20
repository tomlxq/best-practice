package com.tom.demo.controller;

/**
 * 动态修改该定时任务的执行时间
 *
 * @author TomLuo
 * @date 2023年04月20日 22:52
 */

import com.tom.demo.config.ScheduleTask;
import com.tom.demo.config.ScheduleTask2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final ScheduleTask scheduleTask;
    private final ScheduleTask2 scheduleTask2;
    @GetMapping("/updateCron")
    public String updateCron(String cron) {
        log.info("new cron :{}", cron);
        scheduleTask.setCron(cron);
        return "ok";
    }

    @GetMapping("/updateTimer")
    public String updateTimer2(Long timer) {
        log.info("new timer :{}", timer);
        scheduleTask2.setTimer(timer);
        return "ok";
    }
}