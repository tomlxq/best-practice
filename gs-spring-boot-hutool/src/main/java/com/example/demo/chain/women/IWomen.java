package com.example.demo.chain.women;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public interface IWomen {
    Type getType();

    public static enum Type {
        Not_Married, Only_Son, Married;
    }
}
