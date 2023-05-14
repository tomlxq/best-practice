package com.tom.service;

import com.tom.entities.User;
import com.tom.enums.SexEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FirstTransactionServiceImpl
 *
 * @author TomLuo
 * @date 2023年05月14日 9:00
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FirstTransactionServiceImpl implements FirstTransactionService {
    final private UserService userService;
    final private SecondTransactionService secondTransactionService;

    /**
     * 事务的隔离级别为REQUIRED，那么发现没有事务开启一个事务操作，有的话，就合并到这个事务中，
     * 所以transaction1()、transaction2()是在同一个事务中
     * transaction2()抛出异常，那么事务会被标记为rollback only
     * transaction1()由于try catch异常，正常运行，想必就要可以提交事务了，
     * 在提交事务的时候，会检查rollback标记，如果是true, 这时候就会抛出上面的异常了
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transaction1() {
        log.info("do transaction1 .......");
        try {
            // 调用另外一个事务，try catch住
            secondTransactionService.transaction2();
        } catch (Exception e) {
            log.error("{}", e);
        }

        // 插入当前用户tx1 ThreadLocalRandom.current().nextLong()
        User user = new User(null, "tx1", "111", SexEnum.MAN, 0,null,null);
        userService.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactionInnerNested() {
        log.info("do transaction1 .......");
        try {
            // 调用另外一个事务，try catch住
            secondTransactionService.transactionNested();
        } catch (Exception e) {
            log.error("{}", e);
        }

        // 插入当前用户tx1 ThreadLocalRandom.current().nextLong()
        User user = new User(null, "tx1", "111", SexEnum.MAN, 0,null,null);
        userService.save(user);
    }
}