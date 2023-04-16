package com.example.demo.proxy.javaapi;


import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public class PersonBeanTest {
    public static void main(String[] args) {
        PersonBean personBean = new PersonBeanImpl("TOM", "男", new Date(), "swimming");
        PersonBean myPerson = (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
        PersonBean myPerson1 = (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
        System.out.println(myPerson.getName());
        myPerson.setName("haha");
        System.out.println(myPerson.getName());

        System.out.println(myPerson1.getName());
        myPerson1.setName("haha");
        System.out.println(myPerson1.getName());
    }
}
