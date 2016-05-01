使用Spring Boot快速构建应用
Spring Boot充分利用了JavaConfig的配置模式以及“约定优于配置”的理念，能够极大的简化基于Spring MVC的Web应用和REST服务开发。

Spring 4倡导微服务的架构，针对这一理念，近来在微博上也有一些有价值的讨论，如这里和这里。微服务架构倡导将功能拆分到离散的服务中，独立地进行部署，Spring Boot能够很方便地将应用打包成独立可运行的JAR包，因此在开发模式上很契合这一理念。

要Spring Boot进行功能开发，需要使用Gradle或者Maven作为构建工具。

1. 将工程的parent设置为spring-boot-starter-parent，并添加对spring-boot-starter-web的依赖，这样我们就无需设置各个依赖项及其版本信息了。
2. 在构建中要声明使用spring-boot-maven-plugin这个插件，它会对Maven打包形成的JAR进行二次修改，最终产生符合我们要求的内容结构。

声明一个主类启动这个应用程序：

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
这个类的main方法中使用了SpringApplication帮助类，并以Application这个类作为配置来启动Spring的应用上下文。
其中ComponentScan注解会告知Spring扫描指定的包来初始化Spring Bean，这能够确保我们声明的Bean能够被发现。
EnableAutoConfiguration将会启动自动配置模式，在我们的配置中会将对Tomcat的依赖级联进来，因此在应用启动时将会自动启动一个嵌入式的Tomcat，因为在样例中使用了Spring MVC，所以也会自动注册所需的DispatcherServlet，这都不需要类似web.xml这样的配置。