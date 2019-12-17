# gs-https-demo

## spring boot依赖包方式 

### parent

```xml
 <parent>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-parent</artifactId>
     <version>2.2.2.RELEASE</version>
     <relativePath/>
 </parent>
```

### dependencyManagement

```xml
<dependencyManagement>
 <dependencies>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-dependencies</artifactId>
   <version>2.2.2.RELEASE</version>
   <type>pom</type>
   <scope>import</scope>
  </dependency>
 </dependencies>
 </dependencyManagement>
```



## 产生自签名证书

1. 产生自签名证书
   `keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -keystore www.baidu.com.jks -validity 3650 -dname "C=CN,ST=GuangDong,L=ShenZhen,O=baidu,OU=it dept,CN=www.baidu.com" -storepass 123456  -keypass 123456` 
   `keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore www.baidu.com.p12 -validity 3650 -dname "C=CN,ST=GuangDong,L=ShenZhen,O=baidu,OU=it dept,CN=www.baidu.com" -storepass 123456 -keypass 123456` 

   这里解释下命令的各个参数的含义：

   -genkey ：生成key；

   -alias ：key的别名；

   -dname：指定证书拥有者信息

   -storetype ：密钥库的类型为JCEKS。常用的有JKS(默认),JCEKS(推荐),PKCS12,BKS,UBER。每个密钥库只可以是其中一种类型。

   -keyalg ：DSA或RSA算法(当使用-genkeypair参数)，DES或DESede或AES算法(当使用-genseckey参数)；

   -keysize ：密钥的长度为512至1024之间(64的倍数)

   -keystore ：证书库的名称

   -validity ： 指定创建的证书有效期多少天

   dname的值详解： 

   CN(Common Name名字与姓氏) 

   OU(Organization Unit组织单位名称) 

   O(Organization组织名称) 

   L(Locality城市或区域名称) 

   ST(State州或省份名称) 

   C(Country国家名称） 

2. 检查自签名证书的内容
   `keytool -list -v -keystore www.baidu.com.jks -storepass 123456`
   `keytool -list -v -storetype pkcs12 -keystore www.baidu.com.p12 -storepass 123456` 

3. 证书迁移JKS到PKCS12（Optional）
   `keytool -importkeystore -srckeystore  www.baidu.com.jks  -destkeystore www.baidu.com.migrate.p12 -deststoretype pkcs12`

## 使用一个存在的证书

1. 使用一个存在的证书（Optional）
   keytool -import -alias tomcat -file myCertificate.crt -keystore keystore.p12 -storepass password

> `keytool -genkey -alias www.baidu.com -sigalg SHA256withRSA -keyalg RSA -keysize 2048 -keystore www.baidu.com.jks -dname "C=CN,ST=GuangDong,L=ShenZhen,O=baidu,OU=it dept,CN=www.baidu.com" && keytool -certreq -alias www.baidu.com -file www.baidu.com.csr -keystore www.baidu.com.jks && echo Your certificate signing request file is www.baidu.com.csr.  Your keystore file is www.baidu.com.jks. ` 



## Distribute the SSL certificate to clients

`keytool -export -keystore keystore.jks -alias tomcat -file myCertificate.crt`

## Import the certificate inside the JRE keystore

To make the JRE trust your certificate, you need to import it inside *cacerts*: the JRE keystore in charge of holding certificates.

You'll be asked to input the JRE keystore password. If you have never changed it, it should be the default one: *changeit* or *changeme*

`keytool -importcert -file myCertificate.crt -alias tomcat -keystore $JDK_HOME/jre/lib/security/cacerts`

## spring boot的配置

```properties
# Define a custom port instead of the default 8080
server.port=8443

# Tell Spring Security (if used) to require requests over HTTPS
# If your project is using Spring Security, you should set the security.require-ssl property to true to automatically block any requests coming from HTTP
security.require-ssl=true

# The format used for the keystore 
# The server.ssl.key-store-type property defines the format used for the keystore (either JKS or PKCS12)
server.ssl.key-store-type=PKCS12
# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore.p12
# The password used to generate the certificate
server.ssl.key-store-password=password
# The alias mapped to the certificate
server.ssl.key-alias=tomcat
```

`server.ssl.key-store-type` property defines the format used for the keystore (either JKS or PKCS12

>```xml
>server.ssl.enabled=true
>server.ssl.key-store=/path/to/server.p12
>server.ssl.key-store-type=PKCS12
>server.ssl.key-store-password=secret
>server.ssl.key-alias=server
>server.ssl.key-password=secret
>```

## Issuers:

### TomcatEmbeddedServletContainerFactory is missing in Spring Boot 2

In Spring boot [2.0.0.RELEASE](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Migration-Guide#embedded-containers-package-structure) you can replace with following code

```java
@Bean
public ServletWebServerFactory servletContainer() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
        @Override
        protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        }
    };
    tomcat.addAdditionalTomcatConnectors(redirectConnector());
    return tomcat;
}

private Connector redirectConnector() {
    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setScheme("http");
    connector.setPort(8080);
    connector.setSecure(false);
    connector.setRedirectPort(8443);
    return connector;
}
```



```JAVA
@Configuration
@Data
public class TomcatConfiguration {

@Value("${tomcat.ajp.port}")
int ajpPort;

@Value("${tomcat.ajp.remoteauthentication}")
String remoteAuthentication;

@Value("${tomcat.ajp.enabled}")
boolean tomcatAjpEnabled;

@Bean
public TomcatServletWebServerFactory servletContainer() {

    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    if (tomcatAjpEnabled)
    {
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(ajpPort);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("https");
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
    }

    return tomcat;
  }

}
```

## References：

* https://myssl.com/csr_create.html

* How to enable HTTPS in a Spring Boot Java application

    https://www.thomasvitale.com/https-spring-boot-ssl-certificate/

* Spring Boot 使用SSL-HTTPS 

  https://zhuanlan.zhihu.com/p/31385073

* How to enable communication over https between 2 spring boot  applications using self signed certificate

    http://www.littlebigextra.com/how-to-enable-communication-over-https-between-2-spring-boot-applications-using-self-signed-certificate/
    
* https://raymii.org/s/tutorials/OpenSSL_command_line_Root_and_Intermediate_CA_including_OCSP_CRL%20and_revocation.html

* https://www.cnblogs.com/sparkdev/p/10369313.html

* OpenSSL command line Root and Intermediate CA including OCSP, CRL and revocation

    https://raymii.org/s/tutorials/OpenSSL_command_line_Root_and_Intermediate_CA_including_OCSP_CRL%20and_revocation.html