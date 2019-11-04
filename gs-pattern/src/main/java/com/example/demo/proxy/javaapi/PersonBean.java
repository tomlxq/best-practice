package com.example.demo.proxy.javaapi;

import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public interface PersonBean {
    String getName();

    String getSex();

    java.util.Date getBirthday();

    String getInterests();

    void setName(String name);

    void setSex(String sex);

    void setBirthday(Date birthday);

    void setInterests(String interests);
}
