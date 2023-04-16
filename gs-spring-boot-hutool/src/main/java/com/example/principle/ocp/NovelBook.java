package com.example.principle.ocp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public class NovelBook implements IBook {
    //书籍名称
    private String name;
    //书籍的价格
    private int price;
    //书籍的作者
    private String author;

    //通过构造函数传递书籍数据
    public NovelBook(String _name, int _price, String _author) {
        this.name = _name;
        this.price = _price;
        this.author = _author;
    }

    //获得作者是谁
    public String getAuthor() {
        return this.author;
    }

    //书籍叫什么名字
    public String getName() {
        return this.name;
    }

    //获得书籍的价格
    public int getPrice() {
        return this.price;
    }
}