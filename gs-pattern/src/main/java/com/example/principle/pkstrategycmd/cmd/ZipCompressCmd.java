package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class ZipCompressCmd extends AbstractCmd {
    public boolean execute(String source, String to) {
        return super.zip.compress(source, to);
    }
}
