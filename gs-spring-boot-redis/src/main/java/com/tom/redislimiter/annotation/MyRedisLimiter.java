package com.tom.redislimiter.annotation;


import com.tom.redislimiter.enums.LimitType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis限流注解
 *
 * @author TomLuo
 * @date 2023年05月27日 20:38
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyRedisLimiter {

    /**
     * 缓存到Redis的key
     */
    String key();

    /**
     * Key的前缀
     */
    String prefix() default "limiter:";

    /**
     * 给定的时间范围 单位(秒)
     * 默认1秒 即1秒内超过count次的请求将会被限流
     */
    int period() default 1;

    /**
     * 一定时间内最多访问的次数
     */
    int count();

    /**
     * 限流的维度(用户自定义key 或者 调用方ip)
     */
    LimitType limitType() default LimitType.CUSTOMER;
}
