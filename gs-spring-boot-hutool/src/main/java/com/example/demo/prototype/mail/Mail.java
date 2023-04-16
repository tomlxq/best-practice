package com.example.demo.prototype.mail;

import lombok.Data;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
public class Mail implements Cloneable {
    private String sender;
    private String receiver;
    private String appellation;
    private String subject;
    private String content;
    private String tail;
    //定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<String>();

    public Mail(AdvTemplate advTemplate) {
        System.out.println("构造函数被执行了");
        this.subject = advTemplate.getSubject();
        this.content = advTemplate.getContent();
    }

    @Override
    protected Mail clone() {
        Mail mail = null;
        try {
            //浅拷贝
            mail = (Mail) super.clone();
            //深拷贝
            mail.arrayList = (ArrayList) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public void setValue(String name) {
        arrayList.add(name);
    }
}
