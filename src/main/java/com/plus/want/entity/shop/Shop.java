package com.plus.want.entity.shop;
/**
 * 商店信息实体类
 * @author a1528zhang
 *
 */
public class Shop {
	private Integer shopId;
	private String shopName;
	private String shopUrl;
	private String shopIcon;
	private String shopDescribe;
	private String shopBackground;
	
	public String getShopDescribe() {
		return shopDescribe;
	}
	public void setShopDescribe(String shopDescribe) {
		this.shopDescribe = shopDescribe;
	}
	public String getShopBackground() {
		return shopBackground;
	}
	public void setShopBackground(String shopBackground) {
		this.shopBackground = shopBackground;
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
	
}
