package com.tom.redis.bitmap_sign_by_range;


import com.tom.redis.bitmap_sign_by_range.SignByMonthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * SignTest2
 *
 * @author TomLuo
 * @date 2023年05月07日 16:52
 */
@SpringBootTest
@Slf4j
public class SignTest2 {
    @Autowired
    private SignByMonthServiceImpl signByMonthService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 测试用户按月签到
     */
    @Test
    public void querySignDay() {
        //模拟用户签到
        for(int i=5;i<19;i++){
        redisTemplate.opsForValue().setBit("UserId:Sign:560:2022-08", 0, true);
        }

        System.out.println("560用户今日是否已签到:" + this.signByMonthService.checkSign("560"));
        Map<String, Boolean> stringBooleanMap = this.signByMonthService.querySignedInMonth("560");
        System.out.println("本月签到情况:");
        for (Map.Entry<String, Boolean> entry : stringBooleanMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "√" : "-"));
        }
        long countSignedInDayOfMonth = this.signByMonthService.countSignedInDayOfMonth("560");
        System.out.println("本月一共签到:" + countSignedInDayOfMonth + "天");
        System.out.println("目前连续签到:" + this.signByMonthService.queryContinuousSignCount("560", 7) + "天");
    }
}