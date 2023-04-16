package com.example.demo.interpreter;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/6
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected Float interpreter(HashMap<String, Float> map) {
        return super.left.interpreter(map) + super.right.interpreter(map);
    }
}
