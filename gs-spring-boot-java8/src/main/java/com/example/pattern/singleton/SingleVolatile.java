package com.example.pattern.singleton;

/**
 * 4. 懒汉式单例 -- 双重校验锁 volatile版
 * instance声明为volatile之后，告诉JVM编译器不允许指令重排优化，告诉CPU不允许乱序执行。
 *
 * 对SingleVolatile.class文件反汇编一下：
 *     -server
 *     -Xcomp
 *     -XX:+UnlockDiagnosticVMOptions
 *     -XX:+PrintAssembly
 *     -XX:CompileCommand=compileonly,*SingleVolatile.getInstance
 *
 * @author TomLuo
 * @date 2023年05月21日 23:08
 */
/**
 * 懒汉 - 双层校验锁2
 */
public class SingleVolatile {
    private static volatile SingleVolatile instance;// 加上volatile关键字

    private SingleVolatile() {}//将构造器 私有化，防止外部调用

    public static SingleVolatile getInstance() {
        if (instance == null) {
            synchronized (SingleVolatile.class) {
                if (instance == null) {
                    instance = new SingleVolatile();
                }
            }
        }
        return instance;
    }
}