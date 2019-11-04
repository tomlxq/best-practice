package com.example.demo.chain.women;

import static com.example.demo.chain.women.IWomen.Type;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public class Father extends Handler {
    @Override
    protected void processMethod() {
        System.out.println("你可以去和别的小朋友玩！");
    }

    public Father() {
        super(Type.Not_Married);
    }

   /* @Override
    protected void processRequest(String type) {
        Type type1 = Type.valueOf(type);
        if (type1 == Type.Not_Married) {
            System.out.println("你可以去和别的小朋友玩！");
        } else {
            nextHandler.processRequest(type);
        }
    }*/
}
