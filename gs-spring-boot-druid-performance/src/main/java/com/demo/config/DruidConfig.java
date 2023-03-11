package com.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;

/**
 * DruidConfig
 *
 * @author TomLuo
 * @date 2023年03月11日 16:30
 */
@Order(1)
@Configuration
public class DruidConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource druidDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
