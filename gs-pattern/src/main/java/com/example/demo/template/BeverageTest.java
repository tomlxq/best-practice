package com.example.demo.template;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class BeverageTest {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~制作冲泡咖啡，不加附料~~~~~~~~~");
        Beverage coffee = new CoffeeBeverage();
        coffee.templateMethod();
        System.out.println("~~~~~~~~~制作冲泡茶~~~~~~~~~");
        Beverage tea = new TeaBeverage();
        tea.templateMethod();
    }
}
