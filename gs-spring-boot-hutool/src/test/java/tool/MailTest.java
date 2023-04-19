package tool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 在 Java 中发送邮件主要品依靠 javax.mail 包，但是由于使用比较繁琐，因此 Hutool 针对其做了封装。
 * 在 classpath（在标准 Maven 项目中为src/main/resources）的 config 目录下新建mail.setting文件，完整配置如下（邮件服务器必须支持并打开 SMTP 协议）
 * # 邮件服务器的SMTP地址，可选，默认为smtp.<发件人邮箱后缀>
 * host = smtp.yeah.net
 * # 邮件服务器的SMTP端口，可选，默认25
 * port = 25
 * # 发件人（必须正确，否则发送失败）
 * from = hutool@yeah.net
 * # 用户名，默认为发件人邮箱前缀
 * user = hutool
 * # 密码（注意，某些邮箱需要为SMTP服务单独设置授权码，详情查看相关帮助）
 * pass = q1w2e3
 *
 * @author TomLuo
 * @date 2023年04月18日 6:04
 */
public class MailTest {
    @Test
    void name2() {
        //发送邮件
        MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Hutool测试", false);
        //支持群发
        ArrayList<String> tos = CollUtil.newArrayList(
                "person1@bbb.com",
                "person2@bbb.com",
                "person3@bbb.com",
                "person4@bbb.com");

        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);
        //支持添加一个或者多个附件
        MailUtil.send("hutool@foxmail.com", "测试", "<h1>邮件来自Hutool测试</h1>", true,
                FileUtil.file("d:/aaa.xml"));
        //除了使用配置文件定义全局账号以外，MailUtil.send方法同时提供重载方法可以传入一个MailAccount对象，这个对象为一个普通 Bean，记录了邮件服务器信息。
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