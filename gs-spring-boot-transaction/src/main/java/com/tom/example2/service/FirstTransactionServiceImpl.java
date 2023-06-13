package com.tom.example2.service;

import com.tom.entities.User;
import com.tom.enums.SexEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * FirstTransactionServiceImpl
 *
 * @author TomLuo
 * @date 2023年05月14日 9:00
 */
@Service
@RequiredArgsConstructor
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
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
        User user = new User(null, "tx1", "111", SexEnum.MAN, 0, null, null);
        userService.save(user);
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void createUser1() {
        User userPO = new User();
        userPO.setRealName("baiyanEventTest");
        userPO.setNickname("柏炎事务测试");
        userPO.setSex(SexEnum.MAN);
        userPO.setVersion(1);
        userService.save(userPO);
    }

    /**
     * 在createUser中调用了内部方法createUser1，并且createUser1方法上设置了事务传播策略为：REQUIRES_NEW，
     * 但是因为是内部直接调用，createUser1不能不代理处理，无法进行事务管理。
     * 在createUser方法抛出异常后就插入数据失败了。
     * 但是这种操作在我们业务开发的过程中貌似还挺常见的，怎么样才能保证其成功呢？
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser() {
        this.createUser1();
        throw new RuntimeException();
    }

    /**
     * 默认情况下事务仅回滚运行时异常和Error，不回滚受检异常（例如IOException）。
     * 因此如果方法中抛出了IO异常，默认情况下事务也会回滚失败。
     * 我们可以通过指定@Transactional(rollbackFor = Exception.class)的方式进行全异常捕获。
     */
    @Override
    @Transactional
    public void createUserWithRuntimeException() {
        //同一事务，不回滚受检异常
        userService.createUser2();
        throw new RuntimeException();
    }
    @Override
    @Transactional
    public void createUserWithCheckException() throws IOException {
        //同一事务，不回滚受检异常
        userService.createUser2();
        throw new IOException();
    }
    @Override
    @Transactional
    public void createUserWithUncheckException() throws IOException {
        //有自己的事务不回滚
        userService.createUser1();
        throw new IOException();
    }

    /**
     * 方式1：新建一个Service，将方法迁移过去，有点麻瓜。
     * 方式2：在当前类注入自己，调用createUser1时通过注入的userService调用
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserWithInterface() {
        userService.createUser1();
        throw new RuntimeException();
    }

    /**
     * 方式3：通过AopContext.currentProxy()获取代理对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserWithAopProxy() {
        ((FirstTransactionService) AopContext.currentProxy()).createUser1();
        throw new RuntimeException();
    }



    /*
     * （3）异常被内部catch
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserWithTryCatch() {
        try {
            userService.createUser1();
            throw new RuntimeException();
        } catch (Exception e) {
        }
    }
}