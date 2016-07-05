package com.plus.want.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plus.want.entity.Shop;
import com.plus.want.model.ResultTemplet;
import com.plus.want.service.ShopService;
import com.plus.want.util.CommonUtil;

@Controller
@RequestMapping(value = "/action/shop")
public class ShopController {
	@Autowired
	private ShopService ShopService;
	
	@RequestMapping(method=RequestMethod.POST ,value = "/addShop")
	@ResponseBody
	public String addShop(Shop shop,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = ShopService.addShop(shop);
		String jsonp=request.getParameter("jsonpcallback");  
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	@RequestMapping(method=RequestMethod.GET ,value = "/getShopInfo")
	@ResponseBody
	public String getShopInfo(Integer shopId,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = ShopService.getShopInfo(shopId);
		String jsonp=request.getParameter("jsonpcallback");  
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
	}
	
	@RequestMapping(method=RequestMethod.GET ,value = "/getShopCommodity")
	@ResponseBody
	public String getShopCommodity(Integer shopId,HttpServletRequest request,HttpServletResponse response){
		ResultTemplet<Object> result = new ResultTemplet<Object>();
		result = ShopService.getShopCommodity(shopId);
		String jsonp=request.getParameter("jsonpcallback");  
		return jsonp+"("+CommonUtil.GsonSerialize(result)+")";  
//		return CommonUtil.GsonSerialize(result);
	}
}
