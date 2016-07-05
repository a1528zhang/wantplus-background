package com.plus.want.service;

import com.plus.want.entity.Shop;
import com.plus.want.model.ResultTemplet;

public interface ShopService {
	/**
	 * 
	 * @author 张黎
	 * @date 2016年2月21日下午8:28:07
	 * @param 
	 * @description	新增商店信息
	 * @return
	 */
	public ResultTemplet<Object> addShop(Shop shop);
	/**
	 * @author 张黎
	 * @date 2016年3月6日下午7:22:07
	 * @param 
	 * @description	获取商店信息
	 * @return
	 */
	public ResultTemplet<Object> getShopInfo(Integer shopId);
	/**
	 * 
	 * @author 张黎
	 * @date 2016年2月21日下午8:28:23
	 * @param 
	 * @description	获取商店的所有商品信息
	 * @return
	 */
	public ResultTemplet<Object> getShopCommodity(Integer shopId);
}
