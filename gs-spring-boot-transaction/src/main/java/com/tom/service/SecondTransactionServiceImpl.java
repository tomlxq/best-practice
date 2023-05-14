package com.tom.service;

import com.tom.entities.User;
import com.tom.enums.SexEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * SecondTransactionServiceImpl
 *
 * @author TomLuo
 * @date 2023年05月14日 8:23
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SecondTransactionServiceImpl implements SecondTransactionService {
    private final UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transaction2() {
        log.info("do transaction2.....");
        User user = new User(null, "tx1", "111", SexEnum.MAN, 0,null,null);
        // 插入一个用户
        userService.save(user);
        // 跑错了
        throw new RuntimeException();
    }
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    public void transactionNested() {
        log.info("do transaction2.....");
        User user = new User(null, "tx1", "111", SexEnum.MAN, 0,null,null);
        // 插入一个用户
        userService.save(user);
        // 跑错了
        throw new RuntimeException();
    }
}