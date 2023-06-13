package com.tom;


import com.tom.example2.SpringRedisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * RankingTest
 *
 * @author TomLuo
 * @date 2023年04月30日 6:44
 */
@SpringBootTest(classes = SpringRedisApplication.class)
@Slf4j
public class RankingTest {
    private final String KEY_RANKING = "ranking";
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test() {
        add(1001, (double) 60);
        add(1002, (double) 80);
        add(1003, (double) 100);
        add(1004, (double) 90);
        add(1005, (double) 70);

        // 取所有
        Set<DefaultTypedTuple> range = range(0, -1, true);
        logger.info("所有用户排序：{}", range);

        // 前三名
        range = range(0, 2, true);
        logger.info("前三名排序：{}", range);
    }

    public Boolean add(Integer userId, Double score) {
        Boolean add = redisTemplate.opsForZSet().add(KEY_RANKING, userId, score);
        return add;
    }

    public Set<DefaultTypedTuple> range(long min, long max, boolean increasing) {
        Set<DefaultTypedTuple> set = null;
        if (increasing) {
            // 降序
            set = redisTemplate.opsForZSet().reverseRangeWithScores(KEY_RANKING, min, max);
        } else {
            // 升序
            set = redisTemplate.opsForZSet().rangeWithScores(KEY_RANKING, min, max);
        }
        return set;
    }
}