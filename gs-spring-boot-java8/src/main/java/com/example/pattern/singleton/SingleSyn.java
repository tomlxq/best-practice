package com.example.pattern.singleton;

/**
 * 2. 懒汉式单例 -- synchronized 版
 * 懒汉 - 加锁synchronized
 * 如果有多个访问者（线程）访问getInstance()方法，当一个线程获得锁之后，进行
 * 判空、对象创建、获得返回值的操作，其他的线程必须等待其完成，才能继续执行
 * 这样加锁之后懒汉模式虽然解决了线程并发问题（线程安全的），
 * 但由于把锁加到方法上后，所有的访问都因需要锁占用导致资源的浪费，这其实非常影响程序的性能,效率很低
 *
 * @author TomLuo
 * @date 2023年05月21日 23:00
 */
public class SingleSyn {
    private static SingleSyn instance;

    private SingleSyn() {//将构造器 私有化，防止外部调用
    }

    public static synchronized SingleSyn getInstance(){
        if (instance == null) {
            instance = new SingleSyn();
        }
        return instance;
    }
}