package com.example.demo2;

import com.example.demo2.annotation.HelloAnnotationService;
import com.example.demo2.annotation.HelloSpringRetryService;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HelloServiceTest
 *
 * @author TomLuo
 * @date 2023年05月26日 6:34
 */

@SpringBootTest(classes = config.class)
@Slf4j
class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Autowired
    @Qualifier("helloService2")
    private IHelloService iHelloService;


    @Autowired
    private HelloAnnotationService helloAnnotationService;
    @Autowired
    private HelloSpringRetryService helloSpringRetryService;
    //手动重试

    public String helloByManual() {
        int maxRetryTimes = 4;
        String s = "";

        for (int retry = 1; retry <= maxRetryTimes; retry++) {
            try {

                s = helloService.hello();

                log.info("helloService返回：｛｝", s);
                return s;

            } catch (HelloRetryException e) {

                log.info("helloService.hello() 调用失败,准备重试");
            }

        }

        throw new HelloRetryException("重试次数耗尽");
    }

    /**
     * 手动重试
     * 需要对业务代码进行大量修改，虽然实现了功能，但是对原有代码的侵入性太强，可维护性差。
     */
    @Test
    void helloByManualTest() {
        helloByManual();
    }

    /**
     * 重试逻辑就都由代理类来完成，原业务类的逻辑就不需要修改了，以后想修改重试逻辑也只需要修改这个类就行了，分工明确。
     * 比如，现在想要在重试之间加上一个延迟，只需要做一点点修改即可
     */
    @Test
    public void helloByInterfaceTest() {
        iHelloService.hello();
    }

    @Test

    public void helloJdkProxyProxy() {
        IHelloService realService = new HelloService2();
        IHelloService proxyService = (IHelloService) RetryInvocationHandler.getProxy(realService);
        String hello = proxyService.hello();
        log.info("hello:{}", hello);
    }

    @Test

    public void helloCGLibProxy() {
        final CGLibRetryProxyHandler cgLibRetryProxyHandler = new CGLibRetryProxyHandler();
        IHelloService realService = new HelloService2();
        IHelloService proxyService = (IHelloService) cgLibRetryProxyHandler.getCglibProxy(realService);
        String hello = proxyService.hello();
        log.info("hello:{}", hello);
    }

    @Test
    public void helloAopTest() {
        helloAnnotationService.hello();
    }

    @Test
    public void helloSpringRetryTest() {
        helloSpringRetryService.hello();
    }

    @Test
    public void normalSpringRetry() {

        // 表示异常试，key表示异常的字节码，value为true表示需试

        Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();
        exceptionMap.put(HelloRetryException.class, true);

        //设置垂试退操作须格，主要设置重试问时间
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy backoffPolicy = new FixedBackOffPolicy();
        long fixedPeriodTime = 1000L;

        backoffPolicy.setBackOffPeriod(fixedPeriodTime);
        // 设置试策略，主要设置单拭次数

        int maxRetryTimes = 3;

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(maxRetryTimes, exceptionMap);
        retryTemplate.setRetryPolicy(retryPolicy);

        retryTemplate.setBackOffPolicy(backoffPolicy);
        Boolean execute = retryTemplate.execute(

                retryContext -> {

                    String hello = helloService.hello();
                    log.info("调用的结果：{}", hello);
                    return true;

                },

                retryContext -> {

                    log.info("已达到最大重试次数");
                    return false;
                });
    }

    @Test
    public void guavaRetry() {
        Retryer<String> retryer = RetryerBuilder.<String>newBuilder()
                .retryIfExceptionOfType(HelloRetryException.class)
                .retryIfResult(StringUtils::isEmpty)
                .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        try {
            retryer.call(() -> helloService.hello());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}