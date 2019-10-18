package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public interface SchoolReport {
    /**
     * 家长看成绩单
     */
    void report();

    /**
     * 家长签名
     * @param name
     */
    void sign(String name);
}
