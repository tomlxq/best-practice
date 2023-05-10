package com.tom;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * BFTest
 *
 * @author TomLuo
 * @date 2023年05月07日 6:02
 */
@SpringBootTest
@Slf4j
public class RedisBloomTest {

    private final String KEY_WEB_CRAWLER = "web:crawler1";

    @Autowired
    RedisBloom bloom;

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void test() {
        Boolean hasKey = redisTemplate.hasKey(KEY_WEB_CRAWLER);
        logger.info("bloom hasKey:{}", hasKey);
        if (!hasKey) {
            // 不存在的时候  再去初始化
            Boolean bfreserve = bloom.bfreserve(KEY_WEB_CRAWLER, 0.0001, 10000);
            logger.info("bloom bfreserve:{}", bfreserve);
        }
        List<Integer> madd = bloom.bfmadd(KEY_WEB_CRAWLER, "baidu", "google");
        logger.info("bloom bfmadd:{}", madd);

        Boolean baidu = bloom.bfexists(KEY_WEB_CRAWLER, "baidu");
        logger.info("bloom bfexists baidu:{}", baidu);

        Boolean bing = bloom.bfexists(KEY_WEB_CRAWLER, "bing");
        logger.info("bloom bfexists bing:{}", bing);
    }
}