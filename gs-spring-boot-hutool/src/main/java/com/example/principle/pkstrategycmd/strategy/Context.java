package com.example.principle.pkstrategycmd.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class Context {
    //指向抽象算法
    private Algorithm al;

    //构造函数传递具体的算法
    public Context(Algorithm _al) {
        this.al = _al;
    }

    //执行压缩算法
    public boolean compress(String source, String to) {
        return al.compress(source, to);
    }

    //执行解压缩算法
    public boolean uncompress(String source, String to) {
        return al.uncompress(source, to);
    }
}
