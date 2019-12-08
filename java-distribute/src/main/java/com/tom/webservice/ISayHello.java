package com.tom.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SE和SEI的实现类
 *
 * @author TomLuo
 * @date 2019/12/7
 */
@WebService
public interface ISayHello {
    /**
     * SEI中的方法
     *
     * @param hello
     * @return
     */
    @WebMethod
    String sayHello(String hello);
}
