//测试 json
var strjson = {
			  "reason": "查询符合条件的商品",
			  "state": 1,
			  "data": [
			    {
			      "commodityId": 22,
			      "commodityUploadUser": 1,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "upooo",
			      "commodityPrice": 656,
			      "userName": "beings.java",
			      "commodityImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/bluebag.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/6.jpg"
			    },
			    {
			      "commodityId": 21,
			      "commodityUploadUser": 2,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "ppp",
			      "commodityPrice": 450,
			      "userName": "beings.oc",
			      "commodityImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/desk.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/1.jpg"
			    },
			    {
			      "commodityId": 23,
			      "commodityUploadUser": 3,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "bag",
			      "commodityPrice": 788,
			      "userName": "beings.swift",
			      "commodityImgUrl": "http://7xpbw2.com1.z0.glb.clouddn.com/3_20151229222445_bag_L.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/2.png"
			    },
			    {
			      "commodityId": 24,
			      "commodityUploadUser": 4,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "teapot",
			      "commodityPrice": 666,
			      "userName": "beings.js",
			      "commodityImgUrl": "http://7xpbw2.com1.z0.glb.clouddn.com/4_20151229222515_tea_L.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/3.jpg"
			    },
			    {
			      "commodityId": 25,
			      "commodityUploadUser": 4,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "glassbag",
			      "commodityPrice": 82,
			      "userName": "beings.c",
			      "commodityImgUrl": "http://7xpbw2.com1.z0.glb.clouddn.com/4_20151229222536_glassbag_L.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/4.jpg"
			    },
			    {
			      "commodityId": 26,
			      "commodityUploadUser": 5,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "glass",
			      "commodityPrice": 54,
			      "userName": "beings.node",
			      "commodityImgUrl": "http://7xpbw2.com1.z0.glb.clouddn.com/5_20151229222549_glass_L.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/5.jpg"
			    },
			    {
			      "commodityId": 27,
			      "commodityUploadUser": 6,
			      "commodityLike": 0,
			      "commodityCollection": 0,
			      "commodityName": "light",
			      "commodityPrice": 6,
			      "userName": "beings.go",
			      "commodityImgUrl": "http://7xpbw2.com1.z0.glb.clouddn.com/6_20151229222559_light_L.jpg",
			      "commodityUserImgUrl": "http://7xpmhh.com1.z0.glb.clouddn.com/7.jpg"
			    }
			  ]
			}

var strjsondata = strjson.data;
var DetailsGoodsImg;
var DetailsLikeUserImg;





function wantplus_details_readygo(){
	for(i = 0 ; i < 5; i++){
		DetailsGoodsImg = strjsondata[i].commodityImgUrl;
		wantplus_details_goodsrow(DetailsGoodsImg,i);
	}

	for (i = 0; i < strjsondata.length; i++) {
		DetailsLikeUserImg = strjsondata[i].commodityUserImgUrl;
		wantplus_details_userimg(DetailsLikeUserImg,i)
	};

}
	

function wantplus_details_goodsrow(DetailsGoodsImg,i){
	var want_details_goodssize = document.createElement("img");
	want_details_goodssize.className = "want-details-goodssize";
	want_details_goodssize.src = DetailsGoodsImg;
	var want_details_goodsimg = document.createElement("div");
	want_details_goodsimg.className = "want-details-goodsimg";	
	want_details_goodsimg.appendChild(want_details_goodssize);

	var want_details_boxmask = document.createElement("div");
	want_details_boxmask.className = "want-details-boxmask";

	var want_details_goodsbox = document.createElement("div");
	want_details_goodsbox.className = "want-details-goodsbox";
	want_details_goodsbox.id = "id_details_morefrom"+i;
	want_details_goodsbox.appendChild(want_details_boxmask);
	want_details_goodsbox.appendChild(want_details_goodsimg);

	var wantplusDetailsGoodsrow = document.getElementById("want_details_goodsrow");
    wantplusDetailsGoodsrow.appendChild(want_details_goodsbox);
}  


function wantplus_details_userimg(DetailsLikeUserImg){
    var want_details_userimgmask = document.createElement("div");
    want_details_userimgmask.className = "want-details-userimgmask";
    var want_details_userimg = document.createElement("img");
    want_details_userimg.className = "want-details-userimg";
    want_details_userimg.src = DetailsLikeUserImg;
    var want_userimg_float = document.createElement("div");
    want_userimg_float.className = "want-userimg-float";
    want_userimg_float.appendChild(want_details_userimgmask);
    want_userimg_float.appendChild(want_details_userimg);
    var wantplusPullUserImg = document.getElementById("want_details_userinf");
    wantplusPullUserImg.appendChild(want_userimg_float);
}

// 微信

$("#details_mask_weixin").mouseover(function(){
		$("#details_mask_weixin2").attr({
			class: 'details-share-imgsize2'
		});
})

$("#details_mask_weixin").mouseleave(function(){
	$("#details_mask_weixin2").attr({
		class: 'details-share-imgsize'
	});
})

// 豆瓣

$("#details_mask_douban").mouseover(function(){
	$("#details_mask_douban2").attr({
		class: 'details-share-imgsize2'
	});
})

$("#details_mask_douban").mouseleave(function(){
	$("#details_mask_douban2").attr({
		class: 'details-share-imgsize'
	});
})

// 新浪

$("#details_mask_xinlang").mouseover(function(){
	$("#details_mask_xinlang2").attr({
		class: 'details-share-imgsize2'
	});
})

$("#details_mask_xinlang").mouseleave(function(){
	$("#details_mask_xinlang2").attr({
		class: 'details-share-imgsize'
	});
})

// 脸书

$("#details_mask_facebook").mouseover(function(){
	$("#details_mask_facebook2").attr({
		class: 'details-share-imgsize2'
	});
})

$("#details_mask_facebook").mouseleave(function(){
	$("#details_mask_facebook2").attr({
		class: 'details-share-imgsize'
	});
})

// 喜欢

$(".want-details-likeicon,.want-details-textheight").mouseover(function(){
	$(".want-details-likeicon").attr({
		class: 'want-details-likeicon2'
	});
})

$(".want-details-likeicon,.want-details-textheight").mouseleave(function(){
	$(".want-details-likeicon2").attr({
		class: 'want-details-likeicon'
	});
})

// 选择

$(".want-details-markicon,.want-details-textheight2").mouseover(function(){
	$(".want-details-markicon").attr({
		class: 'want-details-markicon2'
	});
})

$(".want-details-markicon,.want-details-textheight2").mouseleave(function(){
	$(".want-details-markicon2").attr({
		class: 'want-details-markicon'
	});
})
