package com.plus.want.dao;

import java.util.List;
import java.util.Map;

import com.plus.want.entity.commodity.CommodityImg;
import com.plus.want.entity.commodity.CommodityInfo;
import com.plus.want.model.commoditymodel.CommodityInfoModel;

public interface CommodityDAO {
	/**
	 * @author 张黎
	 * @date 2016年1月13日下午10:04:40
	 * @param page 当前页数
	 * @description	获取所有商品列表，一组12个
	 * @return
	 */
	public List<CommodityInfoModel> getAllLCommodity(Integer page);
	/**
	 * 根据产品id查询相关信息
	 * @param commodityId
	 * @return
	 */
	public CommodityInfoModel getCommodityById(Integer commodityId);
	
	/**
	 * 条件查询所有产品信息列表
	 * @return
	 */
	public List<CommodityInfoModel> selectCommodityByCondition(Map<String, Object> condition);
	/**
	 * 保存商品信息
	 * @param commodityInfo
	 * @return
	 */
	public Integer saveCommodityInfo(CommodityInfo commodityInfo);
	/**
	 * 保存商品图片信息
	 * @param commodityImg
	 * @return
	 */
	public Integer saveCommodityImg(CommodityImg commodityImg);
	/**
	 * @author 张黎
	 * @date 2016年1月13日下午9:31:57
	 * @param 
	 * @description 根据商店推荐其他的商品
	 * @return
	 */
	public List<Map<String, Object>> otherFromShop(Integer shopId);
	/**
	 * @author 张黎
	 * @date 2016年1月21日下午11:17:56
	 * @param 添加商品点赞关系
	 * @description
	 * @return
	 */
	public Integer commodityLike(Map<String, Object> condition);
}
