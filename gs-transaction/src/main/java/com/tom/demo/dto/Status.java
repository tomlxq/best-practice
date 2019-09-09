package com.tom.demo.dto;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/9
 */
public enum Status {
    LOCKED("冻结"), UNLOCK("正常"), DELETE("已删除");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getStatus() {
        return this.value;
    }
}
