package com.tom.demo.id.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.demo.id.entity.UserKeyAuto;
import com.tom.demo.id.mapper.UserKeyAutoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description: AutoKeyTableService
 * @Author: TomLuo
 * @CreateDate: 2023年06月19日 4:56
 * @Version: V1.0
 */
@Service
public class AutoKeyTableService extends ServiceImpl<UserKeyAutoMapper, UserKeyAuto> implements UserKeyAutoService {
    public List<UserKeyAuto> getInsertData() {
        return IntStream.range(0, 10000).boxed().map(idx -> {
            final UserKeyAuto userKeyAuto = new UserKeyAuto();
            userKeyAuto.setUserId(ThreadLocalRandom.current().nextLong());
            userKeyAuto.setUsername(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyAuto.setSex(ThreadLocalRandom.current().nextInt());
            userKeyAuto.setAddress(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyAuto.setCity(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyAuto.setEmail(String.valueOf(ThreadLocalRandom.current().nextInt()));
            userKeyAuto.setState(ThreadLocalRandom.current().nextInt());
            return userKeyAuto;
        }).collect(Collectors.toList());
    }
}