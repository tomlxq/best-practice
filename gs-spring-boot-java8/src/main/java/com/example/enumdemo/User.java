package com.example.enumdemo;

/**
 * 枚举创建单例
 *
 * 枚举可以作为单例模式的最佳方式，能够保证单例对象的唯一性。
 * 枚举INSTANCE会在类加载初始化的时候创建,而Java类的加载和初始化过程都是线程安全的。
 * 枚举可避免反序列化破坏单例。
 *
 * @author TomLuo
 * @date 2023年06月06日 5:10
 */
public class User {
    //私有化构造函数
    private User(){ }

    //定义一个静态枚举类
    static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private User user;
        //私有化枚举的构造函数
        private SingletonEnum(){
            user = new User();
        }
        public User getInstnce(){
            return user;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static User getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }
}