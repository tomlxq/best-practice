package com.example.demo.composite;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class CakeShopMenu extends MenuComponent {
    ArrayList<MenuComponent> menuItems = new ArrayList<>();

    public CakeShopMenu() {
        addMenuItem("sandwich", "三明治", 4.5f, true);
        addMenuItem("sausage", "热狗", 2.5f, true);
        addMenuItem("cake", "蛋糕", 10f, true);
        addSubMenu(new SubMenu());
    }

    private void addSubMenu(MenuComponent subMenu) {
        menuItems.add(subMenu);
    }

    private void addMenuItem(String name, String desc, float price, boolean isVegetable) {
        menuItems.add(new MenuItem(name, desc, price, isVegetable));
    }

    public ArrayList<MenuComponent> getMenuItem() {
        return this.menuItems;
    }

    @Override
    public void print() {
        System.out.println("这是蛋糕店");
    }

    @Override
    public Iterator<MenuComponent> getIterator() {
        return new ComposeIterator(this.menuItems.iterator());
    }


}
