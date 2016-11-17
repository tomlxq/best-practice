package com.example.domain;

import java.util.Date;

/**
 * Created by tom on 2016/5/21.
 */
public class User
{
    private String id;
    private String name;
    private String email;
    private Float age;
    private Date birthday;
    public User()
    {
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(String id, String name, String email,Float age,Date birthday)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}