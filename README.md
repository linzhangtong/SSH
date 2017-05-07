<strong>1.开发环境</strong>：
IntelliJ IDEA: 2016
Maven :3.0x
Java 8
2.pom.xml
```javascript
   <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- ********************** Java Servlet API 4.0.0-b01 ********************** -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.0-b01</version>
        </dependency>

        <!-- ********************** JUnit 4.12 ********************** -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

        <!-- ********************** Fastjson 1.2.7 ********************** -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.7</version>
        </dependency>

        <!-- ********************** AspectJ Weaver 1.8.7 ********************** -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.7</version>
        </dependency>

        <!-- ********************** Apache Log4j 1.2.17 ********************** -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!-- ********************** Struts 2.3.24.1 ********************** -->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>2.3.24.1</version>
            <exclusions>
                <exclusion>
                    <groupId>javassist</groupId>
                    <artifactId>javassist</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-spring-plugin</artifactId>
            <version>2.3.24.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-convention-plugin</artifactId>
            <version>2.3.24.1</version>
        </dependency>

        <!-- ********************** Java Transaction API 1.1 ********************** -->
        <dependency>
            <groupId>javax.transaction</groupId>
            <artifactId>jta</artifactId>
            <version>1.1</version>
        </dependency>

        <!-- ********************** MySQL 5.1.38 ********************** -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>

        <!-- ********************** Druid 1.0.16 ********************** -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.16</version>
        </dependency>

        <!-- ********************** Hibernate 5.0.6.Final ********************** -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.0.6.Final</version>
        </dependency>

        <!-- ********************** Spring 4.2.4.RELEASE ********************** -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>

    </dependencies>
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>1.6</source>
                    <target>1.6</target>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
不用去找jar包真的美滋滋。
3.web.xml
```javascript
 <!-- 配置Spring框架核心的监听器 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <!-- 该路径以webRoot作为根路径 -->
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <!-- Struts2核心过滤器配置 -->
    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
配置Spring监听器和Strut2过滤器
3.编写Spring配置文件（applicationContext.xml）
```javascript
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd
http://www.springframework.org/schema/aop
http://www.springframework.org/schema/aop/spring-aop.xsd
http://www.springframework.org/schema/tx
http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--Action交给Spring来管理-->
    <bean id="productAction" class="com.koali.action.ProductAction" scope="prototype">
        <property name="productService" ref="productService"/>
    </bean>
    <!--配置Service层的类-->
    <bean id="productService" class="com.koali.service.ProductService">
        <property name="productDao" ref="productDao"/>
    </bean>
    <!--配置Dao层的类-->
    <bean id="productDao" class="com.koali.dao.ProductDao">
    </bean>
</beans>
```
4.编写Strut2的配置文件（strut.xml）
```javascript
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
        "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>
    <package name="ssh" extends="struts-default" namespace="/">
        <action name="product_*" class="com.koali.action.ProductAction" method="{1}">
        </action>
    </package>
</struts>
```
5.最后编写简单的代码看看是否搭建成功

![简单的测试项目图.png](http://upload-images.jianshu.io/upload_images/3435345-cb686360b746d0fd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
6.测试效果：

![ssh2.gif](http://upload-images.jianshu.io/upload_images/3435345-cccace12173a2e37.gif?imageMogr2/auto-orient/strip)
成功提交后，经过了action，service，dao，后台成功输出。
