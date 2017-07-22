/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.web.user <br>
 * IndexController.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午7:23:04 <br>
 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 * 2017 Allister-版权所有 <br>
 */
package com.ic2c.web.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *   <br>
 * IndexController <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午7:23:04  <br>
 * @version 1.0.0
 * 
 */
@Controller
public class IndexController {
	
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "123456";

	@RequestMapping("/login")
	public String login(){
		return "admin/login";
	}
	
	
	
	@PostMapping("/userLogin")
	@ResponseBody
	public String userLogin(String username, String password, HttpSession session){
		if(USERNAME.equals(username) && PASSWORD.equals(password)){
			session.setAttribute("userInfo", username);
			LOG.info("==========> user login success!!!" + username);
			return "success";
		}
		return "error";
	}
}
