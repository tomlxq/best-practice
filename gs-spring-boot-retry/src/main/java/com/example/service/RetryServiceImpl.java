package com.example.service;

/**
 * 基于AOP实现，所以不支持类里自调用方法
 * 如果重试失败需要给@Recover注解的方法做后续处理，那这个重试的方法不能有返回值，只能是void
 * 方法内不能使用try catch，只能往外抛异常 @Recover注解来开启重试失败后调用的方法(注意,需跟重处理方法在同一个类中)，
 * 此注解注释的方法参数一定要是@Retryable抛出的异常，否则无法识别，可以在该方法中进行日志处理。
 *
 * @author TomLuo
 * @date 2023年03月12日 21:57
 */


import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Slf4j
public class RetryServiceImpl implements RetryService {
    /**
     * 注解中几个参数的含义：
     * <p>
     * value：抛出指定异常才会重试
     * include：和value一样，默认为空，当exclude也为空时，默认所有异常
     * exclude：指定不处理的异常
     * maxAttempts：最大重试次数，默认3次
     * backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；
     * multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒
     *
     * @param code
     * @return
     * @throws Exception 。
     */
    @Override
    @Retryable(value = IllegalArgumentException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5),
            recover = "recover")
    public int test(int code) throws Exception {
        log.info("test被调用,时间：{}", LocalTime.now());
        Preconditions.checkArgument(code != 0, "情况不对头！");

        log.info("test被调用,情况对头了！");

        return 200;
    }

    /**
     * 当重试耗尽时还是失败，会出现什么情况呢？
     * <p>
     * 当重试耗尽时，RetryOperations可以将控制传递给另一个回调，即RecoveryCallback。
     * Spring-Retry还提供了@Recover注解，用于@Retryable重试失败后处理方法。
     * 如果不需要回调方法，可以直接不写回调方法，那么实现的效果是，重试次数完了后，如果还是没成功没符合业务判断，就抛出异常。
     * 可以看到传参里面写的是 Exception e，这个是作为回调的接头暗号（重试次数用完了，还是失败，我们抛出这个Exception e通知触发这个回调方法）。
     * 对于@Recover注解的方法，需要特别注意的是：
     * 方法的返回值必须与@Retryable方法一致
     * 方法的第一个参数，必须是Throwable类型的，建议是与@Retryable配置的异常一致，其他的参数，需要哪个参数，写进去就可以了（@Recover方法中有的）
     * 该回调方法与重试方法写在同一个实现类里面
     */
    @Recover
    public int recover(IllegalArgumentException e, int code) {
        System.out.println("回调方法执行！！！！");
        //记日志到数据库 或者调用其余的方法
        return 400;
    }
}