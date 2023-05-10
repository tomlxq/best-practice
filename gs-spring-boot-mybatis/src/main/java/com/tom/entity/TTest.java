package com.tom.entity;

import jakarta.annotation.Generated;

public class TTest {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String stub;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStub() {
        return stub;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStub(String stub) {
        this.stub = stub == null ? null : stub.trim();
    }
}