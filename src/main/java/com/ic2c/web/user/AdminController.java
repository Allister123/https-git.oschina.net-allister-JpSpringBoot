/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.web.user <br>
 * AdminController.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午9:02:37 <br>
 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 * 2017 Allister-版权所有 <br>
 */
package com.ic2c.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   <br>
 * AdminController <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午9:02:37  <br>
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/index")
	public String index(){
		return "admin/index";
	}
	
}
