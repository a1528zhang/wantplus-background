package com.plus.want.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.plus.want.entity.user.User;

public interface UserDAO {
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午3:51:44
	 * @param 
	 * @description 按email(用户名)查找用户
	 * @return
	 */
	public User selectByUsername(String username);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午3:51:44
	 * @param 
	 * @description 按email(用户名)和密码查找用户
	 * @return
	 */
	public User selectByUsernamePassword(Map<String, Object> obj);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午4:01:36
	 * @param 
	 * @description 按电话查找用户
	 * @return
	 */
	public User selectByUserPhone(String username);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午4:01:36
	 * @param 
	 * @description 按电话和密码查找用户
	 * @return
	 */
	public User selectByUserPhonePassword(Map<String, Object> obj);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午4:28:31
	 * @param 
	 * @description email注册
	 * @return
	 */
	public Integer emailRegister(Map<String, Object> registerObj);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午4:29:00
	 * @param 
	 * @description 电话注册
	 * @return
	 */
	public Integer phoneRegister(Map<String, Object> registerObj);
	/**
	 * @author 张黎
	 * @date 2016年5月2日下午4:30:02
	 * @param 
	 * @description 根据id获取用户
	 * @return
	 */
	public User selectByUserId(Integer userId);

	/**
	 * 条件查询用户信息
	 * @param condition
	 * @return
	 */
	public User selectUserByCondition(Map<String, Object> condition);
	/**
	 * @author 张黎
	 * @date 2016年5月4日下午2:07:51
	 * @param 
	 * @description 邮箱登录
	 * @return
	 */
	public User emailLogin(Map<String, Object> loginObj);
	/**
	 * @author 张黎
	 * @date 2016年5月4日下午2:07:51
	 * @param 
	 * @description 电话登录
	 * @return
	 */
	public User phoneLogin(Map<String, Object> loginObj);
	/**
	 * @author 张黎
	 * @date 2016年5月5日下午8:28:09
	 * @param 
	 * @description 更新用户信息
	 * @return
	 */
	public Integer updateUserInfo(User user);
	/**
	 * @author 张黎
	 * @date 2016年3月6日下午8:36:39
	 * @param 
	 * @description 获取用户信息
	 * @return
	 */
	public User getUserPersonalInfo(Integer userId);
	/**
	 * @author 张黎
	 * @date 2016年5月29日下午10:33:13
	 * @param 
	 * @description 获取用户条数
	 * @return
	 */
	public Integer getUserCount();
	/**
	 * @author 张黎
	 * @date 2016年5月29日下午10:03:49
	 * @param 
	 * @description 获取用户列表
	 * @return
	 */
	public List<User> getUserList(Map<String, Object> condition);
	
	/**
	 * 通过用户id查询角色信息
	 * @param userId
	 * @return
	 */
	public Set<String> getRoles(String username);
	
	/**
	 * 通过用户id查询权限信息
	 * @param userId
	 * @return
	 */
	public Set<String> getPermissions(String username);
}
