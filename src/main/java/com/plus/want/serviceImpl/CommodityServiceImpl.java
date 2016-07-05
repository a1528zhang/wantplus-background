package com.plus.want.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.want.dao.CommodityDAO;
import com.plus.want.model.ResultTemplet;
import com.plus.want.model.commoditymodel.CommodityInfoModel;
import com.plus.want.model.usermodel.UserBrief;
import com.plus.want.service.CommodityService;
import com.plus.want.service.LikeService;
import com.plus.want.util.CommonUtil;

@Service("CommodityService")
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDAO commodityDAO;
	@Autowired
	private LikeService likeService;
	
	@SuppressWarnings("unchecked")
	public ResultTemplet<Object> getAllLCommodity(Integer page){
		Integer start = (page-1)*12;
		List<CommodityInfoModel> resultList = commodityDAO.getAllLCommodity(start);
		for(int i = 0;i<resultList.size();i++){
			Integer Id = resultList.get(i).getCommodityId();
			//获取点赞用户的头像和id
			List<UserBrief> userBriefs = (List<UserBrief>)likeService.getUserBrief(Id,5).getData();
			resultList.get(i).setUserBrief(userBriefs);
		}
		return CommonUtil.assembleResult(1, 2000, resultList);
	}
	
	@SuppressWarnings("unchecked")
	public ResultTemplet<Object> getCommodityById(Integer commodityId){
		CommodityInfoModel result = commodityDAO.getCommodityById(commodityId);
		
		List<UserBrief> userBriefs = (List<UserBrief>)likeService.getUserBrief(commodityId,20).getData();
		if (userBriefs.size() == 0) {
		}else {
			result.setUserBrief(userBriefs);
		}
		return CommonUtil.assembleResult(1, 2000, result);
	}
	
	public ResultTemplet<Object> otherFromShop(Integer shopId){
		List<Map<String, Object>> commodityList = commodityDAO.otherFromShop(shopId);
		return CommonUtil.assembleResult(1, 2000, commodityList);
	}
	
	public ResultTemplet<Object> commodityLike(Integer commodityId,Integer userId){
		Map<String, Object> condition = new HashMap<String, Object>();
		Integer result = commodityDAO.commodityLike(condition);
		return CommonUtil.assembleResult(1, 2000, null);
	}
}
