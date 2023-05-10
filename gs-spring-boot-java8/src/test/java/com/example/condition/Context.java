package com.example.condition;

import lombok.AllArgsConstructor;

/**
 * ssss
 *
 * @author TomLuo
 * @date 2023年04月28日 21:20
 */
@AllArgsConstructor
public class Context {
    /**
     * 持有公共接口的引用，后续通过多态来获取［红包
     */
    Strategy strategy;


    public String contextInterface() {
        return strategy.query();
    }
}