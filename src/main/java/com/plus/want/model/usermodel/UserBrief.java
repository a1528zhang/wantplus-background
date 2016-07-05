package com.plus.want.model.usermodel;

/**
 * @author 张黎
 * @description 用户简单业务模型，头像和id
 */
public class UserBrief {
	private Integer userId;
	private String headImg;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void HeadImg(String headImg) {
		this.headImg = headImg;
	}
}
