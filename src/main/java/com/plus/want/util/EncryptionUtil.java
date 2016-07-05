package com.plus.want.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil {
	/**
	 * URL安全的Base64编码
	 * @param input
	 * @return
	 */
	public static String base64UrlDecode(String input) {
	    String result = null;
	    Base64 decoder = new Base64(true);
	    byte[] decodedBytes = decoder.decode(input);
	    result = new String(decodedBytes);
	    return result;
	}
	
	/**  
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名  
     * @param encryptText 被签名的字符串  
     * @param encryptKey  密钥  
     * @return  
     * @throws Exception  
     */    
    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception     
    {           
        byte[] data=encryptKey.getBytes("UTF-8");  
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称  
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");   
        //生成一个指定 Mac 算法 的 Mac 对象  
        Mac mac = Mac.getInstance("HmacSHA1");   
        //用给定密钥初始化 Mac 对象  
        mac.init(secretKey);    
          
        byte[] text = encryptText.getBytes("UTF-8");    
        //完成 Mac 操作   
        return mac.doFinal(text);    
    }
    
    /** 
     * byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。 
     * Convert byte[] to hex string.
     * @param src byte[] data 
     * @return hex string 
     */     
    public static String bytesToHexString(byte[] src){  
        StringBuilder stringBuilder = new StringBuilder("");  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        for (int i = 0; i < src.length; i++) {  
            int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v);  
            if (hv.length() < 2) {  
                stringBuilder.append(0);  
            }  
            stringBuilder.append(hv);  
        }  
        return stringBuilder.toString();  
    }  
}
