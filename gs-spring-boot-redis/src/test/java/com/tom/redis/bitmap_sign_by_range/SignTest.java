package com.tom.redis.bitmap_sign_by_range;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * SignTest
 *
 * @author TomLuo
 * @date 2023年05月07日 16:57
 */
@SpringBootTest
@Slf4j
public class SignTest {
    @Autowired
    SignByRangeServiceImpl signByRangeService;


    @Test
    void test() {
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        // 活动开始时间
        LocalDateTime start = LocalDateTime.of(2023, 5, 1, 1, 0, 0);
        Integer rangeId = 1;
        Integer userId = 8899;
        logger.info("签到开始时间: {}", start.format(isoDateTime));
        logger.info("活动ID: {} 用户ID: {}", rangeId, userId);

        // 手动指定偏移量签到
        signByRangeService.sign(rangeId, userId, 0);

        // 判断是否签到
        Boolean signed = signByRangeService.checkSign(rangeId, userId, start);
        logger.info("今日是否签到: {}", signed ? "√" : "-");

        // 签到
        Boolean sign = signByRangeService.sign(rangeId, userId, start);
        logger.info("签到操作之前的签到状态：{} （-：表示今日第一次签到，√：表示今天已经签到过了）", sign ? "√" : "-");

        // 签到总数
        long countSigned = signByRangeService.countSigned(rangeId, userId);
        logger.info("总共签到: {} 天", countSigned);

        // 连续签到的次数
        long continuousSignCount = signByRangeService.queryContinuousSignCount(rangeId, userId, start);
        logger.info("连续签到: {} 天", continuousSignCount);

        // 签到的详情
        Map<String, Boolean> stringBooleanMap = signByRangeService.querySigned(rangeId, userId, start);
        for (Map.Entry<String, Boolean> entry : stringBooleanMap.entrySet()) {
            logger.info("签到详情> {} : {}", entry.getKey(), (entry.getValue() ? "√" : "-"));
        }
    }
}