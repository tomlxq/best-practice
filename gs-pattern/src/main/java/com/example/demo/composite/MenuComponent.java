package com.example.demo.composite;

import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public abstract class MenuComponent {

    public String getName() {
        return "";
    }

    public String getDesc() {
        return "";
    }

    public float getPrice() {
        return 0f;
    }

    public boolean isVegetable() {
        return false;
    }

    public abstract void print();

    public Iterator<MenuComponent> getIterator() {
        return new NullIterator();
    }
}
