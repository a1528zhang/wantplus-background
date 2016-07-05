package com.plus.want.dao;

import java.util.List;
import java.util.Map;

import com.plus.want.model.usermodel.UserBrief;

public interface LikeDAO {
	/**
	 * @author 张黎
	 * @date 2016年1月6日下午10:13:48
	 * @param Integer commodityId
	 * @description 用商品id获取点赞用户头像id
	 * @return List<UserBrief>
	 */
	public List<UserBrief> getLikeUserBrief(Map<String, Object> conditionMap);
	/**
	 * @author 张黎
	 * @date 2016年1月21日下午6:54:26
	 * @param commodityId
	 * @param userId
	 * @description 添加点赞关系
	 * @return
	 */
	public Integer commodityLike(Integer commodityId,Integer userId);
}
