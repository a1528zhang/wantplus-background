package com.plus.want.entity;

/**
 * 商品图片信息实体类
 * @author Administrator
 *
 */
public class CommodityImg {
	private Integer commodityImgId;
	private String commodityImgUrl;
	private Integer commodityImgSize;
	private Integer commodityId;
	
	public Integer getCommodityImgId() {
		return commodityImgId;
	}
	public void setCommodityImgId(Integer commodityImgId) {
		this.commodityImgId = commodityImgId;
	}
	public String getCommodityImgUrl() {
		return commodityImgUrl;
	}
	public void setCommodityImgUrl(String commodityImgUrl) {
		this.commodityImgUrl = commodityImgUrl;
	}
	public Integer getCommodityImgSize() {
		return commodityImgSize;
	}
	public void setCommodityImgSize(Integer commodityImgSize) {
		this.commodityImgSize = commodityImgSize;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
}
