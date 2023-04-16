package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class Director {
    private AbsBuilder builder;

    public Director(AbsBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(AbsBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildVacation();
        builder.getVacation().showInfo();
    }
}
