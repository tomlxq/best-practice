package com.example.demo.decrator.javaapi;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class UpperInputStream extends FilterInputStream {
    public UpperInputStream(InputStream in){
        super(in);
    }
    @Override
    public int read() throws IOException {
        int read = super.read();
        return read==-1?read:Character.toUpperCase((char)read);
    }


    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for(int idx=0;idx<result;idx++){
            b[idx] =(byte) Character.toUpperCase((char) b[idx]);
        }
        return result;
    }
}
