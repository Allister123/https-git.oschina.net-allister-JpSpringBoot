/**
 * 易码当先 <br>
 * JpSpringBoot01 <br>
 * com.ic2c.web <br>
 * HelloController.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月15日-下午3:36:35 <br>
 * 2017Allister-版权所有 <br>
 */
package com.ic2c.web;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ic2c.bean.User;
import com.ic2c.service.UserService;

/**
 *   <br>
 * HelloController <br>
 * @author Allister.Liu(刘继鹏) <br>
 * 时间：2017年7月15日-下午3:36:35  <br>
 * @version 1.0.0
 * 
 */
@RestController
public class HelloController {
	
	@Resource
	private UserService userService;
	
	//获取application.yml配置文件中的值
	@Value("${user.username}")
	private String username;
	
	@Value("${user.age}")
	private Integer age;
	
	@RequestMapping("/index")
	public String initIndex(){
		return "大家好，我叫 " + username + "， 今年+ " + age + "岁！！！";
	}
	
	
	@RequestMapping("/init/corsIdex")
	public List<User> corsGetUsers(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
		System.out.println("进来了。。。=================");
		List<User> users = userService.queryUserList(pageNo, pageSize);
		return users;
	}
	
	
	@RequestMapping("/init/corsGetindex")
	public String corsGetindex(){
		System.out.println("进来了。。。");
		return "success";
	}
	
}
