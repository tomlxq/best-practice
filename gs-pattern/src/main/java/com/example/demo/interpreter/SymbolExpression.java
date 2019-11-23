package com.example.demo.interpreter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/6
 */
public abstract class SymbolExpression extends AbstractExpression {
    protected AbstractExpression left;
    protected AbstractExpression right;

    public SymbolExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }
}
