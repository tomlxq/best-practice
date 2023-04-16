package com.example.principle.pkstrategybridge.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/20
 */
public class TextMail extends MailTemplate {
    public TextMail(String _from, String _to, String _subject, String _context) {
        super(_from, _to, _subject, _context);
    }

    public String getContext() {
//文本类型设置邮件的格式为：text/plain
        String context = "\nContent-Type: text/plain;charset=GB2312\n" + super.getContext();
//同时对邮件进行base64编码处理,这里用一句话代替
        context = context + "\n邮件格式为：文本格式";
        return context;
    }
}
