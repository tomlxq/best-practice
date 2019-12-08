package com.tom.serialize;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
public class UserDemo {
    public static void main(String[] args) {
        //序列化
        serializeUser();
        //返序列化
        deserializeUser();
    }

    private static void deserializeUser() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("User")));
            User o = (User) ois.readObject();
            System.out.println(JSON.toJSONString(o, true));
            System.out.println("成功反序列化对象user：" + o.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
        }
    }

    private static void serializeUser() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("User")));
            User user = new User();
            user.setAge(18);
            oos.writeObject(user);
            System.out.println("成功序列化对象user：" + user.hashCode());
            Person.height = 10;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }
}
