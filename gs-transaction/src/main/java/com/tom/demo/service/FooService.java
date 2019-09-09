package com.tom.demo.service;

import com.tom.demo.dto.Foo;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/8
 */

public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
