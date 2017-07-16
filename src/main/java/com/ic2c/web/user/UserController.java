/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.web.user <br>
 * UserController.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月15日-下午9:22:47 <br>
 * 2017Allister-版权所有 <br>
 */
package com.ic2c.web.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ic2c.bean.User;
import com.ic2c.dao.user.UserMapper;

/**
 *   <br>
 * UserController <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月15日-下午9:22:47  <br>
 * @version 1.0.0
 * 
 */
@RestController
public class UserController {
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 以post方式请求  查询用户集合
	 * com.ic2c.web.user <br>
	 * 方法名：findUserList<br>
	 * @author Allister.Liu(刘继鹏) <br>
	 * Email：laujip@163.com <br>
	 * 时间：2017年7月15日-下午10:02:09 <br>
	 * @param pageNo
	 * @param pageSize
	 * @return List<User><br>
	 * @exception <br>
	 * @since  1.0.0 <br>
	 */
	@RequestMapping(value = "/findUser/{pageNo}/{pageSize}")
	public List<User> findUserList(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
		List<User> users = userMapper.queryUserList(pageNo, pageSize);
		return users;
	}
	
	
	@PostMapping("/queryUsers")
	public List<User> findUserLists(@RequestParam("pageNo")int pageNo, @RequestParam("pageSize")int pageSize){
		List<User> users = userMapper.queryUserList(pageNo, pageSize);
		return users;
	}
}
