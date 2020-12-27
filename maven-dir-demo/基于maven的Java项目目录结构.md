## 基于maven的Java项目目录结构

在JavaWeb的开发中，由于需要用到很多的包，所以出现了一种专门对包进行管理和下载的工具，成为自动化构建工具。在Java 平台，自动化构建工具的发展经历了Make ==> Ant ==> Maven ==> Gradle(最新)。 本文以maven为研究对象，探究基于Maven工具构建的Java项目的基本目录结构，以及官方所提供的一些maven项目模板。

### **1. 基于Maven的基本项目目录**

maven项目采用“**约定优于配置**”的原则：

- src/main/java：约定用于存放源代码，
- src/test/java：用于存放单元测试代码，（测试代码的包应该和被测试代码包结构保持一致，方便测试查找）
- src/target：用于存放编译、打包后的输出文件。

Maven默认约定了一套目录结构，在通过Maven创建了项目以后，项目的目录结构就是以这套目录结构作为模板创建的。虽然Maven提供了很多的模板，但是基本的目录结构都是固定的。如下所示。

```text
${basedir}
src
  -main
      –bin 脚本库
      –java java源代码文件
      –resources 资源库，会自动复制到classes目录里
      –filters 资源过滤文件
      –assembly 组件的描述配置（如何打包）
      –config 配置文件
      –webapp web应用的目录。WEB-INF、css、js等
  -test
      –java 单元测试java源代码文件
      –resources 测试需要用的资源库
      –filters 测试资源过滤库
  -site Site（一些文档）
target
LICENSE.txt Project’s license
README.txt Project’s readme
```

在使用maven来创建的项目，默认会自动创建src/main/等级别的结构。其中各个目录所存放的内容如下：

- src/main/java 项目的源代码所在的目录
- src/main/resources 项目的资源文件所在的目录
- src/main/filters 项目的资源过滤文件所在的目录
- src/main/webapp 如果是web项目，则该目录是web应用源代码所在的目录，比如html文件和web.xml等都在该目录下。
- src/test/java 测试代码所在的目录
- src/test/resources 测试相关的资源文件所在的目录
- src/test/filters 测试相关的资源过滤文件所在的目录

工程根目录下就只有src和target两个目录
target是有存放项目构建后的文件和目录，jar包、war包、编译的class文件等。
target里的所有内容都是maven构建的时候生成的

### **2. 基于Maven模板构建的三种常见Java项目**

新建Maven project项目时，需要选择archetype。archetype的意思就是模板原型的意思，原型是一个Maven项目模板工具包。原型将帮助作者为用户创建Maven项目模板，规范了项目的结构。根据所创建项目的不同，常见的三种模板有：

1. maven-archetype-quickstart
2. maven-archetype-webapp
3. cocoon-22-archetype-webapp

#### **2.1 maven工程样例 maven-archetype-quickstart 目录结构**

使用idea,基于maven-archetype-quickstart模板，创建一个名为quickStart的项目之后，得到的目录如下所示：

![img](img\v2-039bd31e233708f66cb9f35d71b54da4_720w.jpg)

默认的Archetype,基本内容包括：

- 一个包含**junit**依赖声明的pom.xml
- src/main/java主代码目录及一个名为App的类
- src/test/java测试代码目录及一个名为AppTest的测试用例。

从上图的结构分析可知，该模板适用于简单的Java项目，且没有相关的resources文件夹，说明此模板用于简单类的使用。如果涉及到相关配置文件，需要自定义资源文件夹，并指定为Resource。

#### **2.2 maven工程样例 maven-archetype-webapp**

使用idea,基于maven-archetype-quickstart模板，创建一个名为webapp的项目之后，得到的目录如下所示：

![img](https://pic1.zhimg.com/80/v2-05c7a664aea7297cb55bf5df63d0ed34_720w.jpg)



一个最简单的Maven war项目模板，当需要快速创建一个Web应用的时候可以使用它。生成的项目内容包括：

- 一个packaging为war且带有**junit**依赖声明的pom.xml
- src/main/webapp/目录
- src/main/webapp/index.jsp文件
- src/main/webapp/WEB-INF/web.xml文件

从上面的分析可知，该目录结构中，在src下，仅仅含有一个webapp的目录，其中的内容是前端的内容。如果需要写Java后端的代码，只需在main目录下，创建java/com.xxx.xxx.controller等相关目录结构即可。

#### **2.3 maven工程样例 cocoon-22-archetype-webapp**

使用idea,基于cocoon-22-archetype-webapp模板，创建一个名为cocoonWebapp的项目之后，得到的目录如下所示：

![img](https://pic3.zhimg.com/80/v2-495da83ec87eb2c60785efbc4b5b143e_720w.jpg)



一个最简单的Maven war项目模板，当需要快速创建一个Web应用的时候可以使用它。生成的项目内容包括：

- 一个packaging为war的pom.xml
- src/main/webapp/resources目录
- src/main/webapp/WEB-INF目录
- src/main/webapp/WEB-INF/applicationContext.xml文件
- src/main/webapp/WEB-INF/log4j.xml文件
- src/main/webapp/WEB-INF/web.xml文件

通过上面的分析可知，该模板提供了webapp中常见的resource文件夹，用于放置配置文件。以及在webapp中常见的一些配置文件,如日志配置文件log4j.xml,Spring的配置文件applicationContext.xml以及web工程的配置文件web.xml。基于该模板开发，相关Java代码可以在src/main目录下，新建java/com/xxx/xxx结构的目录即可。

### **3. Maven 的41种骨架功能介绍**

Maven 的41种骨架：

1: internal -> appfuse-basic-jsf (创建一个基于Hibernate，Spring和JSF的Web应用程序的原型)

2: internal -> appfuse-basic-spring (创建一个基于Hibernate，Spring和Spring MVC的Web应用程序的原型)

3: internal -> appfuse-basic-struts (创建一个基于Hibernate，Spring和Struts 2的Web应用程序的原型)

4: internal -> appfuse-basic-tapestry (创建一个基于Hibernate, Spring 和 Tapestry 4的Web应用程序的原型)

5: internal -> appfuse-core (创建一个基于 Hibernate and Spring 和 XFire的jar应用程序的原型)

6: internal -> appfuse-modular-jsf (创建一个基于 Hibernate，Spring和JSF的模块化应用原型)

7: internal -> appfuse-modular-spring (创建一个基于 Hibernate, Spring 和 Spring MVC 的模块化应用原型)

8: internal -> appfuse-modular-struts (创建一个基于 Hibernate, Spring 和 Struts 2 的模块化应用原型)

9: internal -> appfuse-modular-tapestry (创建一个基于 Hibernate, Spring 和 Tapestry 4 的模块化应用原型)

10: internal -> maven-archetype-j2ee-simple (一个简单的J2EE的Java应用程序)

11: internal -> maven-archetype-marmalade-mojo (一个Maven的 插件开发项目 using marmalade) 12: internal -> maven-archetype-mojo (一个Maven的Java插件开发项目)

13: internal -> maven-archetype-portlet (一个简单的portlet应用程序)

14: internal -> maven-archetype-profiles (基本轮廓，和maven-archetype-quickStart类似)

15: internal -> maven-archetype-quickstart (Maven工程样例)

16: internal -> maven-archetype-site-simple (简单的网站生成项目)

17: internal -> maven-archetype-site (更复杂的网站项目)

18: internal -> maven-archetype-webapp (一个简单的Java Web应用程序)

19: internal -> jini-service-archetype (Archetype for Jini service project creation)

20: internal -> softeu-archetype-seam (JSF+Facelets+Seam Archetype)

21: internal -> softeu-archetype-seam-simple (JSF+Facelets+Seam (无残留) 原型)

22: internal -> softeu-archetype-jsf (JSF+Facelets 原型)

23: internal -> jpa-maven-archetype (JPA 应用程序)

24: internal -> spring-osgi-bundle-archetype (Spring-OSGi 原型)

25: internal -> confluence-plugin-archetype (Atlassian 聚合插件原型)

26: internal -> jira-plugin-archetype (Atlassian JIRA 插件原型)

27: internal -> maven-archetype-har (Hibernate 存档)

28: internal -> maven-archetype-sar (JBoss 服务存档)

29: internal -> wicket-archetype-quickstart (一个简单的Apache Wicket的项目)

30: internal -> scala-archetype-simple (一个简单的scala的项目)

31: internal -> lift-archetype-blank (一个 blank/empty liftweb 项目)

32: internal -> lift-archetype-basic (基本（liftweb）项目)

33: internal -> cocoon-22-archetype-block-plain ([[http://cocoapacorg2/maven-plugins/](https://link.zhihu.com/?target=http%3A//cocoapacorg2/maven-plugins/)])

34: internal -> cocoon-22-archetype-block ([[http://cocoapacorg2/maven-plugins/](https://link.zhihu.com/?target=http%3A//cocoapacorg2/maven-plugins/)])

35: internal -> cocoon-22-archetype-webapp ([[http://cocoapacorg2/maven-plugins/](https://link.zhihu.com/?target=http%3A//cocoapacorg2/maven-plugins/)])

36: internal -> myfaces-archetype-helloworld (使用MyFaces的一个简单的原型)

37: internal -> myfaces-archetype-helloworld-facelets (一个使用MyFaces和Facelets的简单原型)

38: internal -> myfaces-archetype-trinidad (一个使用MyFaces和Trinidad的简单原型)

39: internal -> myfaces-archetype-jsfcomponents (一种使用MyFaces创建定制JSF组件的简单的原型)

40: internal -> gmaven-archetype-basic (Groovy的基本原型)

41: internal -> gmaven-archetype-mojo (Groovy mojo 原型)

## maven仓库类型

### 本地仓库

>  因为版权原因,中央仓库没有orcale驱动包

#### 1.配置本地仓库

配置本地仓库:让maven程序知道仓库在哪里

`${mvn_home}\conf\settings.xml`

 `<localRepository>E:\server\repository</localRepository>`

- 私服
- 中央仓库

### **总结**

本文以Maven工具，这种基于Java平台的自动化构建工具为引子，介绍了Maven标准下的Java项目基本结构，然后介绍了常见的三种Maven模板创建的目录结构，最后简要介绍了其它的四十一中常见的模板目录。

![](https://pic3.zhimg.com/80/v2-73af3e8d9370651bf48ed51c0e9d140e_720w.jpg)