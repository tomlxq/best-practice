package com.tom.demo.mapper;



import com.tom.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试乐观锁
 *
 * @author TomLuo
 * @date 2023年03月05日 18:26
 */
@SpringBootTest(args = {"--mpw.key=816992b4d56f4614"})
@MapperScan("com.tom.demo.mapper")
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