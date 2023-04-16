package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public abstract class AbstractCmd {
    //对接收者的引用
    protected IReceiver zip = new ZipReceiver();
    protected IReceiver gzip = new GzipReceiver();

    //抽象方法，命令的具体单元
    public abstract boolean execute(String source, String to);
}
