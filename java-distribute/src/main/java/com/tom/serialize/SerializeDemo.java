package com.tom.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
public class SerializeDemo {
    public static void main(String[] args) {
        //序列化
        serializePerson();
        //返序列化
        deserializePerson();
    }

    private static void deserializePerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person o = (Person) ois.readObject();
            System.out.println(JSON.toJSONString(o, true));
            System.out.println(o.height);
            System.out.println("成功反序列化对象person：" + o.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
        }
    }

    private static void serializePerson() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setAge(18);
            person.setName("TOM");
            person.setBirthday(new Date());
            oos.writeObject(person);
            System.out.println("成功序列化对象person：" + person.hashCode());
            Person.height = 10;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

    }
}
