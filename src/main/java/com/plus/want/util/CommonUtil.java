package com.plus.want.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plus.want.dao.ExceptionDAO;
import com.plus.want.model.ResultTemplet;

public class CommonUtil {
	//@Autowired不能注入静态变量，使用配置文件注入
	private static ExceptionDAO exceptionDAO;

	public ExceptionDAO getExceptionDAO() {
		return exceptionDAO;
	}

	public void setExceptionDAO(ExceptionDAO exceptionDAO) {
		CommonUtil.exceptionDAO = exceptionDAO;
	}

	public static Map<String, Object> returnMap(String state,String reason){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("reason", reason);
		return map;
	}
	
	/**
	 * 组装为结果对象
	 * @param state
	 * @param reason
	 * @param data
	 * @return
	 */
	public static <T> ResultTemplet<Object> assembleResult(Integer state, Integer exceptionId, T data){
		ResultTemplet<Object> resultTemplet = new ResultTemplet<Object>();
		resultTemplet.setData(data);
		if (state == 1 || state.equals(1)) {
			resultTemplet.setExceptionName("请求成功");
		}else{
			String exceptionName = exceptionDAO.getExceptionName(exceptionId);
			resultTemplet.setExceptionName(exceptionName);
		}
		resultTemplet.setState(state);
		return resultTemplet;
	}
	
	/**
	 * Gson自定义序列化，改变日期格式,对象转json
	 * @param <E>
	 * @return String
	 */
	public static <E> String GsonSerialize(E obj){
		 Gson gson = new GsonBuilder()
//		 	.excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性  
		 	.enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式  
	        .serializeNulls().setDateFormat("yyyyMMddHHmmss")//时间转化为特定格式    
	        .setPrettyPrinting() //对json结果格式化.  
	        .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.  
	                            //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么  
	                            //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.  
	        .create();
		return gson.toJson(obj);
	}
	
	/**
	  * 验证邮箱地址是否正确
	  * @param email
	  * @return
	  */
	 public static boolean isEmail(String email){
	  boolean flag = false;
	  try{
	   String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	   Pattern regex = Pattern.compile(check);
	   Matcher matcher = regex.matcher(email);
	   flag = matcher.matches();
	  }catch(Exception e){
	   flag = false;
	  }
	  return flag;
	 }
	 
	 /**
	  * 验证手机号码
	  * @param mobiles
	  * @return  [0-9]{5,9}
	  */
	 public static boolean isMobileNO(String mobiles){
	  boolean flag = false;
	  try{
	   Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	   Matcher m = p.matcher(mobiles);
	   flag = m.matches();
	  }catch(Exception e){
	   flag = false;
	  }
	  return flag;
	 }
}
