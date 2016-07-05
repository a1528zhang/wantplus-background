package com.plus.want.service;

import com.plus.want.model.ResultTemplet;

public interface LikeService {
	/**
	 * @author 张黎
	 * @date 2016年1月6日下午10:13:48
	 * @param Integer commodityId
	 * @param Integer onePageNum 一次查询个数
	 * @description 用商品id获取点赞用户头像id
	 * @return ResultTemplet<Object>
	 */
	public ResultTemplet<Object> getUserBrief(Integer commodityId,Integer onePageNum);
}
