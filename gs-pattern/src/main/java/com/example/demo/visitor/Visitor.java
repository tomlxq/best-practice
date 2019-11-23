package com.example.demo.visitor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(Employee employee) {
        System.out.println("~~~~~~~~~~~~~~打印雇员" + employee.getName() + "的信息~~~~~~~~~~~~~~");
        printBasicInfo(employee);
        if (employee instanceof ManagerEmployee) {
            ManagerEmployee visitor = (ManagerEmployee) employee;
            System.out.println("雇员的补偿金：" + employee.getDegree() * employee.getSalary() * 10);
            System.out.println("雇员的业绩：" + visitor.getPerformance());
        }
        if (employee instanceof CommonEmployee) {
            CommonEmployee visitor = (CommonEmployee) employee;
            System.out.println("雇员的补偿金：" + employee.getDegree() * employee.getSalary() * 5);
            System.out.println("雇员的工作：" + visitor.getJob());
        }
    }

    private void printBasicInfo(Employee employee) {
        System.out.println("雇员的性别：" + employee.getSex());
        System.out.println("雇员的工资：" + employee.getSalary());
        System.out.println("雇员的级别：" + employee.getDegree());
    }
}
