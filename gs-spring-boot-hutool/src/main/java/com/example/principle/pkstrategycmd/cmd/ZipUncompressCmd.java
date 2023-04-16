package com.example.principle.pkstrategycmd.cmd;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class ZipUncompressCmd extends AbstractCmd {
    public boolean execute(String source, String to) {
        return super.zip.uncompress(source, to);
    }
}