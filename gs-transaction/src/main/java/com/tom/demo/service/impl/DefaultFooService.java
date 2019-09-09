package com.tom.demo.service.impl;

import com.tom.demo.dto.Foo;
import com.tom.demo.service.FooService;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/8
 */
public class DefaultFooService implements FooService {

    @Override
    public Foo getFoo(String fooName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insertFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }

}