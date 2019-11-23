package com.example.demo.visitor;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
public class CommonEmployee extends Employee {
    private String job;

    public CommonEmployee(String name, int degree, int salary, String sex, String job) {
        super(name, degree, salary, sex);
        this.job = job;
    }

    @Override
    public void accept(IVisitor visitor1) {
        visitor1.visit(this);
    }
}
