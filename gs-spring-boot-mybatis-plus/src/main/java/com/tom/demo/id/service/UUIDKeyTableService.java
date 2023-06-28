package com.tom.demo.id.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.demo.id.entity.UserKeyUUID;
import com.tom.demo.id.mapper.UserKeyUUIDMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description: UUIDKeyTableService
 * @Author: TomLuo
 * @CreateDate: 2023年06月19日 4:56
 * @Version: V1.0
 */
@Service
public class UUIDKeyTableService extends ServiceImpl<UserKeyUUIDMapper, UserKeyUUID> implements UserKeyUUIDService {

    private final long workerId = 0;
    private final long datacenterId = 1;


    public List<UserKeyUUID> getInsertData() {
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return IntStream.range(0, 10000).boxed().map(idx -> {
            final UserKeyUUID userKeyUUID = new UserKeyUUID();
            userKeyUUID.setId(snowflake.nextId());
            userKeyUUID.setUserId(ThreadLocalRandom.current().nextLong());
            userKeyUUID.setUsername(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyUUID.setSex(ThreadLocalRandom.current().nextInt());
            userKeyUUID.setAddress(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyUUID.setCity(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyUUID.setEmail(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyUUID.setState(ThreadLocalRandom.current().nextInt());
            return userKeyUUID;
        }).collect(Collectors.toList());
    }
}