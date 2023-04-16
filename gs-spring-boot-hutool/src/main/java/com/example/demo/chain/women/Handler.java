package com.example.demo.chain.women;

import static com.example.demo.chain.women.IWomen.Type;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public abstract class Handler {
    Type type;

    public Handler(Type type) {
        this.type = type;
    }

    protected Handler nextHandler;

    protected void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void processRequest(IWomen women) {
        Type type = women.getType();
        if (type == this.type) {
            //模板模式
            this.processMethod();
        } else {
            nextHandler.processRequest(women);
        }
    }

    protected abstract void processMethod();
}
