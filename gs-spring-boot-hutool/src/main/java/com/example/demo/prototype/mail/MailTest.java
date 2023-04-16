package com.example.demo.prototype.mail;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MailTest {
    public static void main(String[] args) {
        long a = RandomUtils.nextLong(1, 12);
        String sender = getRandomStr(3);
        String appellation = getRandomStr(3);
        AdvTemplate advTemplate = new AdvTemplate(appellation + "先生（女士）" + a + "月份信息卡账单", "国庆抽奖活动通知：只要刷卡就送你一百万");
        Mail mail = new Mail(advTemplate);
        mail.setSender(sender + "@" + getRandomStr(3) + ".com");
        mail.setTail("国庆后，打5折！");
        mail.setValue("张三");
        for (int i = 0; i < 3; i++) {
            Mail cloneMail = mail.clone();
            cloneMail.setValue("李四");
            cloneMail.setAppellation(appellation);
            String receiver = appellation + "@" + getRandomStr(3) + ".com";
            cloneMail.setReceiver(receiver);
            sendMail(cloneMail);
        }
    }

    private static void sendMail(Mail mail) {
        System.out.println(JSON.toJSONString(mail, true));
    }

    public static String getRandomStr(long len) {
        String seed = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            stringBuffer.append(seed.charAt(random.nextInt(seed.length())));
        }
        return stringBuffer.toString();
    }
}
