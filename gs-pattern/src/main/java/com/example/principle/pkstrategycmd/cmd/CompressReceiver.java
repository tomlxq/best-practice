package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class CompressReceiver implements IReceiver {
    //执行gzip压缩命令
    public boolean gzipExec(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP压缩成功!");
        return true;
    }

    //执行zip压缩命令
    public boolean zipExec(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP压缩成功!");
        return true;
    }

    @Override
    public boolean compress(String source, String to) {
        return false;
    }

    @Override
    public boolean uncompress(String source, String to) {
        return false;
    }
}