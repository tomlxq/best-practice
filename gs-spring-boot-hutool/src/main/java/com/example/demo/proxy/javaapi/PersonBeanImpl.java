package com.example.demo.proxy.javaapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
@Data
@AllArgsConstructor
public class PersonBeanImpl implements PersonBean {
    private String name;
    private String sex;
    private Date birthday;
    private String interests;
}
