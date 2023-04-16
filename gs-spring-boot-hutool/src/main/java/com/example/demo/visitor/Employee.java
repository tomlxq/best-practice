package com.example.demo.visitor;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
public abstract class Employee {
    public Employee(String name, int degree, int salary, String sex) {
        this.name = name;
        this.degree = degree;
        this.salary = salary;
        this.sex = sex;
    }

    private String name;
    private int degree;
    private int salary;
    private String sex;

    public abstract void accept(IVisitor visitor1);

    public enum SexType {
        MALE("男性"), FEMALE("女性");

        SexType(String desc) {
            this.desc = desc;
        }

        String desc;

        public String getDesc() {
            return desc;
        }


    }
}
