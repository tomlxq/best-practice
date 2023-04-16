package com.example.demo.interpreter;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/6
 */
public class VarExpression extends AbstractExpression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    protected Float interpreter(HashMap<String, Float> map) {
        return map.get(this.key);
    }
}
