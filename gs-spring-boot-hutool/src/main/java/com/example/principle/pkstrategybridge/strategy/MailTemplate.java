package com.example.principle.pkstrategybridge.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/20
 */
@Data
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
}
