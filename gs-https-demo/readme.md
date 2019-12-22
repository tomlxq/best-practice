# gs-https-demo

## 什么是SSL?

SSL(Secure Sockets Layer [安全套接层](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%AE%89%E5%85%A8%E5%A5%97%E6%8E%A5%E5%B1%82)),及其继任者[传输层安全](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E5%B1%82%E5%AE%89%E5%85%A8)（Transport Layer Security，TLS）是为[网络通信](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E7%BD%91%E7%BB%9C%E9%80%9A%E4%BF%A1)提供安全及[数据完整性](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%95%B0%E6%8D%AE%E5%AE%8C%E6%95%B4%E6%80%A7)的一种安全协议。TLS与SSL在[传输层](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E5%B1%82)对网络连接进行加密。

SSL协议位于[TCP/IP协议](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/TCP%2FIP%E5%8D%8F%E8%AE%AE)与各种[应用层](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%BA%94%E7%94%A8%E5%B1%82)协议之间，为[数据通讯](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%95%B0%E6%8D%AE%E9%80%9A%E8%AE%AF)提供安全支持。SSL协议可分为两层： SSL记录协议（SSL Record Protocol）：它建立在可靠的[传输协议](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E4%BC%A0%E8%BE%93%E5%8D%8F%E8%AE%AE)（如TCP）之上，为高层协议提供[数据封装](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%95%B0%E6%8D%AE%E5%B0%81%E8%A3%85)、压缩、加密等基本功能的支持。 SSL[握手协议](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%8F%A1%E6%89%8B%E5%8D%8F%E8%AE%AE)（SSL Handshake Protocol）：它建立在SSL记录协议之上，用于在实际的数据传输开始前，通讯双方进行[身份认证](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E8%BA%AB%E4%BB%BD%E8%AE%A4%E8%AF%81)、协商[加密算法](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%8A%A0%E5%AF%86%E7%AE%97%E6%B3%95)、交换加密[密钥](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%AF%86%E9%92%A5)等。



 ### 提供服务

1）认证用户和服务器，确保数据发送到正确的[客户机](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%AE%A2%E6%88%B7%E6%9C%BA)和[服务器](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%9C%8D%E5%8A%A1%E5%99%A8)；

2）加密数据以防止数据中途被窃取；

3）维护数据的完整性，确保数据在传输过程中不被改变。

## 什么是HTTPS?

HTTPS（**Hypertext Transfer Protocol Secure**）[安全超文本传输协议](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%AE%89%E5%85%A8%E8%B6%85%E6%96%87%E6%9C%AC%E4%BC%A0%E8%BE%93%E5%8D%8F%E8%AE%AE)

它是由Netscape开发并内置于其[浏览器](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%B5%8F%E8%A7%88%E5%99%A8)中，用于对数据进行压缩和解压操作，并返回网络上传送回的结果。HTTPS实际上应用了Netscape的完全[套接字](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%A5%97%E6%8E%A5%E5%AD%97)层（SSL）作为HTTP[应用层](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%BA%94%E7%94%A8%E5%B1%82)的子层。（HTTPS使用端口443，而不是象HTTP那样使用端口80来和TCP/IP进行通信。）SSL使用40 位关键字作为RC4流[加密算法](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E5%8A%A0%E5%AF%86%E7%AE%97%E6%B3%95)，这对于商业信息的加密是合适的。HTTPS和SSL支持使用X.509[数字认证](https://link.zhihu.com/?target=https%3A//baike.baidu.com/item/%E6%95%B0%E5%AD%97%E8%AE%A4%E8%AF%81)，如果需要的话用户可以确认发送者是谁。

**HTTPS与SSL的关系？**

HTTPS与SSL的关系是包含与被包含的关系，简单来说，HTTPS=HTTP+SSL。也就是说HTTPS是在HTTP上面加了一层SSL协议，在HTTP站点上部署SSL数字证书就变成了HTTPS。

根据HTTPS与SSL的含义可以看出：SSL在HTTPS协议栈中负责实现上面提到的加密层。

## Spring Boot中使用HTTPS步骤

（1）要有一个SSL证书，证书怎么获取呢？买（通过证书授权机构购买）或者自己生成（通过keytool生成）。

（2）在spring boot中启用HTTPS

（3）将HTTP重定向到HTTPS（可选）

`keytool -genkey -alias tom -dname "CN=www.tom.com,OU=IT Dept,O=Huawei,L=GuangDong,ST=ShenZhen,C=CN" -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 365`

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

在application.properties中配置HTTPS，配置信息如下：

```properties
#https端口号.
server.port: 443
#证书的路径.
server.ssl.key-store: classpath:keystore.p12
#证书密码，请修改为您自己证书的密码.
server.ssl.key-store-password: 123456
#秘钥库类型
server.ssl.keyStoreType: PKCS12
#证书别名
server.ssl.keyAlias: tom
```

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