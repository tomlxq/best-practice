package com.example.demo.composite;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/21
 */
public class WaitressTest {
    public static void main(String[] args) {
        Waitress waitress = new Waitress();
        CakeShopMenu cakeShopMenu = new CakeShopMenu();
        WestRestaurantMenu westRestaurantMenu = new WestRestaurantMenu();
        waitress.addMenuComponent(cakeShopMenu);
        waitress.addMenuComponent(westRestaurantMenu);
        waitress.printMenu();
    }
}
