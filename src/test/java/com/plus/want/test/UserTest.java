package com.plus.want.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class UserTest {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 
    
    // 重用 uploadManager。一般地，只需要创建一个 uploadManager 对象
    static UploadManager uploadManager = new UploadManager();
    
    static Auth auth = Auth.create("LWI6TbysqAZdCyHp4mqaKvBzlvr1Uz2Wdxk_OqEA", "o9jMqbk3yfCxU92ThDShJh7dzIdgdUhxoN6iL0Ax");

    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    
   
    
//    public static void main(String[] args) {
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//        	CommodityDAO commodityDAO = session.getMapper(CommodityDAO.class);
//        	List<Map<String, String>> commodityInfo = commodityDAO.selectAllCommodity();
//        	Gson gson = new Gson();
//        	String json = gson.toJson(commodityInfo);
//        	System.out.println(json);
//        } finally {
//        session.close();
//        }
//    }	
    
    public static void upload(byte[] data, String key, String upToken){
    	  try {
    	        Response res = uploadManager.put(data, key, upToken);
    	        // log.info(res);
    	        // log.info(res.bodyString());
    	        // Ret ret = res.jsonToObject(Ret.class);
    	        if(res.isOK()){
    	            //success
    	        }else {
    	            //
    	        }
    	    } catch (QiniuException e) {
    	        Response r = e.response;
    	        // 请求失败时简单状态信息
    	        System.out.println(r.toString());
    	        try {
    	            // 响应的文本信息
    	        	System.out.println(r.bodyString());
    	        } catch (QiniuException e1) {
    	            //ignore
    	        }
    	    }
    	}
}
