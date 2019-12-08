package com.tom.webserviceclient;

import java.net.MalformedURLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class Bootstrap {
    public static void main(String[] args) throws MalformedURLException {
        SayHelloService sayHelloService = new SayHelloService();
        SayHello sayHelloPort = sayHelloService.getSayHelloPort();
        System.out.println(sayHelloPort.sayHello("rose"));

       /* URL url=new URL("http://localhost:9000/hello?wsdl");
        QName qname=new QName("http://webservice.tom.com/", "SayHelloService");
        Service service=Service.create(url,qname);
        ISayHello   sayHelloPort=service.getPort(ISayHello.class);//这个是依赖了本地产生代码的接口。
        System.out.println(sayHelloPort.sayHello("tom"));*/
    }
}
