package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class UncompressReceiver implements IReceiver {
    //执行gzip解压缩命令
    public boolean gzipExec(String source, String to) {
        System.out.println(source + " --> " + to + " GZIP解压缩成功!");
        return true;
    }

    //执行zip解压缩命令
    public boolean zipExec(String source, String to) {
        System.out.println(source + " --> " + to + " ZIP解压缩成功!");
        return true;
    }

    @Override
    public boolean compress(String source, String to) {
        return gzipExec(source, to);
    }

    @Override
    public boolean uncompress(String source, String to) {
        return zipExec(source, to);
    }
}