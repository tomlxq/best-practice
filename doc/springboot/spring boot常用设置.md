# spring boot常用设置

## debug ssl

* `-Djavax.net.debug=SSL,handshake,data,trustmanager` 
* `-Djavax.net.debug=all -Djava.security.debug=provider`

## 配置多环境

### 配置不同的配置文件
- application.yml
- application-dev.yml（开发环境）
- application-test.yml（测试环境）
- application-uat.yml（预发布环境）
- application-prod.yml（生产环境）
### 指定环境
### 在 cmd 命令中指定
```
java -jar xxx.jar --spring.profiles.actvie=dev 
```
### 在 application.yml 中指定
```
spring:
  profiles:
    active: dev
```
### 在IDEA 编辑器中指定
在运行按钮（绿色三角形按钮）旁边选择 `Edit Configurations...`，在弹出的对话框中 Active profiles 输入 dev 或其他即可。
**这种方法只有在本地调试的时候才生效**

### 程序中获取 applicaton 中的值

```
@Component
@ConfigurationProperties(prefix = "springstudy")
public class MultienvConfig {
    private String demoname;

    public String getDemoname() {
        return demoname;
    }

    public void setDemoname(String demoname) {
        this.demoname = demoname;
    }
}
```

## Log 日志概述

### 功能点

1. ***记录一切\*** 日志帮助我们记录程序功能都干了什么，无论是正常的输入输出还是出现异常，都可以用日志记录
2. ***定位问题\*** 日志可以帮助程序员调试问题，帮助测试人员定位问题
3. ***记录分析用户行为\*** 统计分析师用来记录用户的一起行为，用于分析用户的习惯和商业价值
4. ***备份和还原实时数据\*** 数据库工程师用来作为一种特殊的数据库

### 日志的级别 Log Level

日志级别是对日志记录信息的轻重缓急的划分。通常从轻到重划分为：

1. TRACE
2. DEBUG
3. INFO
4. WARN
5. ERROR

### 日志的输出 Log Import

通常日志以文本流的形式存储在磁盘，也可以把日志存储在关系型数据库中或 No Sql 中

1. 文本
2. 关系型数据库
3. No Sql
4. Console 控制台

一般日志组件都可以自定义输出格式。

### 关于 Logback

在 Spring Boot 中，logback 是基于 slf4j 实现的。

slf4j的全称是Simple Loging Facade For Java，即它仅仅是一个为Java程序提供日志输出的统一接口，并不是一个具体的日志实现方案，他能够实现大部分 日志组件。



![image-20191219080939887](img\image-20191219080939887.png)

**实际上，Spring Boot 是一种约定大于配置，也就是说，他本身有一个配置文件叫 `base.xml` ，在这个配置文件里面，已经默认配置了输出的日志级别** 让我们来看看 `base.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<included>
	<include resource="org/springframework/boot/logging/logback/defaults.xml" />
	<property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/spring.log}"/>
	<include resource="org/springframework/boot/logging/logback/console-appender.xml" />
	<include resource="org/springframework/boot/logging/logback/file-appender.xml" />
	<root level="INFO">
		<appender-ref ref="CONSOLE" />
		<appender-ref ref="FILE" />
	</root>
</included>
```

