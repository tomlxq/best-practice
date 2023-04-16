package com.example.demo.iterator;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class CakeShopMenu {
    ArrayList<MenuItem> list = new ArrayList<>();

    public CakeShopMenu() {
        list.add(new MenuItem("sandwich", "三明治", 4.5f, true));
        list.add(new MenuItem("sausage", "热狗", 2.5f, true));
        list.add(new MenuItem("cake", "蛋糕", 10f, true));
    }

    public ArrayList<MenuItem> getMenuItem() {
        return this.list;
    }

    public CakeShopMenuIterator getIterator() {
        return new CakeShopMenuIterator();
    }

    private class CakeShopMenuIterator implements Iterator {
        int size = 0;

        public CakeShopMenuIterator() {
            size = list.size();
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
            return list.get(size);
        }
    }
}
