/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.web <br>
 * HelloMeController.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月16日-下午4:03:16 <br>
 * 2017Allister-版权所有 <br>
 */
package com.ic2c.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ic2c.bean.User;
import com.ic2c.dao.user.UserMapper;
import com.ic2c.util.redis.RedisDataUtil;

/**
 *   <br>
 * HelloMeController <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月16日-下午4:03:16  <br>
 * @version 1.0.0
 * 
 */

@Controller
public class HelloMeController {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private RedisDataUtil redisDataUtil;

	/*@RequestMapping("/hello")
	public String initHello(Map<String, Object> map){
		map.put("name", "Allister，你好吗？");
		return "hello";
	}*/
	
	@RequestMapping("/hello/user")
	public String users(@RequestParam("pageNo")int pageNo, @RequestParam("pageSize")int pageSize, Map<String, Object> map){
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) redisDataUtil.get("users");
		if(null == users){
			users = userMapper.queryUserList(pageNo, pageSize);
			redisDataUtil.set("users", users, 60L);
		}
		map.put("users", users);
		return "hello";
	}
}
