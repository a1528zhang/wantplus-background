package com.plus.want.service;

import com.plus.want.model.ResultTemplet;

public interface CommodityService {
	/**
	 * @author 张黎
	 * @date 2016年1月13日下午10:11:26
	 * @param page 当前页数
	 * @description 获取所有商品列表，一组12个
	 * @return
	 */
	public ResultTemplet<Object> getAllLCommodity(Integer page);
	/**
	 * @author 张黎
	 * @date 2016年1月14日下午10:24:42
	 * @param 
	 * @description 按id取出相应的商品信息
	 * @return
	 */
	public ResultTemplet<Object> getCommodityById(Integer commodityId);
	/**
	 * 按条件寻找商品信息
	 * @param commodityId id
	 * @param commodityImgSize 照片尺寸
	 * @param commodityUploadUser	上传用户
	 * @return
	 * @throws Exception 
	 */
//	public ResultTemplet<Object> selectCommodityByCondition(Integer commodityId,
//			Integer commodityImgSize,Integer commodityUploadUser);
	/**
	 * @author 张黎
	 * @date 2016年1月13日下午9:27:23
	 * @param Integer shopId
	 * @description 根据商店推荐其他的商品
	 * @return
	 */
	public ResultTemplet<Object> otherFromShop(Integer shopId);
	/**
	 * @author 张黎
	 * @date 2016年1月21日下午6:50:34
	 * @param 商品点赞
	 * @description
	 * @return
	 */
	public ResultTemplet<Object> commodityLike(Integer commodityId,Integer userId);
}
