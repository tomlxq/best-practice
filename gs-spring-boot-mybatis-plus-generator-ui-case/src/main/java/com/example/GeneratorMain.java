package com.example;

import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;

/**
 * GeneratorMain
 *
 * @author TomLuo
 * @date 2023年03月12日 14:48
 */
public class GeneratorMain {

    public static void main(String[] args) {
        GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:p6spy:mysql://192.168.238.150:3306/demo?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&serverTimeZone=GMT%2B8")
                .userName("root").password("root").driverClassName("com.p6spy.engine.spy.P6SpyDriver")
                // 数据库schema，POSTGRE_SQL,ORACLE,DB2类型的数据库需要指定
                .schemaName("demo")
                // 如果需要修改各类生成文件的默认命名规则，可自定义一个NameConverter实例，覆盖相应的名称转换方法：
                .nameConverter(new NameConverter() {
                    /**
                     * 自定义Service类文件的名称规则
                     */
                    public String serviceNameConvert(String tableName) {
                        return this.entityNameConvert(tableName) + "Service";
                    }

                    /**
                     * 自定义Controller类文件的名称规则
                     */
                    public String controllerNameConvert(String tableName) {
                        return this.entityNameConvert(tableName) + "Controller";
                    }
                }).basePackage("com.example").port(8068).build();

        MybatisPlusToolsApplication.run(config);

    }

}