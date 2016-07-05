package com.plus.want.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.want.service.UserService;
import com.plus.want.util.CommonUtil;
import com.plus.want.dao.UserDAO;
import com.plus.want.entity.User;
import com.plus.want.model.ResultTemplet;;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	public ResultTemplet<Object> userRegister(String userName,String userPassword){
		if(CommonUtil.isEmail(userName)){
			User user = userDAO.selectByUserEmail(userName);
			if (user != null) {
				return CommonUtil.assembleResult(0,1003,""); 
			}else{
				Map<String, Object> registerObj = new HashMap<String, Object>();
				registerObj.put("userEmail", userName);
				registerObj.put("userPassword", userPassword);
				Integer userId = userDAO.emailRegister(registerObj);
				user = userDAO.selectByUserId(userId);
				return CommonUtil.assembleResult(1, 2000, user);
			}
		}else if(CommonUtil.isMobileNO(userName)){
			User user = userDAO.selectByUserPhone(userName);
			if (user != null) {
				return CommonUtil.assembleResult(0,1003,""); 
			}else{
				Map<String, Object> registerObj = new HashMap<String, Object>();
				registerObj.put("userPhone", userName);
				registerObj.put("userPassword", userPassword);
				Integer userId = userDAO.phoneRegister(registerObj);
				user = userDAO.selectByUserId(userId);
				return CommonUtil.assembleResult(1, 2000, user);
			}
		}else{
			return CommonUtil.assembleResult(0,1001,"");
		}
	}
	
	public ResultTemplet<Object> userLogin(String username,String userPassword
			,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> loginObj = new HashMap<String, Object>();
		User user=null;
		
		HttpSession session = request.getSession();
        //判断session是不是新创建的
//        if (session.isNew()) {
        	if(CommonUtil.isEmail(username)){
    			loginObj.put("userEmail", username);
    			loginObj.put("userPassword", userPassword);
    			user = userDAO.emailLogin(loginObj);
    		}else if(CommonUtil.isMobileNO(username)){
    			loginObj.put("userPhone", username);
    			loginObj.put("userPassword", userPassword);
    			user = userDAO.phoneLogin(loginObj);
    		}else{
    			return CommonUtil.assembleResult(0,1001,"");
    		}
        	session.setAttribute("user", user);
    		if (user != null) {
    			return CommonUtil.assembleResult(1, 2000, user);
    		}else{
    			return CommonUtil.assembleResult(0, 1002, "");
    		}
//        }else {
//        	user = (User)session.getAttribute("user");
//        	return CommonUtil.assembleResult(1, 2000, user);
//        }
	}
	
	public ResultTemplet<Object> userLogout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session == null){
			return CommonUtil.assembleResult(0, 1004, "");
		}else{
			session.invalidate();
			return CommonUtil.assembleResult(1, 2000, "");
		}
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
}
