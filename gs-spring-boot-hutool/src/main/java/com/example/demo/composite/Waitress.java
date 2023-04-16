package com.example.demo.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/21
 */
public class Waitress {
    public ArrayList<MenuComponent> list = new ArrayList<>();

    public Waitress() {

    }

    public void addMenuComponent(MenuComponent menuComponent) {
        list.add(menuComponent);
    }

    public void printMenu() {
        list.forEach(menu -> {
            menu.print();
            Iterator<MenuComponent> iterator = menu.getIterator();
            while (iterator.hasNext()) {
                MenuComponent next = iterator.next();
                next.print();
            }
        });
    }
}
