package com.example.demo.visitor;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.visitor.Employee.SexType.FEMALE;
import static com.example.demo.visitor.Employee.SexType.MALE;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        Employee employee1 = new CommonEmployee("张三", 2, 1500, MALE.getDesc(), "普工");
        Employee employee2 = new CommonEmployee("李四", 2, 2500, MALE.getDesc(), "IT工程师");
        Employee employee3 = new CommonEmployee("Rose", 2, 3000, FEMALE.getDesc(), "焊工");
        Employee employee4 = new ManagerEmployee("Mary", 2, 3000, FEMALE.getDesc(), "总销售额500万");
        List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4);
        list.forEach(v -> {
            v.accept(visitor);
        });
    }
}
