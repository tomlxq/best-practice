package com.example.demo.interpreter;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/6
 */
public abstract class AbstractExpression {
    protected abstract Float interpreter(HashMap<String, Float> map);
}
