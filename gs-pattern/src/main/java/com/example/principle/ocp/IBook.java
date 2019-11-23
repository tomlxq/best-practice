package com.example.principle.ocp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public interface IBook {
    //书籍有名称
    public String getName();

    //书籍有售价
    public int getPrice();

    //书籍有作者
    public String getAuthor();
}
