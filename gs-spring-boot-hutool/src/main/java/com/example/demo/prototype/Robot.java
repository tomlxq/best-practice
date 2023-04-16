package com.example.demo.prototype;

import lombok.Data;

import java.util.ArrayList;

/**
 * 机器人原型
 * 只能复制 8基本类型+String
 * 属于浅复制
 *
 * @author TomLuo
 * @date 2019/8/25
 */
@Data
public class Robot implements Cloneable {
    int age;
    String name;
    /**
     * 定义一个私有变量 ArrayList<String>,不支持浅复制
     */
    private  ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected Robot clone()  {
        Robot clone = null;
        try {
            clone = (Robot) super.clone();
            //深度复制
            clone.arrayList=(ArrayList<String>)this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  clone;
    }
}
