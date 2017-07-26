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

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ic2c.service.UserService;

/**
 * <br>
 * IndexController <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月22日-下午7:23:04 <br>
 * @version 1.0.0
 * 
 */
@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}

	/**
	 * 用户登录 com.ic2c.web.user <br>
	 * 方法名：userLogin<br>
	 * 
	 * @author Allister.Liu(刘继鹏) <br>
	 *         Email：laujip@163.com <br>
	 *         时间：2017年7月22日-下午10:34:11 <br>
	 * @param username
	 * @param password
	 * @param session
	 * @return String<br>
	 *         <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
	 * @exception <br>
	 * @since 1.0.0 <br>
	 */
	@PostMapping("/userLogin")
	@ResponseBody
	public String userLogin(String username, String password, HttpSession session) {
		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
			boolean flag = userService.userLogin(username, password, session);
			if (flag) {
				return "success";
			}
			LOG.error("user login error...");
			return "error";// 用户名或者密码错误
		}
		return "empty";// 用户名或者密码为空
	}
	
	
	/**
	 * 用户退出，session注销
	 * com.ic2c.web.user <br>
	 * 方法名：logout<br>
	 * @author Allister.Liu(刘继鹏) <br>
	 * Email：laujip@163.com <br>
	 * 时间：2017年7月23日-下午5:20:03 <br>
	 * @param session
	 * @return String<br>
	 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
	 * @exception <br>
	 * @since  1.0.0 <br>
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		LOG.info("用户退出即将推出");
		return "admin/login";
	}
}
