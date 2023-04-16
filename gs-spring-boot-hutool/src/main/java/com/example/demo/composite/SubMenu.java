package com.example.demo.composite;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class SubMenu extends MenuComponent {
    ArrayList<MenuComponent> menuItems;

    public SubMenu() {
        menuItems = new ArrayList<>();
        addItem("sandwich", "三明治", 4.5f);
        addItem("sausage", "热狗", 2.5f);
        addItem("cake", "蛋糕", 10f);
    }

    private void addItem(String name, String desc, float price) {
        menuItems.add(new MenuItem(name, desc, price, true));
    }

    @Override
    public void print() {
        System.out.println("这是子菜单");
    }

    @Override
    public Iterator<MenuComponent> getIterator() {
        return new ComposeIterator(menuItems.iterator());
    }
}
