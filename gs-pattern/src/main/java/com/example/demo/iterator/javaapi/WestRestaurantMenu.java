package com.example.demo.iterator.javaapi;

import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class WestRestaurantMenu {
    private static final int MAX_MENU_NUMBERS = 5;
    private MenuItem[] array = new MenuItem[MAX_MENU_NUMBERS];

    public WestRestaurantMenu() {
        array[0] = new MenuItem("pepper steak", "黑椒牛排", 70f, false);
        array[1] = new MenuItem("filet steak", "腓力牛排", 120f, false);
        array[2] = new MenuItem("sirloin steaks", "西冷牛排", 82f, false);
        array[3] = new MenuItem("fried chicken wings", "炸鸡翅", 24f, false);
        array[4] = new MenuItem("Big Mac", "巨无霸", 24f, false);
    }

    public MenuItem[] getMenuItem() {
        return this.array;
    }

    public WestRestaurantMenuIterator getIterator() {
        return new WestRestaurantMenuIterator();
    }

    private class WestRestaurantMenuIterator implements Iterator {
        int size = 0;

        public WestRestaurantMenuIterator() {
            size = array.length;
        }

        @Override
        public boolean hasNext() {
            if (size > 0) {
                return true;
            }
            return false;
        }

        @Override
        public MenuItem next() {
            size--;
            return array[size];
        }
    }
}
