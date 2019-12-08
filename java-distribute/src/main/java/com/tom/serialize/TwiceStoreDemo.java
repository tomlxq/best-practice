package com.tom.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
public class TwiceStoreDemo {
    public static void main(String[] args) {
        //序列化
        serializePerson();

    }

    private static void serializePerson() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setAge(18);
            person.setName("TOM");
            person.setBirthday(new Date());
            writeOnce(oos, person);
            writeOnce(oos, person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

    }

    private static void writeOnce(ObjectOutputStream oos, Person person) throws IOException {
        oos.writeObject(person);
        oos.flush();
        System.out.println("成功序列化对象person：" + person.hashCode() + " len:" + new File("person").length());
        System.out.println("Content：" + JSON.toJSONString(new String(FileUtils.readFileToByteArray(new File("person")), "UTF-8"), true));
    }
}
