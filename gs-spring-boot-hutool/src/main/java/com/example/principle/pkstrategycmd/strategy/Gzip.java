package com.example.principle.pkstrategycmd.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class Gzip implements Algorithm {
    //gzip的压缩算法
    public boolean compress(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP压缩成功!");
        return true;
    }

    //gzip解压缩算法
    public boolean uncompress(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP解压缩成功!");
        return true;
    }
}
