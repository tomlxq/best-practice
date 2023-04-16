package com.guide.tool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ConvertDemoTest
 *
 * @author TomLuo
 * @date 2023年04月17日 6:20
 */
@Slf4j
class ConvertDemoTest {
    ConvertDemo convertDemo = null;

    @BeforeEach
    void setUp() {
        convertDemo = new ConvertDemo();
    }

    @org.junit.jupiter.api.Test
    void name() {
        long[] b = {1, 2, 3, 4, 5};
        String bStr = Convert.toStr(b);//"[1, 2, 3, 4, 5]"
        log.info("{}", bStr);

        double a = 67556.32;
        String digitUppercase = Convert.digitToChinese(a);//"陆万柒仟伍佰伍拾陆元叁角贰分"
        log.info("{}", digitUppercase);
    }

    @Test
    void name2() {
        MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Hutool测试", false);
        ArrayList<String> tos = CollUtil.newArrayList(
                "person1@bbb.com",
                "person2@bbb.com",
                "person3@bbb.com",
                "person4@bbb.com");

        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);
        MailUtil.send("hutool@foxmail.com", "测试", "<h1>邮件来自Hutool测试</h1>", true,
                FileUtil.file("d:/aaa.xml"));
        MailAccount account = new MailAccount();
        account.setHost("smtp.yeah.net");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("hutool@yeah.net");
        account.setUser("hutool");
        account.setPass("q1w2e3");

        MailUtil.send(account, CollUtil.newArrayList("hutool@foxmail.com"), "测试", "邮件来自Hutool测试", false);
    }
}