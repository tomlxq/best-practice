package com.example.principle.lsp.para;

import java.util.Collection;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Father {
    public Collection doSomething(Map map) {
        System.out.println("父类被执行...");
        return map.values();
    }
}
