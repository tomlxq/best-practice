package com.tom.demo.jdbc.annotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Configuration
@ComponentScan(basePackages = "com.tom.demo.jdbc.annotation")
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {
    @Bean("dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        Properties properties = new Properties();
        properties.put("druid.url", "jdbc:mysql://192.168.238.150:3306/demo?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        properties.put("druid.username", "root");
        properties.put("druid.password", "root");
        properties.put("druid.initialSize", "1");
        properties.put("druid.minIdle", "1");
        properties.put("druid.maxActive", "20");

        properties.put("druid.maxWait", "60000");

        properties.put("druid.timeBetweenEvictionRunsMillis", "60000");

        properties.put("druid.minEvictableIdleTimeMillis", "300000");

        properties.put("druid.validationQuery", "SELECT 'x'");
        properties.put("druid.testWhileIdle", "true");
        properties.put("druid.testOnBorrow", "false");
        properties.put("druid.testOnReturn", "false");

        properties.put("druid.poolPreparedStatements", "false");
        properties.put("druid.maxPoolPreparedStatementPerConnectionSize", "20");

        properties.put("druid.filters", "stat");
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }
    /*@Bean
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.)
                .addScript("createOrderItemTable.sql")
                .build();
    }*/

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
