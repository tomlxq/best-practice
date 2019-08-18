package com.example.demo.proxy.jdk;
import com.example.demo.proxy.jdk.manual.TomMatchmaker;
import sun.misc.ProxyGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy.*;
/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TestPeople {
    public static void main(String[] args) throws IOException {
       /* System.out.println("找女朋友自己搞定");
        Person p = new TomPerson();
        p.findLove();
        System.out.println("找女朋友通过媒婆来搞定");
        Person p2 = (Person) new Matchmaker().getInstance(new TomPerson());
        System.out.println(p2.getClass());
        p2.findLove();

        //生成的代理字节码文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{p2.getClass()});
        FileOutputStream inputStream=new FileOutputStream("./$proxy0.class");
        inputStream.write(bytes);
        inputStream.close();*/
        //手动实现动态代理
        Person p3 = (Person) new TomMatchmaker().getInstance(new TomPerson());
       // System.out.println(p3.getClass());
      //  p3.findLove();

    }
}
