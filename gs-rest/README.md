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
运行方式:
1. 直接以Java Application的形式来运行这个main函数
2. Maven插件的package命令，最终会形成一个可运行的JAR包。我们使用java –jar命令就可以运行这个JAR包

JAR包转换成可以在Servlet容器中部署的WAR
就不能依赖于Application的main函数了，而是要以类似于web.xml文件配置的方式来启动Spring应用上下文，此时我们需要声明这样一个类：

public class HelloWebXml extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
这个类的作用与在web.xml中配置负责初始化Spring应用上下文的监听器作用类似，只不过在这里不需要编写额外的XML文件了。
 
 如果要将最终的打包形式改为WAR的话，还需要对pom.xml文件进行修改，除了需要将packaging的值修改为war以外，还需要对依赖进行适当的配置（这一部分在Spring Boot的样例和文档中均未提及，提醒大家注意）：
 
 <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId> 
            <exclusions>
            	<exclusion>
            		<groupId>org.springframework.boot</groupId>
         		<artifactId>spring-boot-starter-tomcat</artifactId>
            	</exclusion>
            </exclusions> 
 </dependency>

在这里需要移除对嵌入式Tomcat的依赖，这样打出的WAR包中，在lib目录下才不会包含Tomcat相关的JAR包，否则将会出现启动错误。另外，在移除对Tomcat的依赖后，为了保证编译正确，还需要添加对servlet-api的依赖，因此添加如下的配置：

		
<dependency>
        	<groupId>org.apache.tomcat</groupId>
        	<artifactId>tomcat-servlet-api</artifactId>
        	<version>8.0.3</version>
        	<scope>provided</scope>
</dependency>
在这里将scope属性设置为provided，这样在最终形成的WAR中不会包含这个JAR包，因为Tomcat或Jetty等服务器在运行时将会提供相关的API类。
此时，执行mvn package命令就会得到一个WAR文件，我们可以直接将其放到Tomcat下运行。

maven部署web项目到tomcat7(兼容tomcat8)
  <plugin>  
        <groupId>org.apache.tomcat.maven</groupId>  
        <artifactId>tomcat7-maven-plugin</artifactId>  
        <version>2.2</version>  
        <configuration>  
            <path>/${project.artifactId}</path>  
        </configuration>  
    </plugin>  


参考资料

http://projects.spring.io/spring-boot/

http://projects.spring.io/spring-boot/docs/README.html

http://spring.io/guides/gs/spring-boot/

http://spring.io/guides/gs/actuator-service/

http://spring.io/guides/gs/convert-jar-to-war/