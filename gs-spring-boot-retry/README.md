在日常开发过程中，难免会与第三方接口发生交互，例如：短信发送、远程服务调用、争抢锁等场景，当正常调用发生异常时，例如：网络抖动，这些间歇性的异常在一段时候之后会自行恢复，程序为了更加健壮并且更不容易出现故障，需要重新触发业务操作，以防止间歇性的异常对程序照成的影响。

常用的重试策略，比如通过 while 循环手动重复调用或是通过 JDK/CGLib 动态代理的方式来进行重试。但是这种方法比较笨重，且对原有逻辑代码的入侵性比较大。

spring系列的spring-retry是另一个实用程序模块，可以帮助我们以标准方式处理任何特定操作的重试。在spring-retry中，所有配置都是基于简单注释的。


## 1、引入spring-retry
```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.retry</groupId>
<artifactId>spring-retry</artifactId>
</dependency>
```
这里我们还引入了 aop 的依赖，因为 spring-retry 的原理就是基于 aop 来实现的


## 2、开启spring-retry
启动类上增加注解 @EnableRetry

## 3、@Retryable
在需要重试的方法上增加注解 @Retryable，表示该方法需要重试

@Retryable 注解

value，可重试的异常类型。含义同include。默认为空(如果excludes也为空，则重试所有异常)
include：可重试的异常类型。默认为空(如果excludes也为空，则重试所有异常)
exclude：无需重试的异常类型。默认为空(如果includes也为空，则重试所有异常)
maxAttempts：最大重试次数(包括第一次失败)，默认为3次
backoff：重试等待策略,下面会在@Backoff中介绍
recover：表示重试次数到达最大重试次数后的回调方法


@Backoff 注解

delay，重试之间的等待时间(以毫秒为单位)
maxDelay，重试之间的最大等待时间(以毫秒为单位)
multiplier，指定延迟的倍数
delayExpression，重试之间的等待时间表达式
maxDelayExpression，重试之间的最大等待时间表达式
multiplierExpression，指定延迟的倍数表达式
random，随机指定延迟时间

## 4、重试耗尽
当重试耗尽时，RetryOperations 可以将控制传递给另一个回调，即 RecoveryCallback。Spring-Retry 还提供了 @Recover 注解，用于 @Retryable 重试失败后处理方法。若不需要重试失败后的处理方法，则不写回调方法，重试耗尽后抛出异常。
方法的返回值必须与 @Retryable 方法一致
方法的第一个参数，必须是 Throwable 类型的，建议是与 @Retryable 配置的异常一致，其他的参数，需要哪个参数，写进去就可以了（@Recover 方法中有的）
该回调方法与重试方法写在同一个实现类里面

## 5、注意事项
由于是基于 AOP 实现，所以不支持类里自调用方法
如果重试失败需要给 @Recover 注解的方法做后续处理，那这个重试的方法不能有返回值，只能是 void
方法内不能使用 try catch，只能往外抛异常
@Recover 注解来开启重试失败后调用的方法(注意,需跟重处理方法在同一个类中)，此注解注释的方法参数一定要是 @Retryable 抛出的异常，否则无法识别，可以在该方法中进行日志处理。