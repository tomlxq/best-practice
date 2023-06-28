package com.tom.demo.guide.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月05日 18:24
 */
@MapperScan("com.tom.demo")//扫描mapper文件夹
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig  {

//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
//
//    /**
//     * 分页插件
//     * @return
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }

    /**
     * 逻辑删除组件
     * @return
     */
   /* @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }*/

    /*
     * SQL执行效率插件
     * */
   /* @Bean
    @Profile({"dev","test"})//设置dev test 环境开启，保证我们的效率
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);//ms  设置SQL执行的最大时间，如果超过了则不执行
        performanceInterceptor.setFormat(true);//是否格式化代码
        return performanceInterceptor;
    }*/
}