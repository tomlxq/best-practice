package com.example.demo.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class DuckTest {
    public static void main(String[] args) {
        Duck greenHeadDuck = new GreenHeadDuck();
        Turkey turkey = new WildTurkey();
        turkey.fly();
        turkey.sing();
        greenHeadDuck.go();
        greenHeadDuck.quack();
        System.out.println("~~~~~适配模式：继承~~~~~");
        WildFakeDuck wildFakeDuck = new WildFakeDuck();
        wildFakeDuck.go();
        wildFakeDuck.quack();
        System.out.println("~~~~~适配模式：组合~~~~~");
        WildFakeDuck2 wildFakeDuck2 = new WildFakeDuck2(turkey);
        wildFakeDuck2.go();
        wildFakeDuck2.quack();
    }
}
