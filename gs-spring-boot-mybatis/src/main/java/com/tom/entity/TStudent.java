package com.tom.entity;

import jakarta.annotation.Generated;

public class TStudent {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String branch;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer percentage;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBranch() {
        return branch;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPercentage() {
        return percentage;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}