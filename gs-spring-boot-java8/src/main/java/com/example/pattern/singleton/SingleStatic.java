package com.example.pattern.singleton;

/**
 * 6.  懒汉式单例--静态工厂版
 * 实现方法的巧妙之处：
 * 从内部来看 对于静态内部类SingletonHolder，它是一个饿汉式的单例实现，在SingletonHolder初始化的时候会由ClassLoader来保证同步，
 * 使INSTANCE是一个单例。同时，由于SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用，
 * 所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。从外部看来，又的确是懒汉式的实现
 * 使用类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的方式耗费性能。推荐这种实现方法
 *
 * @author TomLuo
 * @date 2023年05月21日 23:13
 */
public class SingleStatic {
    private static class SingletonHolder{
        public static SingleStatic instance = new SingleStatic();
    }
    private SingleStatic(){}

    public static SingleStatic newInstance(){
        return SingletonHolder.instance;
    }
}