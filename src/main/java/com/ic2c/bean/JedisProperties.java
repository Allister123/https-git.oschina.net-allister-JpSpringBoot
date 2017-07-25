/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.bean <br>
 * JedisProperties.java <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月16日-下午7:04:17 <br>
 *         2017Allister-版权所有 <br>
 */
package com.ic2c.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * redis<br>
 * JedisProperties <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月16日-下午7:04:17 <br>
 * @version 1.0.0
 *          
 */
@ConfigurationProperties(prefix = JedisProperties.JEDIS_PREFIX)
public class JedisProperties {
	public static final String JEDIS_PREFIX = "jedis";
	private String host;
	private int port;
	private String password;
	private int maxTotal;
	private int maxIdle;
	private int maxWaitMillis;
	
	
	
	public String getHost() {
		return host;
	}
	
	
	
	public void setHost(String host) {
		this.host = host;
	}
	
	
	
	public int getPort() {
		return port;
	}
	
	
	
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public int getMaxTotal() {
		return maxTotal;
	}
	
	
	
	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}
	
	
	
	public int getMaxIdle() {
		return maxIdle;
	}
	
	
	
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	
	
	
	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}
	
	
	
	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}
	
	
	
	public static String getJedisPrefix() {
		return JEDIS_PREFIX;
	}
}
