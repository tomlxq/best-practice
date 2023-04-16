package com.example.demo.flyweight.javaapi;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "和谐";
        String str2 = "社会";
        String str3 = "和谐社会";
        String str4;
        str4 = str1 + str2;
        System.out.println(str3 == str4);
        str4 = (str1 + str2).intern();
        System.out.println(str3 == str4);
    }
}
