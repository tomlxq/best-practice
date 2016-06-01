import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by tom on 2016/5/31.
 */

public class EmailTest extends BaseTest {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    private Environment env;

    @Test
    public void send163ByMutil() throws MessagingException, UnsupportedEncodingException {
        JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
        javaMail.setHost(env.getProperty("smtp.host"));
        javaMail.setPassword(env.getProperty("smtp.password"));
        javaMail.setUsername(env.getProperty("smtp.username"));
        // javaMail.setPort(_testPort);
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth", "true");
        //Properties javaMailProps = new Properties();
        prop.put("mail.smtp.starttls.enable", true);

        prop.setProperty("mail.debug", "true");
        javaMail.setJavaMailProperties(prop);
        logger.debug("port {}", javaMail.getPort());
        MimeMessage message = javaMail.createMimeMessage();
        MimeMessageHelper messageHelp = new MimeMessageHelper(message, true, "UTF8");
        messageHelp.setFrom(env.getProperty("smtp.username"), "邮件测试");
        messageHelp.setTo(env.getProperty("support.email"));
        messageHelp.setSubject("邮件测试");
        // messageHelp
        String body = "<html><head><META http- equiv=Content-Type content='text/html; charset=GBK'></HEAD><title>test</title></head><body>dear 小燕子 \n ";
        body += " <red> This is Text! </red>  pic  <img   src = 'cid:a'> </img> <br> hello <img   src = 'cid:b'> </img> </body> </html> ";
        messageHelp.setText(body, true);
        messageHelp.addInline("a", new File("F:\\testpc\\5919012-1000-391-rounded.jpg"));
        messageHelp.addInline("b", new File("F:\\testpc\\14245062-1000-391-rounded.jpg"));
       File file = new File("F:\\testpc\\17790188-1000-391-rounded.jpg");
        messageHelp.addAttachment(MimeUtility.encodeWord(file.getName()), file);
        javaMail.send(message);
    }


    @Test
    public void testByMailSender() {


        SimpleMailMessage smm = new SimpleMailMessage();
        // 设定邮件参数
        smm.setFrom(mailSender.getUsername());
        smm.setTo(env.getProperty("support.email"));
        smm.setSubject("Hello world");
        smm.setText("Hello world via spring mail sender");

        // 发送邮件
        mailSender.send(smm);
    }

    @Test
    public void testByManual() throws EmailException, MessagingException {

        Properties props = System.getProperties();
        props.put("mail.smtp.host", env.getProperty("smtp.host"));
        // 必须有这项设置
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");

        //Session session = Session.getDefaultInstance(props, null);
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(env.getProperty("smtp.username"), env.getProperty("smtp.password"));
            }
        });
        MimeMessage message = new MimeMessage(session);
//设置发件人
        message.setFrom(new InternetAddress(env.getProperty("smtp.username")));
//设置收件人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(env.getProperty("support.email")));
//设置消息主题
        message.setSubject("你好 JavaMail");
//设置消息内容
        message.setText("Welcome to JavaMail world!");
//发送消息
        Transport.send(message);
        System.out.println("消息已经发送成功");
    }
}