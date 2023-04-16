package com.example.principle.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    //搜索并展示美女信息
    public static void main(String[] args) {
//定义一个美女
        IGreatTemperamentGirl yanYan = new PettyGirl("嫣嫣");
        AbstractSearcher searcher = new Searcher(yanYan);
        searcher.show();
    }
}