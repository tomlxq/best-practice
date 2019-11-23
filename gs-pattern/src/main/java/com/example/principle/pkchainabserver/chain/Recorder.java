package com.example.principle.pkchainabserver.chain;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
@Data
public class Recorder {
    //域名
    private String domain;
    //IP地址
    private String ip;
    //属主
    private String owner;
}
