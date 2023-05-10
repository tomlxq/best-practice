package com.tom;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * HeyperLogLog 统计UV
 *
 * @author TomLuo
 * @date 2023年05月06日 6:18
 */
@SpringBootTest
@Slf4j
public class UVTest {
    private final String KEY_UV_PAGE_PROFIX = "uv:page:";

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void uvTest() {
        Integer pageId = 2;
        for (int i = 0; i < 10000; i++) {
            uv(pageId, i);
        }
        for (int i = 0; i < 10000; i++) {
            uv(pageId, i);
        }

        Long uv = getUv(pageId);
        logger.info("pageId:{} uv:{}", pageId, uv);
    }

    /**
     * 用户访问页面
     *
     * @param pageId
     * @param userId
     * @return
     */
    private Long uv(Integer pageId, Integer userId) {
        String key = KEY_UV_PAGE_PROFIX + pageId;
        return redisTemplate.opsForHyperLogLog().add(key, userId);
    }

    /**
     * 统计页面的UV
     *
     * @param pageId
     * @return
     */
    private Long getUv(Integer pageId) {
        String key = KEY_UV_PAGE_PROFIX + pageId;
        return redisTemplate.opsForHyperLogLog().size(key);
    }
}