/**
 * 易码当先 <br>
 * JpSpringBoot <br>
 * com.ic2c.service <br>
 * UserService.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午10:12:39 <br>
 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 * 2017 Allister-版权所有 <br>
 */
package com.ic2c.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ic2c.bean.User;
import com.ic2c.dao.user.UserMapper;

/**
 *   <br>
 * UserService <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午10:12:39  <br>
 * @version 1.0.0
 * 
 */
@Service
public class UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Resource
	private UserMapper userMapper;

	public List<User> queryUserList(int pageNo, int pageSize) {
		return userMapper.queryUserList(pageNo, pageSize);
	}

	public User queryUserByEmailAndPassword(String email, String password) {
		return userMapper.queryUserByEmailAndPassword(email, password);
	}

	public boolean userLogin(String email, String password, HttpSession session) {
		User user = userMapper.queryUserByEmailAndPassword(email, password);
		if (null != user) {
			//校验用户名和密码
			if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {//测试密码加密就省略了
				//为了安全，登录成功后将面膜制空再放入session中
				user.setPassword("");
				session.setAttribute("userInfo", user);
				LOG.info("user login success!!! username: 【" + user.getUsername() + "】");
				return true;
			}
		}
		return false;
	}
}
