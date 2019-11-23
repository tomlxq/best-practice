package com.example.principle.pkchainabserver.abserver;

import com.example.principle.pkchainabserver.chain.Recorder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/20
 */
public class SHDnsServer extends DnsServer {
    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("上海DNS服务器");
    }

    //定义上海的DNS服务器能处理的级别
    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }
}