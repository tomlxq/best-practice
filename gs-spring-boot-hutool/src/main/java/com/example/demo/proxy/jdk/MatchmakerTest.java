package com.example.demo.proxy.jdk;

import com.example.demo.proxy.manual.TomMatchmaker;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class MatchmakerTest {
    public static void main(String[] args) throws IOException {
        System.out.println("找女朋友自己搞定");
        Person p = new TomPerson();
        p.findLove();

        System.out.println("找女朋友通过媒婆来搞定");
        Person p2 = (Person) new Matchmaker().getInstance(new TomPerson());
        System.out.println(p2.getClass());
        p2.findLove();
        //生成的代理字节码文件
       /* byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{p2.getClass()});
        FileOutputStream inputStream = new FileOutputStream("./$proxy0.class");
        inputStream.write(bytes);
        inputStream.close();*/


    }
}
