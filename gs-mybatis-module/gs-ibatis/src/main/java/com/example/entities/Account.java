package com.example.entities;

import java.util.Date;

/**
 * Created by tom on 2016/5/18.
 */
public class Account extends IdEntity {
    String name;
    String password;
    String email;
    Integer sex;
    Date birthday;
    public Account() {

    }
    public Account(String name, String password, String email, Integer sex,Date birthday) {
        this.name=name;
        this.password=password;
        this.email=email;
        this.sex=sex;
        this.birthday=birthday;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
