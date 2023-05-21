package com.example.pattern.singleton;

/**
 * 7. 枚举 实现单例 《Effective Java》第3版推荐的写法
 * JVM来帮我们保证线程安全和单一实例的问题
 * 常见的使用场合：数据库的连接池、Spring中的全局访问点BeanFactory，Spring下的Bean、多线程的线程池、网络连接池等等
 *
 * @author TomLuo
 * @date 2023年05月21日 23:15
 */




public enum SingleInstance {
    INSTANCE;
    public void funDo() {
        System.out.println("doSomething");
    }
}