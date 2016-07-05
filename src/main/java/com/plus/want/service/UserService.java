package com.plus.want.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plus.want.entity.User;
import com.plus.want.model.ResultTemplet;

public interface UserService {
	/**
	 * @author 张黎
	 * @date 2016年4月19日上午10:55:20
	 * @param 
	 * @description 用户注册
	 * @return
	 */
	public ResultTemplet<Object> userRegister(String userName,String userPassword);
	/**
	 * 用户登陆
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public ResultTemplet<Object> userLogin(String userName,String userPassword,
			HttpServletRequest request,HttpServletResponse response);
	/**
	 * @author 张黎
	 * @date 2016年5月5日下午4:26:20
	 * @param 
	 * @description 用户注销
	 * @return
	 */
	public ResultTemplet<Object> userLogout(HttpServletRequest request,HttpServletResponse response);
	/**
	 * @author 张黎
	 * @date 2016年5月5日下午8:12:04
	 * @param 
	 * @description 更新用户信息
	 * @return
	 */
	public ResultTemplet<Object> updateUserInfo(User user,HttpServletRequest request,HttpServletResponse response);
	/**
	 * 条件查询用户
	 * @param userId
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User selectUserByCondition(Integer userId,String userName,String userPassword)throws Exception;
	/**
	 * @author 张黎
	 * @date 2016年3月6日下午8:32:36
	 * @param 
	 * @description 获取用户信息
	 * @return
	 */
	public ResultTemplet<Object> getUserPersonalInfo(Integer userId);
	/**
	 * @author 张黎
	 * @date 2016年5月29日下午9:58:46
	 * @param limit 每页输出条数
	 * @param offset 输出到的条数
	 * @description 获取用户列表
	 * @return
	 */
	public ResultTemplet<Object> getUserList(Integer limit,Integer offset);
}
