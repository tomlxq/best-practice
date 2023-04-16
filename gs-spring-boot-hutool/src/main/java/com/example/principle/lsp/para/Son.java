package com.example.principle.lsp.para;

import java.util.Collection;
import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Son extends Father {
    //放大输入参数类型
    //@Override
    public Collection doSomething(HashMap map) {
        System.out.println("子类被执行...");
        return map.values();
    }
}
