package com.tom.logging.log4j2;


import com.tom.example1.domain.User;
import com.tom.example1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/27
 */
@SpringBootTest
public class Log4j2ExampleTest {
@Autowired
UserMapper userMapper;
    @Test
    public void test1() {
        //...
        User user = userMapper.selectById(1L);
        Assert.notNull(user, "用户不存在.");
        //...
    }

    @Test
    public void test2() {
        // 另一种写法
        User user = userMapper.selectById(1L);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在.");
        }
    }
}