package com.example.demo.chain.women;

import static com.example.demo.chain.women.IWomen.Type;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public class Husband extends Handler {
    @Override
    protected void processMethod() {
        System.out.println("你可以和别的妇女去商场买奶粉和尿片！");
    }

    public Husband() {
        super(Type.Married);
    }

}
