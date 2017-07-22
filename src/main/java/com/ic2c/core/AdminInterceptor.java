/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.core <br>
 * AdminInterceptor.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午7:53:43 <br>
 * <a href="https://ic2c.cc">https://ic2c.cc</a> <br>
 * 2017 Allister-版权所有 <br>
 */
package com.ic2c.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *   <br>
 * AdminInterceptor <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月22日-下午7:53:43  <br>
 * @version 1.0.0
 * 
 */
public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String user = (String) request.getSession().getAttribute("userInfo");
		if(null != user){
			return true;
		}else{
			response.sendRedirect(request.getContextPath() + "/login");
		}
		return false;
	}

}
