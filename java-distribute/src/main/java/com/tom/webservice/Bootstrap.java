package com.tom.webservice;

import javax.xml.ws.Endpoint;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class Bootstrap {
    public static void main(String[] args) {
        ISayHello sayHello = new SayHello();
        Endpoint.publish("http://localhost:9000/hello", sayHello);
        System.out.println("发布webservice成功了");
    }
}
