package com.example.demo.prototype.mail;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
@AllArgsConstructor
public class AdvTemplate {
    private String subject;
    private String content;
}
