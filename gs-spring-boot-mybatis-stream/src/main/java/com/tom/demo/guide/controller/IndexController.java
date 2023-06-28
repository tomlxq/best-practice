package com.tom.demo.guide.controller;

import com.tom.demo.domain.User;
import com.tom.demo.guide.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 三种实现 MyBatis 流式查询的方法
 *
 * @author TomLuo
 * @date 2023年03月06日 22:54
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class IndexController {
    final UserMapper fooMapper;

    final SqlSessionFactory sqlSessionFactory;

    final PlatformTransactionManager transactionManager;

    /**
     * fooMapper 是 @Autowired 进来的。注释 1 处调用 scan 方法，得到 Cursor 对象并保证它能最后关闭；2 处则是从 cursor 中取数据。
     * 执行 queryUserByCursor0() 时会报错：
     * java.lang.IllegalStateException: A Cursor is already closed.
     * 这是因为我们前面说了在取数据的过程中需要保持数据库连接，而 Mapper 方法通常在执行完后连接就关闭了，因此 Cusor 也一并关闭了
     *
     * @param limit
     * @throws Exception
     */
    @GetMapping("foo/scan/0/{limit}")
    public void queryUserByCursor0(@PathVariable("limit") int limit) throws Exception {
        try (Cursor<User> cursor = fooMapper.scan(limit)) {
            cursor.forEach(foo -> {
                log.info("{}", foo);
            });
        }
    }

    /**
     * 可以用 SqlSessionFactory 来手工打开数据库连接，将 Controller 方法修改如下：
     * 1 处我们开启了一个 SqlSession （实际上也代表了一个数据库连接），并保证它最后能关闭
     * 2 处我们使用 SqlSession 来获得 Mapper 对象。
     * 能保证得到的 Cursor 对象是打开状态的。
     *
     * @param limit
     * @throws Exception
     */
    @GetMapping("foo/scan/1/{limit}")
    public void queryUserByCursor1(@PathVariable("limit") int limit) throws Exception {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<User> cursor =
                        sqlSession.getMapper(UserMapper.class).scan(limit)
        ) {
            cursor.forEach(foo -> {
                log.info("{}", foo);
            });
        }
    }

    /**
     * 在 Spring 中，我们可以用 TransactionTemplate 来执行一个数据库事务，
     * 这个过程中数据库连接同样是打开的
     * 1 处我们创建了一个 TransactionTemplate 对象
     * 2 处执行数据库事务，而数据库事务的内容则是调用 Mapper 对象的流式查询。注意这里的 Mapper 对象无需通过 SqlSession 创建。
     *
     * @param limit
     * @throws Exception
     */
    @GetMapping("foo/scan/2/{limit}")
    public void queryUserByCursor2(@PathVariable("limit") int limit) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            try (Cursor<User> cursor = fooMapper.scan(limit)) {
                cursor.forEach(foo -> {
                    log.info("{}", foo);
                });
            } catch (IOException e) {
                log.info("error", e);
            }
            return null;
        });
    }

    /**
     * @param limit
     * @throws IOException
     * @Transactional 注解。这个方案看上去最简洁
     * s但请注意 Spring 框架当中注解使用的坑：只在外部调用时生效 。在当前类中调用这个方法，依旧会报错。
     */
    @GetMapping("foo/scan/3/{limit}")
    @Transactional
    public void queryUserByCursor3(@PathVariable("limit") int limit) {
        try (Cursor<User> cursor = fooMapper.scan(limit)) {
            cursor.forEach(foo -> {
                log.info("{}", foo);
            });
        } catch (IOException e) {
            log.info("error", e);
        }
    }
}