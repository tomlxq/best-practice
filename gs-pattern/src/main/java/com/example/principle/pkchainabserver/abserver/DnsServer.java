package com.example.principle.pkchainabserver.abserver;

import com.example.principle.pkchainabserver.chain.Recorder;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/20
 */
public abstract class DnsServer extends Observable implements Observer {
    //处理请求，也就是接收到事件后的处理
    public void update(Observable arg0, Object arg1) {
        Recorder recorder = (Recorder) arg1;
//如果本机能解析
        if (isLocal(recorder)) {
            recorder.setIp(genIpAddress());
        } else {//本机不能解析，则提交到上级DNS
            responsFromUpperServer(recorder);
        }
//签名
        sign(recorder);
    }

    //作为被观察者，允许增加观察者，这里上级DNS一般只有一个
    public void setUpperServer(DnsServer dnsServer) {
//先清空，然后再增加
        super.deleteObservers();
        super.addObserver(dnsServer);
    }

    //向父DNS请求解析，也就是通知观察者
    private void responsFromUpperServer(Recorder recorder) {
        super.setChanged();
        super.notifyObservers(recorder);
    }

    //每个DNS服务器签上自己的名字
    protected abstract void sign(Recorder recorder);

    //每个DNS服务器都必须定义自己的处理级别
    protected abstract boolean isLocal(Recorder recorder);

    //随机产生一个IP地址，工具类
    private String genIpAddress() {
        Random rand = new Random();
        String address = rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255) + "." + rand.nextInt(255);
        return address;
    }
}