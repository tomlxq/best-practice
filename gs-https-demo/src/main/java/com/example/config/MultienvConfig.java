package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/19
 */
@Component
@ConfigurationProperties(prefix = "server")
@Setter
@Getter
public class MultienvConfig {
    private int port;
}
