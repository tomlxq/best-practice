package com.tom.webservice;

import javax.jws.WebService;

/**
 * SE和SEI的实现类
 *
 * @author TomLuo
 * @date 2019/12/7
 */
@WebService
public class SayHello implements ISayHello {

    @Override
    public String sayHello(String name) {
        return "hello," + name;
    }
}
