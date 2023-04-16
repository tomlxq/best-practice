package com.example.demo.iterator.javaapi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class CakeShopMenu {
    private ArrayList<MenuItem> list = new ArrayList<>();

    public CakeShopMenu() {
        list.add(new MenuItem("sandwich", "三明治", 4.5f, true));
        list.add(new MenuItem("sausage", "热狗", 2.5f, true));
        list.add(new MenuItem("cake", "蛋糕", 10f, true));
    }

    public ArrayList<MenuItem> getMenuItem() {
        return this.list;
    }

    public Iterator<MenuItem> getIterator() {
        return this.list.iterator();
    }


}
