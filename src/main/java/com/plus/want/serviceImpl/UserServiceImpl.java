package com.plus.want.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.want.service.UserService;
import com.plus.want.util.CommonUtil;
import com.plus.want.dao.UserDAO;
import com.plus.want.entity.user.User;
import com.plus.want.model.ResultTemplet;;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	public ResultTemplet<Object> userRegister(String username,String userPassword){
		//只能使用邮箱注册
		if(CommonUtil.isEmail(username)){
			User user = userDAO.selectByUsername(username);
			if (user != null) {
				return CommonUtil.assembleResult(0,1003,""); 
			}else{
				Map<String, Object> registerObj = new HashMap<String, Object>();
				registerObj.put("userEmail", username);
				registerObj.put("userPassword", userPassword);
				Integer userId = userDAO.emailRegister(registerObj);
				user = userDAO.selectByUserId(userId);
				return CommonUtil.assembleResult(1, 2000, user);
			}
		}else{
			return CommonUtil.assembleResult(0,1001,"");
		}
	}
	
	public ResultTemplet<Object> userLogin(String username,String userPassword
			,HttpServletRequest request,HttpServletResponse response){
		String loginName = "";
		//shiro验证
		if(CommonUtil.isEmail(username)){
			loginName = username;
		}else if(CommonUtil.isMobileNO(username)){
			User u = userDAO.selectByUserPhone(username);
			if (u != null) {
				loginName = u.getUsername();
			}else {
				return CommonUtil.assembleResult(0,1007,"");
			}
		}else{
			return CommonUtil.assembleResult(0,1001,"");
		}
		Subject subject=SecurityUtils.getSubject();
		//必须是邮箱进行登录验证
		UsernamePasswordToken token=new UsernamePasswordToken(loginName, userPassword);
		User user = new User();
		try {
			token.setRememberMe(true);
			//登录成功后，自动获取权限
			subject.login(token);
			user = userDAO.selectByUsername((String)subject.getPrincipal());
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			return CommonUtil.assembleResult(0,1006,"");
		}catch (UnknownAccountException e) {
			return CommonUtil.assembleResult(0,1005,"");
		}
		return CommonUtil.assembleResult(1,2000,user);
	}
	
	public ResultTemplet<Object> userLogout(HttpServletRequest request,HttpServletResponse response){
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
		return CommonUtil.assembleResult(1, 2000, "");
	}
	
	public ResultTemplet<Object> updateUserInfo(User param,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session != null){
			User user = (User)session.getAttribute("user");
			param.setUserId(user.getUserId());
			userDAO.updateUserInfo(param);
			return CommonUtil.assembleResult(1, 2000, "");
		}else{
			return CommonUtil.assembleResult(0, 1004, "");
		}
	};
	
	public User selectUserByCondition(Integer userId,String userName,String userPassword){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", userId);
		condition.put("userName", userName);
		condition.put("userPassword", userPassword);
		User user = userDAO.selectUserByCondition(condition);
		return user;
	}
	
	public ResultTemplet<Object> getUserPersonalInfo(Integer userId){
		User user = userDAO.getUserPersonalInfo(userId);
		return CommonUtil.assembleResult(1, 2000, user);
	}
	
	public ResultTemplet<Object> getUserList(Integer limit,Integer offset){
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("limit", limit);
		condition.put("offset", offset);
		Integer count = userDAO.getUserCount();
		List<User> users = userDAO.getUserList(condition);
		result.put("total", count);
		result.put("rows", users);
		return CommonUtil.assembleResult(1, 2000, result);
	}
	public ResultTemplet<Object> userBan(Integer[] userId) {
		System.out.println(userId);
		return CommonUtil.assembleResult(1, 2000, "ok");
	}
	
	/**
	 * shiro 需要的方法
	 */
	public User getByUserName(String username){
		try {
			User user = userDAO.selectByUsername(username);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getbyusername出错");
			return null;
		}
	};
	
	public Set<String> getRoles(String username){
		Set<String> roles = userDAO.getRoles(username);
		return roles;
	}
	
	public Set<String> getPermissions(String username){
		Set<String> permissions = userDAO.getPermissions(username);
		return permissions;
	}
}
