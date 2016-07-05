package com.plus.want.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.plus.want.dao.CommodityDAO;
import com.plus.want.entity.CommodityImg;
import com.plus.want.entity.CommodityInfo;
import com.plus.want.model.ResultTemplet;
import com.plus.want.service.CommodityUpDownService;
import com.plus.want.util.CommonUtil;
import com.plus.want.util.ImageUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

@Service("CommodityUpDownService")
public class CommodityUpDownServiceImpl implements CommodityUpDownService {
	
	@Autowired
	private CommodityDAO commodityDAO;
	
	//应该写为一个接口来设置
	//伍双的
	private String accessKey = "exempwg0U6rl1yL_2G4A_00weNY5kEdMeG7oYH04";
	private String secretKey = "8dhh34fcyMD3tDobvwSrsWbhX-GC6GKvykOikmLm";
	//张黎的
//	private String accessKey = "LWI6TbysqAZdCyHp4mqaKvBzlvr1Uz2Wdxk_OqEA";
//	private String secretKey = "o9jMqbk3yfCxU92ThDShJh7dzIdgdUhxoN6iL0Ax";
	//空间名
	private String bucket = "wantplus";
	//图片暂存位置
	private String imageBaseUrl = "F:/wantPlusImage/";
	//图片存于七牛的位置
	private String imagePushUrlString = "http://7xpbw2.com1.z0.glb.clouddn.com/";
	
	private UploadManager uploadManager = new UploadManager();
	
	@Transactional
	public ResultTemplet<Object> newCommodityUpload(HttpServletRequest request,HttpServletResponse response){
		try {
			Map<String, Object> receive = commodityReceive(request,response);
			
			//图片上传到七牛
			System.out.println("图片上传成功");
			//保存信息到数据库
			String imgSizeSName = receive.get("imgSizeSName").toString();
			String imgSizeMName = receive.get("imgSizeMName").toString();
			String imgSizeLName = receive.get("imgSizeLName").toString();
			
			CommodityInfo commodityInfo = new CommodityInfo();
			System.out.println(request.getParameter("commodityName"));
			commodityInfo.setCommodityName(request.getParameter("commodityName"));
			commodityInfo.setCommodityPrice(Float.parseFloat(request.getParameter("commodityPrice")));
			commodityInfo.setCommodityUploadUser(Integer.parseInt(request.getParameter("commodityUploadUser")));
			commodityInfo.setShopId(Integer.parseInt(request.getParameter("shopId")));
			commodityInfo.setPlatform(request.getParameter("platform"));
			commodityInfo.setUploadTime(new Date().getTime());
			commodityInfo.setCommodityLike(0);
			commodityInfo.setCommodityCollection(0);
			commodityInfo.setCommodityState(1);
			
			Integer infoResult = commodityDAO.saveCommodityInfo(commodityInfo);
			if (infoResult != 1){
				throw new RuntimeException("商品信息保存影响条目不为1");
			}
			
			CommodityImg commodityImg = new CommodityImg();
			commodityImg.setCommodityId(commodityInfo.getCommodityId());
			
			commodityImg.setCommodityImgSize(0);
			commodityImg.setCommodityImgUrl(imagePushUrlString+imgSizeSName);
			commodityDAO.saveCommodityImg(commodityImg);
			
			commodityImg.setCommodityImgSize(1);
			commodityImg.setCommodityImgUrl(imagePushUrlString+imgSizeMName);
			commodityDAO.saveCommodityImg(commodityImg);
			
			commodityImg.setCommodityImgSize(2);
			commodityImg.setCommodityImgUrl(imagePushUrlString+imgSizeLName);
			commodityDAO.saveCommodityImg(commodityImg);
			
			return CommonUtil.assembleResult(1, 2000, "");
		}catch(QiniuException e){
			e.printStackTrace();
			throw new RuntimeException("图片上传到七牛，imgpush异常");
		}catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("图片上传到服务器，IO异常");
		}catch (IllegalStateException e) {
			e.printStackTrace();
			throw new RuntimeException("图片上传到服务器，localfile不合法");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("图片压缩上传异常");
		}
	}
	
	/**
	 * 将图片暂时保存在服务器并压缩成不同的大小
	 * @param request
	 * @param response
	 * @return Map<String, Object> 结果状态码和图片在服务器的路径
	 * @throws Exception 
	 */
	public Map<String, Object> commodityReceive(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//上传策略
//		StringMap policy = new StringMap();
		//只允许图片上传，否则返回403
//		policy.put("mimeLimit", "image/*");
		//取得用户名
		String commodityUploadUser = request.getParameter("commodityUploadUser");
		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateNow = format.format(new Date());
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //重命名上传后的文件名  
                        String fileName = myFileName; 
                        //去除后缀的文件名
                        String fileNameOriginal = fileName.substring(0,fileName.lastIndexOf("."));
                        //文件后缀名
                        String suffixName = fileName.substring(fileName.lastIndexOf("."));
                        //文件修改为三种大小,不带路径,用户名+日期+文件名+大小+扩展名重命名图片
                        String imgSizeSName = commodityUploadUser+"_"+dateNow+"_"+fileNameOriginal+"_S"+suffixName;
                        String imgSizeMName = commodityUploadUser+"_"+dateNow+"_"+fileNameOriginal+"_M"+suffixName;
                        String imgSizeLName = commodityUploadUser+"_"+dateNow+"_"+fileNameOriginal+"_L"+suffixName;
                        //定义上传路径 ,暂定为f盘
//                      String path = "/usr/local/img/" + fileName;  
                        String path = "F:/wantPlusImage/" + fileName;  
                        File localFile = new File(path);  
						try {
							file.transferTo(localFile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw e;
						} catch (IllegalStateException e) {
							e.printStackTrace();
                        	throw e;
						}try {
                        	Auth auth = Auth.create(accessKey, secretKey);
                        	System.out.println(localFile.getPath());
                        	Response respS = imgPush(path,imgSizeSName,auth,100);
                        	Response respM = imgPush(path,imgSizeMName,auth,200);
                        	Response respL = imgPush(path,imgSizeLName,auth,300);
							//判断返回的状态码
							if (respS == null) {
								throw new RuntimeException("S类型上传被拒绝");
							};
							if (respM == null) {
								throw new RuntimeException("M类型上传被拒绝");
							};
							if (respL == null) {
								throw new RuntimeException("L类型上传被拒绝");
							};
							resultMap.put("imgSizeSName", imgSizeSName);
							resultMap.put("imgSizeMName", imgSizeMName);
							resultMap.put("imgSizeLName", imgSizeLName);
							//删除图片
							localFile.delete();
                        }catch(Exception e){
                        	e.printStackTrace();
                        	throw e;
                        }
                    }  
                }  
            }  
        }else{
        	//request中不包含图片
        	resultMap.put("result", "2");
        }
        return resultMap; 
	}
	
	/**
	 * 图片压缩及上传方法
	 * @param path	源图像文件地址
	 * @param imgName	图片名
	 * @param auth	授权对象
	 * @param size 图片高度和宽度
	 * @return Response
	 * @throws Exception 
	 */
	private Response imgPush(String path,String imgName,Auth auth,Integer size) throws Exception {
		Response response = null;
		try {
			//图片压缩
			ImageUtil.zoomOutWithoutScale(path, imageBaseUrl+imgName, size, size, true);
			//获取上传凭证
			String token =auth.uploadToken(bucket,imgName);
			//上传
			response = uploadManager.put(
					imageBaseUrl+imgName,imgName, token);
		} catch (QiniuException e) {
			e.printStackTrace();
			throw e;
		}catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
