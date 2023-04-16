package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class ZipReceiver implements IReceiver {
    //zip格式的压缩算法
    public boolean compress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP压缩成功!");
        return true;
    }

    //zip格式的解压缩算法
    public boolean uncompress(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP解压缩成功!");
        return true;
    }
}
