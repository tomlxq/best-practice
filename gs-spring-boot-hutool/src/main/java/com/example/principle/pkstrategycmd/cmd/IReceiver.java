package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public interface IReceiver {
    //压缩
    public boolean compress(String source, String to);

    //解压缩
    public boolean uncompress(String source, String to);
}
