package com.tom.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * qq
 *
 * @author TomLuo
 * @date 2023年05月13日 5:08
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {
    // 默认接口版本号1.0开始，这里我只做了两级，多级可在正则进行控制
    String value() default "1.0";
}