package com.example.principle.pkstrategycmd.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public interface Algorithm {
    //压缩算法
    public boolean compress(String source, String to);

    //解压缩算法
    public boolean uncompress(String source, String to);
}
