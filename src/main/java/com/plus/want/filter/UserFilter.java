package com.plus.want.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter extends HttpServlet implements Filter  {
	  
	public void destroy() {   
		System.out.println("filter执行destroy");
		return;     
		}     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("getFilter");
		 HttpServletRequest request=(HttpServletRequest)arg0;     
         HttpServletResponse response  =(HttpServletResponse) arg1;
//         String username = (String) request.getParameter("username");
//         if (username == null || username.equals("")) {
//        	 System.out.println("username为空");
//        	 return ;
//		}else {
//			System.out.println("username有值："+username);
//		}
//         String userPassword = (String) request.getParameter("userPassword");
//         if (userPassword == null || userPassword.equals("")) {
//        	 System.out.println("userPassword为空");
//        	 return ;
//		}else {
//			System.out.println("userPassword有值："+userPassword);
//		}
//         String url=request.getRequestURI();
//         System.out.println("请求url的值："+url);
//         System.out.println("请求头内容："+request.getHeader("user-agent"));
         //继续转发到controller
         chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
