package com.plus.want.entity.commodity;

/**
 * 商品信息实体类
 * @author Administrator
 *
 */
public class CommodityInfo {
	private Integer commodityId;
	private String commodityName;
	private Float commodityPrice;
	private Integer commodityUploadUser;
	private Integer commodityLike;
	private Integer commodityCollection;
	private Integer commodityState;
	private Long uploadTime;
	private Integer shopId;
	private String platform;
	
	public Long getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Long uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
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
	public Integer getCommodityState() {
		return commodityState;
	}
	public void setCommodityState(Integer commodityState) {
		this.commodityState = commodityState;
	}
}
