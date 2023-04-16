package com.example.principle.ocp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public class ComputerBook implements IComputerBook {
    private String name;
    private String scope;
    private String author;
    private int price;

    public ComputerBook(String _name, int _price, String _author, String _scope) {
        this.name = _name;
        this.price = _price;
        this.author = _author;
        this.scope = _scope;
    }

    public String getScope() {
        return this.scope;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
