package com.tom.demo.mapper;

import com.tom.demo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试乐观锁
 *
 * @author TomLuo
 * @date 2023年03月05日 18:26
 */
public class OptimisticTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 成功案例
     */
    @Test
    public void versionTest() {
        User user = userMapper.selectById(1L);
        user.setName("派大星");
        user.setEmail("admin@qq.com");
        userMapper.updateById(user);
    }

    /**
     * 乐观锁失败案例----多线程
     */
    @Test
    public void OptimisticLockerTest() {
        User user = userMapper.selectById(1L);
        user.setName("派大星111");
        user.setEmail("admin@qq.com");

        //模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user.setName("派大星222");
        user.setEmail("admin@qq.com");
        userMapper.updateById(user2);

        userMapper.updateById(user);
    }
}