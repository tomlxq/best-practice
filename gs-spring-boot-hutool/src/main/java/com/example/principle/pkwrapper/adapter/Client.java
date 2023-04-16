package com.example.principle.pkwrapper.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("电影名星开始表演了");
        IStar star = new FileStar();
        star.act();
        System.out.println("电影名星演累了，找个替身来继续表演");
        IActor actor = new Actor();
        star = new Adapter(actor);
        star.act();

    }
}
