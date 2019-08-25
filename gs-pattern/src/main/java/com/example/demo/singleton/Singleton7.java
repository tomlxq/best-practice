package com.example.demo.singleton;

/**
 * 静态内部类[推荐用]
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。
 * 类的静态属性只会在第一次加载类的时候初始化，
 * 所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * 优点：避免了线程不安全，延迟加载，效率高。
 * @author TomLuo
 * @date 2019/8/25
 */
public class Singleton7 {
    /**
     * 将默认函数私有化，则不能new
     */
    private Singleton7() {
    }

    /**
     * private 私有的内部类，不能被外部访问
     * static 保证全局唯一
     */
    private static class LazyHolder {
        //final防止内部误操作
        private final static Singleton7 INSTANCE = new Singleton7();
    }

    /**
     * 提供静态方法提供实例
     * final方法不能被覆盖
     *
     * @return
     */
    public static final Singleton7 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
