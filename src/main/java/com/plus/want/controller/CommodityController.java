package com.plus.want.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.plus.want.model.ResultTemplet;
import com.plus.want.model.commoditymodel.CommodityInfoModel;
import com.plus.want.service.CommodityService;
import com.plus.want.service.CommodityUpDownService;
import com.plus.want.util.CommonUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping(value = "/action/commodity")
public class CommodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CommodityUpDownService commodityUpDownService;
	
	/**
	 * 取出所有的商品列表,jsonp
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET ,value = "/getAllLCommodity")
	@ResponseBody
	public String getAllLCommodity(Integer page,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = commodityService.getAllLCommodity(page);
		String jsonp=request.getParameter("jsonpcallback");
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")"; 
//		return CommonUtil.GsonSerialize(result);
	}
	
	/**
	 * 按id取出相应的商品信息
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET ,value = "/getCommodityById")
	@ResponseBody
	public String getCommodityById(Integer commodityId,HttpServletRequest request,HttpServletResponse response) {
		ResultTemplet<Object> result = commodityService.getCommodityById(commodityId);
		String jsonp=request.getParameter("jsonpcallback"); 
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";
//		return CommonUtil.GsonSerialize(result);
	}
	
	/**
	 * 商品信息上传
	 * @param commodityName
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST ,value = "/newCommodityUpload")
	@ResponseBody
	public String newCommodityUpload(HttpServletRequest request,HttpServletResponse response) {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		try {
			result = commodityUpDownService.newCommodityUpload(request,response);
		} catch (RuntimeException e) {
			e.printStackTrace();
			result = CommonUtil.assembleResult(0, 3001, "");
		}
		return CommonUtil.GsonSerialize(result);
	}
	
	/**
	 * 商品点赞
	 * @param commodityId
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST ,value = "/commodityLike")
	@ResponseBody
	public String commodityLike(Integer commodityId,Integer userId) {
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = commodityService.commodityLike(commodityId,userId);
		return CommonUtil.GsonSerialize(result);
	}
	
	/**
	 * @author 张黎
	 * @date 2016年1月13日下午9:05:14
	 * @param shopId 推荐人id
	 * @description 根据商店推荐其他的商品,jsonp
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET ,value = "/otherFromShop")
	@ResponseBody
	public String otherFromShop(Integer shopId,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = commodityService.otherFromShop(shopId);
		String jsonp=request.getParameter("jsonpcallback");  
        return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	/**
	 * @author 张黎
	 * @date 2016年1月16日下午10:20:13
	 * @param 
	 * @description 获取商品细节信息
	 * @return String 视图
	 */
	@RequestMapping(method=RequestMethod.GET ,value = "/getCommodityDetail")
	public String getCommodityDetail(Integer commodityId,Model model){
		ResultTemplet<Object> result = commodityService.getCommodityById(commodityId);
		CommodityInfoModel commodityInfoModel = (CommodityInfoModel) result.getData();
		model.addAttribute("commodityCollection", commodityInfoModel.getCommodityCollection());
		model.addAttribute("commodityId", commodityInfoModel.getCommodityId());
		model.addAttribute("commodityImgUrl", commodityInfoModel.getCommodityImgUrl());
		model.addAttribute("commodityLike", commodityInfoModel.getCommodityLike());
		model.addAttribute("commodityName", commodityInfoModel.getCommodityName());
		model.addAttribute("commodityPrice", commodityInfoModel.getCommodityPrice());
		model.addAttribute("commodityUploadUser", commodityInfoModel.getCommodityUploadUser());
		model.addAttribute("commodityUploadUserName", commodityInfoModel.getCommodityUploadUserName());
		model.addAttribute("platform", commodityInfoModel.getPlatform());
		model.addAttribute("shopId", commodityInfoModel.getShopId());
		model.addAttribute("shopName", commodityInfoModel.getShopName());
		Gson gson = new Gson();
		String userBrief = gson.toJson(commodityInfoModel.getUserBrief());
		model.addAttribute("userBrief", userBrief);
		
		ResultTemplet<Object> oneShopCommodity = commodityService.otherFromShop(commodityInfoModel.getShopId());
		model.addAttribute("oneShopCommodity",gson.toJson(oneShopCommodity.getData()));
		return "details_div";
	}
}
