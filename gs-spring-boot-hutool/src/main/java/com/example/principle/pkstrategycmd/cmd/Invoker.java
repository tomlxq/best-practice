package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class Invoker {
    //抽象命令的引用
    private AbstractCmd cmd;

    public Invoker(AbstractCmd _cmd) {
        this.cmd = _cmd;
    }

    //执行命令
    public boolean execute(String source, String to) {
        return cmd.execute(source, to);
    }
}