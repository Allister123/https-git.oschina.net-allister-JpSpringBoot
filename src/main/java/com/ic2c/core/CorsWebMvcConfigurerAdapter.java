/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.core <br>
 * AdminWebMvcConfigurerAdapter.java <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月22日-下午8:49:01 <br>
 *         <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 *         2017 Allister-版权所有 <br>
 */
package com.ic2c.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 跨域CORS<br>
 * AdminWebMvcConfigurerAdapter <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月22日-下午8:49:01 <br>
 * @version 1.0.0
 *          
 */
@Configuration // 标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
public class CorsWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://10.10.6.200:8087");
	}
}
