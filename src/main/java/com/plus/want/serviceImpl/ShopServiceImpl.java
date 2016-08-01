package com.plus.want.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.want.dao.ShopDAO;
import com.plus.want.entity.shop.Shop;
import com.plus.want.model.ResultTemplet;
import com.plus.want.model.commoditymodel.CommodityInfoModel;
import com.plus.want.service.ShopService;
import com.plus.want.util.CommonUtil;

@Service("ShopService")
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDAO shopDAO;
	
	public ResultTemplet<Object> addShop(Shop shop){
		Integer result = shopDAO.addShop(shop);
		return CommonUtil.assembleResult(1, 2000, result );
	}
	
	public ResultTemplet<Object> getShopCommodity(Integer shopId){
		List<CommodityInfoModel> resultList = shopDAO.getShopCommodity(shopId);
		return CommonUtil.assembleResult(1, 2000, resultList );
	}
	
	public ResultTemplet<Object> getShopInfo(Integer shopId) {
		Shop result = shopDAO.getShopInfo(shopId);
		return CommonUtil.assembleResult(1, 2000, result);
	}
}
