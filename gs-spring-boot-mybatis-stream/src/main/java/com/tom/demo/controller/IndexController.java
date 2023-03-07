package com.tom.demo.controller;

import com.tom.demo.domain.Foo;
import com.tom.demo.mapper.FooMapper;
import lombok.RequiredArgsConstructor;
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
 * IndexController
 *
 * @author TomLuo
 * @date 2023年03月06日 22:54
 */
@RestController
@RequiredArgsConstructor
public class IndexController {
    final FooMapper fooMapper;

    final SqlSessionFactory sqlSessionFactory;

    final PlatformTransactionManager transactionManager;

    @GetMapping("foo/scan/0/{limit}")
    public void scanFoo0(@PathVariable("limit") int limit) throws Exception {
        // 1
        try (Cursor<Foo> cursor = fooMapper.scan(limit)) {
            cursor.forEach(foo -> {
                // 2
            });
        }
    }

    @GetMapping("foo/scan/1/{limit}")
    public void scanFoo1(@PathVariable("limit") int limit) throws Exception {
        // 1
        // 2
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<Foo> cursor =
                        sqlSession.getMapper(FooMapper.class).scan(limit)
        ) {
            cursor.forEach(foo -> {
            });
        }
    }

    @GetMapping("foo/scan/2/{limit}")
    public void scanFoo2(@PathVariable("limit") int limit) throws Exception {
        // 1
        // 2
        TransactionTemplate transactionTemplate =
                new TransactionTemplate(transactionManager);

        transactionTemplate.execute(status -> {
            try (Cursor<Foo> cursor = fooMapper.scan(limit)) {
                cursor.forEach(foo -> {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @GetMapping("foo/scan/3/{limit}")
    @Transactional
    public void scanFoo3(@PathVariable("limit") int limit) throws Exception {
        try (Cursor<Foo> cursor = fooMapper.scan(limit)) {
            cursor.forEach(foo -> { });
        }
    }
}