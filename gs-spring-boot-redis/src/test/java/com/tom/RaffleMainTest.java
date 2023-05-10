package com.tom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * qqqq
 *
 * @author TomLuo
 * @date 2023年04月30日 6:06
 */
@Slf4j
@SpringBootTest
public class RaffleMainTest {
    private final String KEY_RAFFLE_PROFIX = "raffle:";
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test() {
        Integer raffleId = 1;
        join(raffleId, 1000, 1001, 2233, 7890, 44556, 74512);
        List lucky = lucky(raffleId, 2);
        logger.info("活动：{} 的幸运中奖用户是：{}", raffleId, lucky);
    }

    public void join(Integer raffleId, Integer... userIds) {
        String key = KEY_RAFFLE_PROFIX + raffleId;
        redisTemplate.opsForSet().add(key, userIds);
    }

    public List lucky(Integer raffleId, long num) {
        String key = KEY_RAFFLE_PROFIX + raffleId;
        // 随机抽取 抽完之后将用户移除奖池
        List list = redisTemplate.opsForSet().pop(key, num);
        // 随机抽取 抽完之后用户保留在池子里
        //List list = redisTemplate.opsForSet().randomMembers(key, num);
        return list;
    }

}