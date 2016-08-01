package com.plus.want.controller.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plus.want.entity.user.User;
import com.plus.want.model.ResultTemplet;
import com.plus.want.service.UserService;
import com.plus.want.util.CommonUtil;

/**
 * @author a1528zhang
 *
 */
@Controller
@RequestMapping(value = "/action/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * @author 张黎
	 * @date 2016年4月19日上午10:49:00
	 * @param 
	 * @description 用户账号注册,username是邮箱，唯一不可变
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST ,value = "/register")
	@ResponseBody
	public String userRegister(@RequestParam String username,
			@RequestParam String password) {
		ResultTemplet<Object> result= userService.userRegister(username, password);
		return CommonUtil.GsonSerialize(result);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value = "/login")
	@ResponseBody
	public String userLogin(@RequestParam String username,
							@RequestParam String password,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result= userService.userLogin(username, password,request,response);
		return CommonUtil.GsonSerialize(result);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value = "/logout")
	@ResponseBody
	public String userLogout(HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result= userService.userLogout(request,response);
		return CommonUtil.GsonSerialize(result);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value = "/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result= userService.updateUserInfo(user, request, response);
		return CommonUtil.GsonSerialize(result);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value = "/getUserPersonalInfo")
	@ResponseBody
	public String getUserInfo(Integer userId,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = userService.getUserPersonalInfo(userId);
		String jsonp=request.getParameter("jsonpcallback");  
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	/**
	 * @author 张黎
	 * @date 2016年6月16日下午4:27:36
	 * @param 
	 * @description 后台获取用户列表
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET ,value = "/userList")
	@ResponseBody
	public String userList(
			Integer limit,Integer offset,
			HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result= userService.getUserList(limit, offset);
//		String jsonp=request.getParameter("jsonpcallback"); 
		return CommonUtil.GsonSerialize(result);
//		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	@RequestMapping(method=RequestMethod.POST ,value = "/userBan")
	@ResponseBody
	public String userBan(
			Integer[] userId,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.getId();
		ResultTemplet<Object> result= userService.userBan(userId);
//		String jsonp=request.getParameter("jsonpcallback"); 
		return CommonUtil.GsonSerialize(result);
//		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	@RequestMapping(method=RequestMethod.GET ,value = "/test")
	@ResponseBody
	public ModelAndView test(String userName,
							String userPassword){
		ModelAndView mav = new ModelAndView("details_div"); 
		mav.addObject("userName", userName); 
		mav.addObject("userPassword", userPassword); 
		return mav;
	}
}
