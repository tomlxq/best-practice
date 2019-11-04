package com.example.demo.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class MenuItemTest {
    public static void main(String[] args) {
        CakeShopMenu cakeShopMenu = new CakeShopMenu();
        WestRestaurantMenu westRestaurantMenu = new WestRestaurantMenu();
        List<Iterator<MenuItem>> list = Arrays.asList(cakeShopMenu.getIterator(), westRestaurantMenu.getIterator());
        list.forEach(iterator -> {
            while (iterator.hasNext()) {
                MenuItem menuItem = iterator.next();
                System.out.println("菜单：" + menuItem.getName() + " 菜单描述：" + menuItem.getDesc() +
                        " 菜单价格：" + menuItem.getPrice() + " 是否素食：" + menuItem.isVegetable());
            }
        });
    }
}
