package com.plus.want.model.commoditymodel;

import java.util.List;

import com.plus.want.model.usermodel.UserBrief;

public class CommodityInfoModel {
	private Integer commodityId;
	private Integer commodityUploadUser;
	private String commodityUploadUserName;
	private Integer commodityLike;
	private Integer commodityCollection;
	private String commodityName;
	private Float commodityPrice;
	private String commodityImgUrl;
	private Integer shopId;
	private String shopName;
	private String shopUrl;
	private String shopIcon;
	private String platform;
	private List<UserBrief> userBrief;
	
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public String getShopIcon() {
		return shopIcon;
	}
	public void setShopIcon(String shopIcon) {
		this.shopIcon = shopIcon;
	}
	public String getCommodityUploadUserName() {
		return commodityUploadUserName;
	}
	public void setCommodityUploadUserName(String commodityUploadUserName) {
		this.commodityUploadUserName = commodityUploadUserName;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public List<UserBrief> getUserBrief() {
		return userBrief;
	}
	public void setUserBrief(List<UserBrief> userBrief) {
		this.userBrief = userBrief;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
	public Integer getCommodityUploadUser() {
		return commodityUploadUser;
	}
	public void setCommodityUploadUser(Integer commodityUploadUser) {
		this.commodityUploadUser = commodityUploadUser;
	}
	public Integer getCommodityLike() {
		return commodityLike;
	}
	public void setCommodityLike(Integer commodityLike) {
		this.commodityLike = commodityLike;
	}
	public Integer getCommodityCollection() {
		return commodityCollection;
	}
	public void setCommodityCollection(Integer commodityCollection) {
		this.commodityCollection = commodityCollection;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public Float getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public String getCommodityImgUrl() {
		return commodityImgUrl;
	}
	public void setCommodityImgUrl(String commodityImgUrl) {
		this.commodityImgUrl = commodityImgUrl;
	}
}
