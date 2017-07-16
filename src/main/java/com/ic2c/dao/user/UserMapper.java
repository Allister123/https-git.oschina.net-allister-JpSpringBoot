/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.dao.user <br>
 * UserMapper.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月15日-下午9:11:50 <br>
 * 2017Allister-版权所有 <br>
 */
package com.ic2c.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ic2c.bean.User;

/**
 *   <br>
 * UserMapper <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月15日-下午9:11:50  <br>
 * @version 1.0.0
 * 
 */
@Component
public interface UserMapper {
	/**
	 * 查询用户集合并且分页
	 * com.ic2c.dao.user <br>
	 * 方法名：queryUserList<br>
	 * @author Allister.Liu(刘继鹏) <br>
	 * Email：laujip@163.com <br>
	 * 时间：2017年7月15日-下午9:59:55 <br>
	 * @param pageNo
	 * @param pageSize
	 * @return List<User><br>
	 * @exception <br>
	 * @since  1.0.0 <br>
	 */
	List<User> queryUserList(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
}
