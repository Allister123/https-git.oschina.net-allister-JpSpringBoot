/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.core <br>
 * AdminWebMvcConfigurerAdapter.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午8:49:01 <br>
 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 * 2017 Allister-版权所有 <br>
 */
package com.ic2c.core;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *   https：将80端口自动转发至443<br>
 * AdminWebMvcConfigurerAdapter <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午8:49:01  <br>
 * @version 1.0.0
 * 
 */
@Configuration //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
public class PublicWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
	
	@Value("${server.port}")
    private Integer webPort;

	/**
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有带有admin的
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
	}

	
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
}
