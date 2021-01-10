package com.tom.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2021/1/10
 */
@Data
public class StudentEntity implements Serializable {

    // 学号
    private Integer id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 班级
    private String className;


}
