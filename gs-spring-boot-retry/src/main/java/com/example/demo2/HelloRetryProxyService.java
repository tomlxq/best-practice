package com.example.demo2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * IHelloService
 *
 * @author TomLuo
 * @date 2023年05月27日 8:07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class HelloRetryProxyService implements IHelloService {

    private final HelloService helloRetryService;

    @Override
    public String hello() {
        int maxRetryTimes = 4;
        String s = "";
        for (int retry = 1; retry <= maxRetryTimes; retry++) {
            try {
                s = helloRetryService.hello();
                log.info("helloRetryService 返回：｛｝", s);
                return s;
            } catch (HelloRetryException e) {
                log.info("helloRetryService.hello()调用失败,准备重试");
            }
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new HelloRetryException("重试次数耗尽");
    }
}
