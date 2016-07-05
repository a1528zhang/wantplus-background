package com.plus.want.dao;

import java.util.List;

import com.plus.want.entity.Shop;
import com.plus.want.model.commoditymodel.CommodityInfoModel;

public interface ShopDAO {
	/**
	 * @author 张黎
	 * @date 2016年2月21日下午7:46:57
	 * @param 
	 * @description	新增商店
	 * @return
	 */
	public Integer addShop(Shop shop);
	/**
	 * @author 张黎
	 * @date 2016年3月6日下午7:26:31
	 * @param 
	 * @description 获取商店信息
	 * @return
	 */
	public Shop getShopInfo(Integer shopId);
	/**
	 * @author 张黎
	 * @date 2016年2月21日下午8:36:11
	 * @param 
	 * @description 获取商店中所有商品
	 * @return
	 */
	public List<CommodityInfoModel> getShopCommodity(Integer shopId);
}
