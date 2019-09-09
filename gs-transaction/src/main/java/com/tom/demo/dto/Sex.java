package com.tom.demo.dto;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/9
 */
public enum Sex {
    BOY("男"),GIRL("女");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getSex() {
        return this.value;
    }
}