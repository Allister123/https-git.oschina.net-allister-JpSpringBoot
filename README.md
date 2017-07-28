### ### springboot


本项目分别于MyBatis，Redis，Jsp，freemark，Cors等进行整合并开发一个简单的登录模块!

环境：
    1. JDK1.7<br />
    2. Mysql5.6<br />
    3. Springboot 1.5.4.RELEASE<br />
    4. Redis3.0.5<br />
    

<img src='https://git.oschina.net/uploads/images/2017/0728/142128_f4e119f4_1160547.png' title='ic2c.cc'/>

maven配置文件> pom.xml
```
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.4.RELEASE</version>
		<relativePath />
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.7</java.version>
		<dubbo-spring-boot>1.0.0</dubbo-spring-boot>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>1.0.0</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
        <dependency>   
	        <groupId>org.springframework.boot</groupId>  
	        <artifactId>spring-boot-starter-freemarker</artifactId>
	    </dependency>
	    <dependency>
	    	<groupId>org.springframework.boot</groupId>
 			<artifactId>spring-boot-starter-data-redis</artifactId>
	    </dependency>
	    <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.4</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```