package com.tomluo.cxf.server.impl;

/**
 * Created by tom on 2017/2/16.
 */
public class UserInfo {
    String userName;
    String pwd;
    String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
