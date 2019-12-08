package com.tom.serialize.deep;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
public class DeepCloneDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setName("lxq");
        Teacher teacher = new Teacher();
        teacher.setName("lanlan");
        student.setTeacher(teacher);

        Teacher teacher2 = (Teacher) teacher.deepClone();
        teacher2.setName("Jack");

        System.out.println(JSON.toJSONString(teacher, true));
        System.out.println(JSON.toJSONString(teacher2, true));
    }
}
