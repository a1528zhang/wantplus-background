package com.plus.want.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plus.want.model.ResultTemplet;

public interface CommodityUpDownService {
	/**
	 * 图片上传到七牛
	 * @param request
	 * @param response
	 * @return
	 */
	public ResultTemplet<Object> newCommodityUpload(HttpServletRequest request,HttpServletResponse response);
}
