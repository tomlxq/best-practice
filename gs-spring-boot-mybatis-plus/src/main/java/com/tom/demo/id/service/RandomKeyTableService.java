package com.tom.demo.id.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.demo.id.entity.UserKeyRandom;
import com.tom.demo.id.mapper.UserKeyRandomMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description: RandomKeyTableService
 * @Author: TomLuo
 * @CreateDate: 2023年06月19日 4:57
 * @Version: V1.0
 */
@Service
public class RandomKeyTableService extends ServiceImpl<UserKeyRandomMapper, UserKeyRandom> implements UserKeyRandomService {
    public List<UserKeyRandom> getInsertData() {

        return IntStream.range(0, 10000).boxed().map(idx -> {
            final UserKeyRandom userKeyRandom = new UserKeyRandom();
            userKeyRandom.setId(ThreadLocalRandom.current().nextLong());
            userKeyRandom.setUserId(ThreadLocalRandom.current().nextLong());
            userKeyRandom.setUsername(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyRandom.setSex(ThreadLocalRandom.current().nextInt());
            userKeyRandom.setAddress(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyRandom.setCity(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyRandom.setEmail(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyRandom.setState(ThreadLocalRandom.current().nextInt());
            return userKeyRandom;
        }).collect(Collectors.toList());
    }
}