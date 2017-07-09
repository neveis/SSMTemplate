## SSM框架模板

### 1 基本概念

Spring + SpringMVC + MyBatis

Maven

### 2 新建项目

新建Dynamic Web Project

![新建Dynamic Web Project](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/1.jpg)

设置项目名称，注意选择Target runtime

![设置runtime](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/2.jpg)

下一步，设置目录为Maven标准目录结构，设置输出路径

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/2-1.jpg)

下一步，注意选择生成 web.xml

![生成web.xml](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/3.jpg)

在项目上右键，选择 Configure - Convert to Maven Project,转换为Maven项目。（也可以不转换，但需要自己下载好所需的JAR包）

![转换为Maven项目](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/4.jpg)

空项目结构如下图

![空项目结构](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/5.jpg)

### 3 Maven设置

以下是一些基本包，按需添加到pom.xml `<project>`标签中。
```
    <properties>  
        <!-- spring版本号 -->  
        <spring.version>4.0.2.RELEASE</spring.version>  
        <!-- mybatis版本号 -->  
        <mybatis.version>3.2.6</mybatis.version>  
        <!-- log4j日志文件管理包版本 -->  
        <slf4j.version>1.7.7</slf4j.version>  
        <log4j.version>1.2.17</log4j.version>  
    </properties>  
  
    <dependencies>  
        <dependency>  
            <groupId>junit</groupId>  
            <artifactId>junit</artifactId>  
            <version>4.11</version>  
            <!-- 表示开发的时候引入，发布的时候不会加载此包 -->  
            <scope>test</scope>  
        </dependency>  
        <!-- spring核心包 -->  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-core</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-web</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-oxm</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-tx</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-jdbc</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-webmvc</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-aop</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-context-support</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-test</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <!-- mybatis核心包 -->  
        <dependency>  
            <groupId>org.mybatis</groupId>  
            <artifactId>mybatis</artifactId>  
            <version>${mybatis.version}</version>  
        </dependency>  
        <!-- mybatis/spring包 -->  
        <dependency>  
            <groupId>org.mybatis</groupId>  
            <artifactId>mybatis-spring</artifactId>  
            <version>1.2.2</version>  
        </dependency>  
        <!-- 导入java ee jar 包 -->  
        <dependency>  
            <groupId>javax</groupId>  
            <artifactId>javaee-api</artifactId>  
            <version>7.0</version>  
        </dependency>  
        <!-- 导入Mysql数据库链接jar包 -->  
        <dependency>  
            <groupId>mysql</groupId>  
            <artifactId>mysql-connector-java</artifactId>  
            <version>5.1.30</version>  
        </dependency>  
        <!-- 导入dbcp的jar包，用来在applicationContext.xml中配置数据库 -->  
        <dependency>  
            <groupId>commons-dbcp</groupId>  
            <artifactId>commons-dbcp</artifactId>  
            <version>1.2.2</version>  
        </dependency>  
        <!-- JSTL标签类 -->  
        <dependency>  
            <groupId>jstl</groupId>  
            <artifactId>jstl</artifactId>  
            <version>1.2</version>  
        </dependency>  
        <!-- 日志文件管理包 -->  
        <!-- log start -->  
        <dependency>  
            <groupId>log4j</groupId>  
            <artifactId>log4j</artifactId>  
            <version>${log4j.version}</version>  
        </dependency>  
          
          
        <!-- 格式化对象，方便输出日志 -->  
        <dependency>  
            <groupId>com.alibaba</groupId>  
            <artifactId>fastjson</artifactId>  
            <version>1.1.41</version>  
        </dependency>  
  
  
        <dependency>  
            <groupId>org.slf4j</groupId>  
            <artifactId>slf4j-api</artifactId>  
            <version>${slf4j.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.slf4j</groupId>  
            <artifactId>slf4j-log4j12</artifactId>  
            <version>${slf4j.version}</version>  
        </dependency>  
        <!-- log end -->  
        <!-- 映入JSON -->  
        <dependency>  
            <groupId>org.codehaus.jackson</groupId>  
            <artifactId>jackson-mapper-asl</artifactId>  
            <version>1.9.13</version>  
        </dependency>  
        <!-- 上传组件包 -->  
        <dependency>  
            <groupId>commons-fileupload</groupId>  
            <artifactId>commons-fileupload</artifactId>  
            <version>1.3.1</version>  
        </dependency>  
        <dependency>  
            <groupId>commons-io</groupId>  
            <artifactId>commons-io</artifactId>  
            <version>2.4</version>  
        </dependency>  
        <dependency>  
            <groupId>commons-codec</groupId>  
            <artifactId>commons-codec</artifactId>  
            <version>1.9</version>  
        </dependency>  
    </dependencies>  
```

### 4 MyBatis整合

#### 4.1 建立JDBC属性文件

在 src/main/resources 下新建文件`jdbc.properties`(UTF-8编码)。

注意按实际修改。

```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/ssm
username=root
password=root
#定义初始连接数
initialSize=0
#定义最大连接数
maxActive=20
#定义最大空闲
maxIdle=20
#定义最小空闲
minIdle=1
#定义最长等待时间
maxWait=60000
```

#### 4.2 建立配置文件

在 src/main/resources 下新建文件`spring-mybatis.xml`。这个文件用来完成spring和mybatis的整合,主要是自动扫描、自动注入和配置数据库。

注意自动扫描的包名改为实际的包名。

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd
                        http://www.springframework.org/schema/tx
                        http://www.springframework.org/schema/tx/spring-tx-4.0.xsd">

    <!-- 自动扫描 -->
    <context:component-scan base-package="com.ssmtemplate" />

    <!-- 引入配置文件 -->
    <bean id="propertyConfigurer"
        class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location" value="classpath:jdbc.properties" />
    </bean>  
  
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
        destroy-method="close">
        <property name="driverClassName" value="${driver}" />
        <property name="url" value="${url}" />
        <property name="username" value="${username}" />
        <property name="password" value="${password}" />
        <!-- 初始化连接大小 -->
        <property name="initialSize" value="${initialSize}"></property>
        <!-- 连接池最大数量 -->
        <property name="maxActive" value="${maxActive}"></property>
        <!-- 连接池最大空闲 -->
        <property name="maxIdle" value="${maxIdle}"></property>
        <!-- 连接池最小空闲 -->
        <property name="minIdle" value="${minIdle}"></property>
        <!-- 获取连接最大等待时间 -->
        <property name="maxWait" value="${maxWait}"></property>
    </bean>
  
    <!-- spring和MyBatis完美整合，不需要mybatis的配置映射文件 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!-- 自动扫描mapping.xml文件 -->
        <!--
        <property name="mapperLocations" value="classpath:com/ssmtemplate/mapping/*.xml"></property>
        -->
        <property name="configLocation" value="classpath:mybatis-config.xml" />
    </bean>
  
    <!-- DAO接口所在包名，Spring会自动查找其下的类 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.ssmtemplate.mapper" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>
  
    <!-- (事务管理)transaction manager, use JtaTransactionManager for global tx -->
    <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
  
  <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>  
```

再新建配置文件`mybatis-config.xml`。注意alias和mapper的设置。
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<typeAliases>
		<typeAlias type="com.ssmtemplate.model.User" alias="User"></typeAlias>
	</typeAliases>
	
	<mappers>
		<package name="com/ssmtemplate/mapper"/>
	</mappers>
	
</configuration>
```

### 4.3 配置日志

在src下新建文件`log4j.properties`。这里配置只会在控制台输出，需要输出到文件请查找相关资料。

```
# Global logging configuration
log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```

### 4.3 JUnit测试
### 4.3.1 创建测试表

```
DROP TABLE IF EXISTS `user_t`;
  
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
  
/*Data for the table `user_t` */

insert  into `user_t`(`id`,`username`,`password`,`age`) values (1,'test','123456',18);
```

### 4.3.2 创建接口和映射文件

如图

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/6.jpg)

新建包`com.ssmtemplate.model`，在包中新建类`User.java`。

新建包`com.ssmtemplate.mapper`,在包中新建接口`UserMapper.java`和映射文件`UserMapper.xml`。

各文件内容如下：

`User.java`
```
package com.ssmtemplate.model;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
```

`UserMapper.java`
```
package com.ssmtemplate.mapper;

import com.ssmtemplate.model.User;

public interface UserMapper {
	public User getUserById(int id);
}
```

`UserMapper.xml`
```
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.ssmtemplate.mapper.UserMapper">
	<!-- 自定义结果集 -->
	<resultMap type="User" id="userResultMap">
		<id property="id" column="id" />
		<result property="username" column="username"/>
		<result property="password" column="password"/>
		<result property="age" column="age"/>
	</resultMap>
	
	<select id="getUserById" parameterType="int" resultMap="userResultMap">
		select * from user_t where id=#{id}
	</select>
</mapper>
```

### 4.3.3 创建Service接口和实现类

如图

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/7.jpg)

新建包`com.ssmtemplate.service`，在包中新建接口`UserService.java`。

新建包`com.ssmtemplate.service.impl`，在包中新建类`UserServiceImpl.java`。

各文件内容如下：

`UserService.java`
```
package com.ssmtemplate.service;

import com.ssmtemplate.model.User;

public interface UserService {
	public User getUserById(int id);
}
```

`UserServiceImpl.java`
```
package com.ssmtemplate.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  

import com.ssmtemplate.mapper.UserMapper;
import com.ssmtemplate.model.User;
import com.ssmtemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}
}
```

### 4.3.4 建立测试类

在 src/test/java 下新建包`com.ssmtemplate.test`，新建类`SpringMyBatisTest.java`。

`SpringMyBatisTest.java`
```
package com.ssmtemplate.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import com.ssmtemplate.model.User;
import com.ssmtemplate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class SpringMyBatisTest {

	@Resource
	private UserService userService;
	
	@Test
	public void testGetUser(){
		User user = userService.getUserById(1);
		System.out.println(JSON.toJSONString(user));
	}
}
```

运行JUnit Test

![Junit Test](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/8.jpg)

在Console可以看到运行结果

![测试结果](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/9.jpg)

至此，完成Spring和MyBatis的整合，目录结构如下

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/10.jpg)

### 5 SpringMVC整合

#### 5.1 配置spring-mvc.xml

在 src/main/resources 下新建`spring-mvc.xml`。用于自动扫描控制器，设置视图模式，注解的启动。

注意更改自动扫描的包名。

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd
                        http://www.springframework.org/schema/mvc
                        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">

    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
    <context:component-scan base-package="com.ssmtemplate.controller" />

    <!--
    <!-- 默认配置方案 -->
    <mvc:annotation-driven></mvc:annotation-driven>
    -->

    <!--避免IE执行AJAX时，返回JSON出现下载文件 -->
    <bean id="mappingJacksonHttpMessageConverter"
        class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/html;charset=UTF-8</value>
            </list>
        </property>
    </bean>

    <!-- 启动SpringMVC的注解功能，完成请求和注解POJO的映射 -->  
    <bean
        class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="messageConverters">
            <list>
                <ref bean="mappingJacksonHttpMessageConverter" /> <!-- JSON转换器 -->
            </list>
        </property>
    </bean>

    <!-- 定义跳转的文件的前后缀 ，视图模式配置-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 这里的配置我的理解是自动给后面action的方法return的字符串加上前缀和后缀，变成一个 可用的url地址 -->
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
    
    <!--
    <!-- 配置文件上传，如果没有使用文件上传可以不用配置，当然如果不配，那么配置文件中也不必引入上传组件包 -->
    <bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!-- 默认编码 -->
        <property name="defaultEncoding" value="utf-8" />
        <!-- 文件大小最大值 -->
        <property name="maxUploadSize" value="10485760000" />
        <!-- 内存中的最大值 -->
        <property name="maxInMemorySize" value="40960" />
    </bean>
    -->
</beans>
```

#### 5.2 配置web.xml

`web.xml`在 WebContent/WEB-INF/ 目录下，文件内容如下。

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://java.sun.com/xml/ns/javaee"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    version="3.0">

    <display-name>Archetype Created Web Application</display-name>

    <!-- Spring和mybatis的配置文件 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mybatis.xml</param-value>
    </context-param>

    <!-- 编码过滤器 -->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <async-supported>true</async-supported>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- Spring监听器 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!-- 防止Spring内存溢出监听器 -->
    <listener>
        <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
    </listener>

    <!-- Spring MVC servlet -->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <!-- 此处可以可以配置成*.do，对应struts的后缀习惯 -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>/index.jsp</welcome-file>
    </welcome-file-list>

</web-app>
```

#### 5.3 新建jsp页面

在 WebContent/WEB-INF/jsp/ 下新建文件`showUser.jsp`。

showUser.jsp
```
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>测试</title>  
  </head>

  <body>
    ${user.username}  
  </body>
</html>
```

#### 5.4 建立控制类

在 src/main/java 下新建包`com.ssmtemplate.controller`，新建类`UserController.java`。

UserController.java

```
package com.ssmtemplate.controller;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  

import com.ssmtemplate.model.User;
import com.ssmtemplate.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {
	@Resource  
    private UserService userService;  
      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
}
```

#### 5.5 部署项目

在项目上右键选择 Run on Server。

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/11.jpg)

启动成功后，在浏览器输入`http://localhost:8080/SSMTemplate/user/showUser?id=1`。

![](http://oiounq5oq.bkt.clouddn.com/ssmtemplate/12.jpg)

如果成功可以看到上面的页面。test就是之前数据中添加的用户的username。

至此，SSM框架整合完成。

### 6 参考

[SSM框架——详细整合教程（Spring+SpringMVC+MyBatis）](http://blog.csdn.net/zhshulin/article/details/37956105)