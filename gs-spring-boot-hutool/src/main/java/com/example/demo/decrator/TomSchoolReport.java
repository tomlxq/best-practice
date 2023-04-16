package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class TomSchoolReport implements SchoolReport {
    @Override
    public void report() {
        System.out.println("TOM成绩为 语文 20 数学 75 外语 85");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名："+name);
    }
}
