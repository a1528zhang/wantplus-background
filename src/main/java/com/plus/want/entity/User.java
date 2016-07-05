package com.plus.want.entity;

/**
 * 用户信息实体类
 * @author Administrator
 *
 */
public class User {
	private Integer userId;
	private String userEmail;
	private String userPhone;
	private String userPassword;
	private String headImg;
	private String nickName;
	private String personalBlog;
	private String personalDescribe;
	private Integer state;
	
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPersonalBlog() {
		return personalBlog;
	}
	public void setPersonalBlog(String personalBlog) {
		this.personalBlog = personalBlog;
	}
	public String getPersonalDescribe() {
		return personalDescribe;
	}
	public void setPersonalDescribe(String personalDescribe) {
		this.personalDescribe = personalDescribe;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
