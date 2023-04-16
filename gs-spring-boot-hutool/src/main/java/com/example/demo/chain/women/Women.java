package com.example.demo.chain.women;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public class Women implements IWomen {
    Type type;

    public Women(String tempType) {
        this.type = Type.valueOf(tempType);
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
