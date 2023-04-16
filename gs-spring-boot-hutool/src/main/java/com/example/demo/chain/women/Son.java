package com.example.demo.chain.women;

import static com.example.demo.chain.women.IWomen.Type;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public class Son extends Handler {

    @Override
    protected void processMethod() {
        System.out.println("你可以去和别的老太婆玩三公！");
    }


    public Son() {
        super(Type.Only_Son);
    }
}
