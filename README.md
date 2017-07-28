### ### springboot

[易码当先：](https://ic2c.cc)

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


### HTTPS配置：
    如果想启用ssl，那么就将> application.yml中的注释去掉，如下图：
<img src='https://git.oschina.net/uploads/images/2017/0728/150518_b32f989c_1160547.png' title='ic2c.cc'/>

    再将> PublicWebMvcConfigurerAdapter.java中相应注释去掉即可，因为证书是自己生成的，所以浏览器默认会拦截，允许就可以了。
```
//======================================配置将443转向80 start===============================================
	/**
     * 构建servlet容器的工厂类
     * 将80端口跳转到{@linkplain #webPort}端口
     *
     * @return 内置servlet容器类的工厂实例
     *//*
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {

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
        factory.addAdditionalTomcatConnectors(createConnector());
        return factory;
    }

    *//**
     * 创建tomcat连接器。
     * 该连接器将会接收http的80端口的访问，并且重定向到指定的端口上去，{@linkplain #webPort}
     *
     * @return tomcat连接器
     *//*
    private Connector createConnector() {
        final Connector connector = new Connector();

        connector.setPort(80);
        connector.setRedirectPort(webPort);
        return connector;
    }*/
	
	//======================================配置将443转向80 end===============================================
```

### CORS跨域资源共享
1. 修改> CorsWebMvcConfigurerAdapter.java
<img src='https://git.oschina.net/uploads/images/2017/0728/151404_c7f43004_1160547.png' title='ic2c.cc'/>

2. 将login中的index.html文件的basePath修改为自己服务端的地址


不要忘记数据库哦!