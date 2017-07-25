/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.dao.user <br>
 * UserMapper.java <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月15日-下午9:11:50 <br>
 *         2017Allister-版权所有 <br>
 */
package com.ic2c.dao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ic2c.bean.User;


/**
 * <br>
 * UserMapper <br>
 * 
 * @author Allister.Liu(刘继鹏) <br>
 *         Email：laujip@163.com <br>
 *         时间：2017年7月15日-下午9:11:50 <br>
 * @version 1.0.0
 *          
 */
@Repository
public interface UserMapper {
	/**
	 * 查询用户集合并且分页 com.ic2c.dao.user <br>
	 * 方法名：queryUserList<br>
	 * 
	 * @author Allister.Liu(刘继鹏) <br>
	 *         Email：laujip@163.com <br>
	 *         时间：2017年7月15日-下午9:59:55 <br>
	 * @param pageNo
	 * @param pageSize
	 * @return List<User><br>
	 * @exception <br>
	 * @since 1.0.0 <br>
	 */
	List<User> queryUserList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	
	
	/**
	 * 根据邮箱和密码查询用户信息 - 用户登录 com.ic2c.dao.user <br>
	 * 方法名：queryUserByEmailAndPassword<br>
	 * 
	 * @author Allister.Liu(刘继鹏) <br>
	 *         Email：laujip@163.com <br>
	 *         时间：2017年7月22日-下午10:01:22 <br>
	 * @param email
	 * @param password
	 * @return User<br>
	 *         <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
	 * @exception <br>
	 * @since 1.0.0 <br>
	 */
	User queryUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
