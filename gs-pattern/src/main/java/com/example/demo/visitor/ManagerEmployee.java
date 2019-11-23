package com.example.demo.visitor;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
public class ManagerEmployee extends Employee {
    private String performance;

    public ManagerEmployee(String name, int degree, int salary, String sex, String performance) {
        super(name, degree, salary, sex);
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor1) {
        visitor1.visit(this);
    }
}
