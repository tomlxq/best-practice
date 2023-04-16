package com.example.principle.pkstrategybridge.bridge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
@Setter
@Getter
@AllArgsConstructor
public abstract class MailTemplate {
    //邮件发件人
    private String from;
    //收件人
    private String to;
    //邮件标题
    private String subject;
    //邮件内容
    private String context;

    //允许增加邮件发送标志
    public void add(String sendInfo) {
        context = sendInfo + context;
    }
}
