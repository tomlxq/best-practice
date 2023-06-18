package com.pattern.gsspringbootpattern.strategy.service;

import lombok.AllArgsConstructor;

/**
 * @Description: Context
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 10:30
 * @Version: V1.0
 */
@AllArgsConstructor
public class Context {
    Strategy strategy;
    public String contextInterface(){
        return strategy.queryString();
    };
}