# maven-surefire-plugin总结

Maven通过[Maven Surefire Plugin](http://maven.apache.org/surefire/maven-surefire-plugin/)插件执行单元测试。（通过[Maven Failsafe Plugin](http://maven.apache.org/surefire/maven-failsafe-plugin/)插件执行集成测试） 

在pom.xml中配置JUnit,TestNG测试框架的依赖，即可自动识别和运行src/test目录下利用该框架编写的测试用例。surefire也能识别和执行符合一定命名约定的普通类中的测试方法（POJO测试）。

生命周期中test阶段默认绑定的插件目标就是surefire中的test目标，无需额外配置，直接运行mvn test就可以。

基本配置如下，下文中的配置项如无特殊说明，都位于pom文件的<configuration>节点中。

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.18.1</version>
    <configuration>
        ......　　　　　　配置内容　　　　　　......
    </configuration>
</plugin>
```

### *常用通用配置**

-  **跳过测试阶段**

```
<skipTests>true</skipTests>
```

或者 

```
mvn install -DskipTests
```

或者 （Compliler插件也会根据该参数跳过编译测试类） 

```
mvn install -Dmaven.test.skip=true
```

- **忽略测试失败** 

Maven在测试阶段出现失败的用例时，默认的行为是停止当前构建，构建过程也会以失败结束。有时候（如测试驱动开发模式）即使测试出现失败用例，仍然希望能继续构建项目。

```
<testFailureIgnore>true</testFailureIgnore> 
```

或者

```
mvn test -Dmaven.test.failure.ignore=true
```

- **包含和排除特定的测试类**

surefire默认的查找测试类的模式如下：

- - **/Test*.java
  - **/*Test.java
  - **/*TestCase.java

自定义包含和排除模式，支持ant-style表达式和 正则表达式（%regex[...], 按.class文件匹配而不是.java）

```xml
<includes>
    <include>Sample.java</include>
    <include>%regex[.*[Cat|Dog].*Test.*]</include>
</includes>
<excludes>
    <exclude>**/TestCircle.java</exclude>
    <exclude>**/TestSquare.java</exclude>
</excludes>
```

- **运行指定的用例**

指定测试类

```
　　mvn -Dtest=TestClassName test
　　mvn -Dtest=TestCi*le test
　　mvn -Dtest=TestSquare,TestCi*le test
```


指定单个测试类中的多个方法（Junit4+, TestNG）　

```
　　mvn -Dtest=TestCircle#mytest test
　　mvn -Dtest=TestCircle#test* test
　　mvn -Dtest=TestCircle#testOne+testTwo test   #(Surefire2.12.1+, Junit4.x+)
```

 

- **并发执行测试**

　　**（mvn命令加-T选项，多模块项目的各个模块可以并行构建。）**

 

　　两个方式：

　　**方法一是使用`parallel` 参数，在一个进程中执行多个线程。**
　　Junit4.7+可用值有：methods, classes, both(classesAndMethods), suites, suitesAndClasses, suitesAndMethods, classAndMethods, all。Junit Runner必须继承自orig.junit.runners.ParentRunner或为指定@org.junit.runner.RunWith。

　　线程数配置：`useUnlimitedThreads` 为true，不限制线程数。`useUnlimitedThreads` 为false时可以使用`threadCount和perCoreThreadCount参数。还可以通过threadCountSuites，threadCountClasses，threadCountMethods在不同粒度限制线程。parallelTestsTimeoutInSeconds和parallelTestsTimeoutForcedInSeconds参数设置线程的超时时间。Junit中@NotThreadSafe注解的内容会单线程执行，避免并发。`

　　**方法二是使用`forkCount`参数，创建多个测试进程。**

　　如果forkCount参数值后加C，表示乘以CPU核数（如forkCount=2.5C）。`reuseForks表示一个测试进程执行完了之后是杀掉还是重用来继续执行后续的测试。 默认配置为forkCount=1/reuseForks=true。进程的测试单元是class，逐个class的传递给测试进程。`

　　可以用`systemPropertyVariables` 传入系统参数（mvn test -D...或配置元素），也可以使用`argLine`传入JVM选项。argLine或者systemPropertyVariables配置里中也能用${surefire.forkNumber}占位符，代表每个进程自己的fork编号（1...n），用来向每个进程传入独立的资源配置（forkCount=0时，该占位符值为1）。

 

　　如果使用-T n同时执行多个mvn模块，每个模块都会有forkCount个进程，${surefire.forkNumber}的值为1..n*forkCount。

　　surefire2.14之前的版本使用forkMode进行配置，对应关系如下。　　

　　

| **Old Setting**                       | **New Setting**                                              |
| ------------------------------------- | ------------------------------------------------------------ |
| `forkMode=once` (default)             | `forkCount=1` (default), `reuseForks=true` (default)         |
| `forkMode=always`                     | `forkCount=1` (default), `reuseForks=false`                  |
| `forkMode=never`                      | `forkCount=0`                                                |
| `forkMode=perthread`, `threadCount=N` | `forkCount=N`, (`reuseForks=false`, if you did not had that one set) |

 

　　**多种并行方式组合**

　　只要forkCount不为0，就可以和-T组合。

　　forkCount=0, 或forkCount=1/reuseForks=true，可以和parallel自由组合。

　　forkCount的测试进程是按类为单位执行的，测试类整个整个的传到测试进程中执行。reuseForks=false或forkCount>1时，就会使用独立的测试进程，所以parallel=classes就失效了。但是还是可以组合parallel=methods/threadCount=n指定每个测试进程里的并发线程数。

　　这一部分的原文：http://maven.apache.org/surefire/maven-surefire-plugin/examples/fork-options-and-parallel-execution.html

 

 

其他不常用的配置列在最后。

 

### POJO测试

- 不使用测试框架，直接编写名称为**/*Test类，其中的test*方法也会被surefire执行。
- 类中定义的public void setUp()和public void tearDown()方法也会被surefire识别。
- 验证可使用JAVA assert关键字。
- 无法并发执行。

 

### **TestNG**

- TestNG默认查找执行test包下的*Test.java。Pom.xml中添加TestNG依赖就能执行testng测试。
- **指定SuiteXML文件**

```
   <suiteXmlFiles>
      <suiteXmlFile>testng.xml</suiteXmlFile>
   </suiteXmlFiles>
```

- **为TestNG @Parameters 注解提供参数**

```
 <systemPropertyVariables>
     <propertyName>firefox</propertyName>
 </systemPropertyVariables>
```

-  **指定group**

```
<groups>functest,perftest</groups>
```

-  **指定Listeners和Reporters**

TestNG支持在测试时附加自定义的listener, reporter, annotation transformer, method interceptor。默认会使用基本的listener生成HTML和XML报告。

Listener实现`org.testng.ITestListener接口,会`在测试开始、通过、失败等时刻实时发送通知。

Reporter实现`org.testng.IReporter接口，在整个测试运行完毕之后才会发送通知，参数为对象列表，包含整个测试的执行结果状况。`



```
 <properties>
      <property>
          <name>usedefaultlisteners</name>
          <value>false</value> <!-- disabling default listeners is optional -->
      </property>
      <property>
          <name>listener</name>
          <value>com.mycompany.MyResultListener,com.mycompany.MyAnnotationTransformer,com.mycompany.MyMethodInterceptor</value>
      </property>
      <property>
          <name>reporter</name>
          <value>listenReport.Reporter</value>
      </property>
</properties>
```



 

### JUnit

Pom.xml中添加JUnit依赖就能执行Junit测试。

根据引入的Junit依赖版本和是否配置了并发 自动确定使用JUnit 3.8.x, JUnit 4.x (serial provider) 还是 JUnit 4.7(junit-core provider with parallel support)，也可以在<plugin>节点里加入<dependencies>元素强行指定执行版本。（详细说明：http://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html）

 

- **指定Listener（JUnit4+）**



```
 <properties>
        <property>
          <name>listener</name>
          <value>com.mycompany.MyResultListener,com.mycompany.MyResultListener2</value>
        </property>
 </properties>
```



- **指定Categories（Junit4.8+）**。分组可以用在测试方法或测试类上。Junit使用接口和类的类型分组，选择注解为@Category(基类)的分组时，所有注解了@Category(子类)的分组也会被选中。

```
<groups>com.mycompany.SlowTests</groups>
```



```
  public interface SlowTests{}
  public interface SlowerTests extends SlowTests{}


  public class AppTest {
      @Test
      @Category(com.mycompany.SlowTests.class)
      public void testSlow() {
        System.out.println("slow");
      }

      @Test
      @Category(com.mycompany.SlowerTests.class)
      public void testSlower() {
        System.out.println("slower");
      }

      @Test
      @Category(com.cmycompany.FastTests.class)
      public void testSlow() {
        System.out.println("fast");
      }
    }
```



- **Security Manager**

```
<argLine>-Djava.security.manager -Djava.security.policy=${basedir}/src/test/resources/java.policy</argLine>
```

Junit3还可以如下配置（forkCount为0时）：

```
<systemPropertyVariables>
    <surefire.security.manager>java.lang.SecurityManager</surefire.security.manager>
</systemPropertyVariables>
```

 

 

### 其他不常用的通用配置

- **失败重跑**

```
mvn -Dsurefire.rerunFailingTestsCount=2 test   #（JUnit需要4.x版本）
```


重跑的log和报告等详细信息，看这里http://maven.apache.org/surefire/maven-surefire-plugin/examples/rerun-failing-tests.html

　　

- **指定VM参数**

```
<argLine>-Djava.endorsed.dirs=...</argLine>
```

- **系统属性**

```
<systemPropertyVariables>
     <propertyName>propertyValue</propertyName>
     <buildDirectory>${project.build.directory}</buildDirectory>
     [...]
</systemPropertyVariables>
```

不再推荐使用的方式



```
<systemProperties>
    <property>
      <name>buildDir</name>
      <value>String类型的值</value>
     </property>
</systemProperties>
```



继承父项目配置的系统属性

```
  <systemProperties combine.children="append">
      <property>
         [...]
      </property>
   </systemProperties>
```

 

- **配置Classpath**

test classpath包括： 

- - test-classes/
  - classes/
  - 项目依赖
  - 额外配置的classpath元素

 

要配置classpath，最好是使用添加依赖的方法。如果一定添加额外的ClassPath，这样配置：

```
          <additionalClasspathElements>
            <additionalClasspathElement>path/to/additional/resources</additionalClasspathElement>
            <additionalClasspathElement>path/to/additional/jar</additionalClasspathElement>
          </additionalClasspathElements>
```

移除依赖

```
          <classpathDependencyExcludes>
            <classpathDependencyExcludes>org.apache.commons:commons-email</classpathDependencyExcludes>
          </classpathDependencyExcludes>
```

按scope移除依赖

```
 <classpathDependencyScopeExclude>runtime</classpathDependencyScopeExclude>
```

- - compile - system, provided, compile
  - runtime - compile, runtime
  - test - system, provided, compile, runtime, test

 

- **调试**

默认情况下，surefire在新的进程中执行，命令mvn -Dmaven.surefire.debug test创建的测试进程会等待远程调试器（Eclipse）连接到5005端口。要配置不同的端口命令为：

```
mvn -Dmaven.surefire.debug="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000 -Xnoagent -Djava.compiler=NONE" test
```

 

如果`forkCount选项配置为0（`mvn -DforkCount=0 test`），不会创建新的测试进程，测试在maven主线程中执行。命令`mvnDebug -DforkCount=0 test会使maven以调试模式运行，可以将远程调试器连接到maven进程。

 

- **`选择测试框架Provider`**

```
可选的有surefire-junit3, surefire-junit4, surefire-junit47和 surefire-testng。指定Provider时，测试框架的依赖配置也不能少。
```

maven-surefire-plugin的<plugin>节点中添加如下配置。



```
<dependencies>
      <dependency>
        <groupId>org.apache.maven.surefire</groupId>
        <artifactId>surefire-junit47</artifactId>
        <version>2.18.1</version>
      </dependency>
</dependencies>
```



 

- **ClassLoader相关配置**

解决classpath长度超过命令行运行的最大参数长度问题。

方法有两个，各有优缺点：

一是使用独立的类加载器，在其中加载classpath内容。

二是使用一个只有META-INF/MANIFEST.MF的jar文件（如booter.jar），在manifest.mf文件中配置classpath。然后以 java -classpath booter.jar MyApp的方式运行。

 

配置方法

useSystemClassLoader为fasle， 使用独立的类加载器。

useSystemClassLoader为true并且useManifestOnlyJar为true时 ，使用manifest-only JAR

useSystemClassLoader为true并且useManifestOnlyJar为false时，使用最原始的java classpath

 

执行

```
mvn -Dsurefire.useSystemClassLoader=false test
```

或

```
<useSystemClassLoader>false</useSystemClassLoader>
<useManifestOnlyJar>false</useManifestOnlyJar>
```

 

这一部分具体信息可查看：http://maven.apache.org/surefire/maven-surefire-plugin/examples/class-loading.html