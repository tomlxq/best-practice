package com.example.demo.composite;


import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class WestRestaurantMenu extends MenuComponent {
    private static final int MAX_MENU_NUMBERS = 6;
    MenuComponent[] array = new MenuComponent[MAX_MENU_NUMBERS];
    int idx = 0;

    public WestRestaurantMenu() {
        addMenuItem("pepper steak", "黑椒牛排", 70f, false);
        addMenuItem("filet steak", "腓力牛排", 120f, false);
        addMenuItem("sirloin steaks", "西冷牛排", 82f, false);
        addMenuItem("fried chicken wings", "炸鸡翅", 24f, false);
        addMenuItem("Big Mac", "巨无霸", 24f, false);
        addSubMenu(new SubMenu());
    }

    private void addSubMenu(MenuComponent menuComponent) {
        if (idx < MAX_MENU_NUMBERS) {
            array[idx++] = menuComponent;
        }
    }

    private void addMenuItem(String name, String desc, float price, boolean isVegetable) {
        if (idx < MAX_MENU_NUMBERS) {
            array[idx++] = new MenuItem(name, desc, price, isVegetable);
        }
    }

    public MenuComponent[] getMenuItem() {
        return this.array;
    }

    @Override
    public void print() {
        System.out.println("这是西餐厅");
    }

    @Override
    public Iterator<MenuComponent> getIterator() {
        return new ComposeIterator(new WestRestaurantMenuIterator());
    }

    private class WestRestaurantMenuIterator implements Iterator {
        int position;

        public WestRestaurantMenuIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            if (position < MAX_MENU_NUMBERS) {
                return true;
            }
            return false;
        }

        @Override
        public MenuComponent next() {
            return array[position++];
        }
    }
}
