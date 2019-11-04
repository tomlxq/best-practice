package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class DirectorTest {
    public static void main(String[] args) {
        Director director = new Director(new Builder3d("2019-10-01"));
        director.construct();
        director = new Director(new Builder4d("2019-10-15"));
        director.construct();
    }
}
