# 基本概念
Druid是阿里巴巴开发的号称为监控而生的数据库连接池，在功能、性能、扩展性方面，都超过其他数据库连接池，包括DBCP、C3P0、BoneCP、Proxool、JBoss DataSource等等等，秒杀一切

Spring Boot 默认数据源 HikariDataSource 与 JdbcTemplate中已经介绍 Spring Boot 2.x 默认使用 Hikari 数据源 ，可以说 Hikari 与 Driud 都是当前 Java Web 上最优秀的数据源。

* stat：Druid内置提供一个StatFilter,用于统计监控信息。
* wall：Druid防御SQL注入攻击的WallFilter就是通过Druid的SQL Parser分析。Druid提供的SQL Parser可以在JDBC层拦截SQL做相应处理，比如说分库分表、审计等。
* log4j2：这个就是 日志记录的功能，可以把sql语句打印到log4j2 供排查问题。

# 配置相关属性
* 配置Druid数据源（连接池） ： 如同以前 c3p0、dbcp 数据源可以设置数据源连接初始化大小、最大连接数、等待时间、最小连接数 等一样，Druid 数据源同理可以进行设置；
* 配置 Druid web 监控 filter（WebStatFilter） ： 这个过滤器的作用就是统计 web 应用请求中所有的数据库信息，比如 发出的 sql 语句，sql 执行的时间、请求次数、请求的 url 地址、以及seesion 监控、数据库表的访问次数 等等。
* 配置 Druid 后台管理 Servlet（StatViewServlet） ： Druid 数据源具有监控的功能，并提供了一个 web 界面方便用户查看，类似安装 路由器 时，人家也提供了一个默认的 web 页面；需要设置 Druid 的后台管理页面的属性，比如 登录账号、密码 等；

> 参数可以在找到
> `com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties`  
> `org.springframework.boot.autoconfigure.jdbc.DataSourceProperties`

# 监控页面
（1）启动项目后，访问 /druid/login.html 来到登录页面 ，输入用户名密码登录
（2）数据源页面 是当前DataSource配置的基本信息
（3）SQL监控页面 ，统计了所有SQL语句的执行情况
（4）URL监控页面 ，统计了所有Controller接口的访问以及执行情况
（5）Spring 监控页面，利用aop 对指定接口的执行时间，jdbc数进行记录
（6）SQL防火墙页面 druid提供了黑白名单的访问，可以清楚的看到sql防护情况
（7）Session监控页面 可以看到当前的session状况，创建时间、最后活跃时间、请求次数、请求时间等详细参数。
（8）JSONAPI 页面 通过api的形式访问Druid的监控接口，api接口返回Json形式数据。

# sql监控
配置 Druid web 监控 filter（WebStatFilter）这个过滤器，作用就是统计 web 应用请求中所有的数据库信息，比如 发出的 sql 语句，sql 执行的时间、请求次数、请求的 url 地址、以及seesion 监控、数据库表的访问次数 等等。

# spring 监控
访问之后spring监控默认是没有数据的；

这需要导入SprngBoot的AOP的Starter

<!--SpringBoot 的aop 模块-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
需要在 application.yml 配置:

Spring监控AOP切入点，如com.springboot.template.dao.*,配置多个英文逗号分隔

spring.datasource.druid.aop-patterns="com.springboot.template.dao.*"

# 获取 Druid 的监控数据
Druid 的监控数据可以在 开启 StatFilter 后 ，通过 DruidStatManagerFacade 进行获取;

DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，

除此之外 DruidStatManagerFacade 还提供了一些其他方法，可以按需选择使用。