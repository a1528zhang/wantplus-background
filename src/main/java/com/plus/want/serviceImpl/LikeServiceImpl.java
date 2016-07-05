package com.plus.want.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.want.dao.LikeDAO;
import com.plus.want.model.ResultTemplet;
import com.plus.want.model.usermodel.UserBrief;
import com.plus.want.service.LikeService;
import com.plus.want.util.CommonUtil;

@Service("LikeService")
public class LikeServiceImpl implements LikeService {
	@Autowired
	private LikeDAO likeDAO;
	
	public ResultTemplet<Object> getUserBrief(Integer commodityId,Integer onePageNum) {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("commodityId", commodityId);
		conditionMap.put("onePageNum", onePageNum);
		List<UserBrief> userBriefs = likeDAO.getLikeUserBrief(conditionMap);
		return CommonUtil.assembleResult(1, 2000, userBriefs);
	}
}
