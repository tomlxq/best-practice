package com.example.demo.factory.pizza;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
@Getter
public abstract class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }
    public abstract void prepare();
    public void baking(){
        System.out.println(this.name+" pizza烘焙");
    }
    public void cut(){
        System.out.println(this.name+" pizza切割");
    }
    public void box(){
        System.out.println(this.name+" pizza打包，送到客户桌上");
    }
}
