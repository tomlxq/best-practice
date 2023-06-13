package com.example.demo2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * config
 *
 * @author TomLuo
 * @date 2023年05月26日 6:36
 */
@ComponentScan("com.example.demo2")
@EnableAspectJAutoProxy
@EnableRetry
public class config {
}