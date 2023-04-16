package com.example.principle.pkchainabserver.chain;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/19
 */
public class ChinaTopDnsServer extends DnsServer {
    @Override
    protected Recorder echo(String domain) {
        Recorder recorder = super.echo(domain);
        recorder.setOwner("中国顶级DNS服务器");
        return recorder;
    }

    @Override
    protected boolean isLocal(String domain) {
        return domain.endsWith(".cn");
    }
}
