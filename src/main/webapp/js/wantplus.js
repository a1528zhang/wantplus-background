

			// 定义各种 ID 的变量

			//获取 data
			var strjsondata;
			//jsonid 就是 commdityId
			var jsonid;
			// 上传的作者
			var JsonUpLoadUser;
			// 喜欢的数量
			var JsonLike;
			// 收藏的数量
			var JsonCollection;
			// 商品名字
			var JsonGoodsName;
			// 价格
			var JsonGoodsPrice;
			// 名字
			var JsonUserName;
			// 商品图片
			var JsonGoodsImg;



			var IdGoodsLayer; //货物白色遮罩的 id
			var IdGoodsMid;
			var IdGoodsText; //货物的名字文字描述
			var IdUserIconlike; //喜欢——未点击
			var IdUserIconlikeRed; //喜欢——已经点击
			var IdUserIconmark; //收藏
			var IdGoodsPriceout; //价格
			var IdWantUserInbox;

			var DetailsGoodsImg;
			var DetailsLikeUserImg;


			var IdWantIndexHeadimgBox;
			var IdWantPushMidbox2;
//取出 json 中的各自值

	function ajax_get_data(){
					$.ajax({
					url: '/wantplus/action/commodity/getAllLCommodity?page=1',
					type: 'GET',
					dataType: 'json',
					success: function(data){
					    strjsondata = data.data;
						wantplus_index_for();
						wantplus_whitebox_for();
						wantplus_navbar();

					}
				});
			}

	function ajax_details_data(goodsId){
		$.ajax({
			url: '/wantplus/action/commodity/getCommodityDetail?commodityId='+goodsId,
			type: 'get',
			dataType: 'html',
			success: function(data){
				var details_data = document.getElementById("detailsword");
				details_data.innerHTML = data;

				//获取详情页的喜欢的头像
				var LikeGoodsHeadsImgBefore = $(".userBriefJson").text();
				var LikeGoodsHeadsImg = JSON.parse(LikeGoodsHeadsImgBefore);

				for(i=0;i < LikeGoodsHeadsImg.length;i++){
					var LikeGoodsHeadsImgId = "like-goods-headsimgid" + LikeGoodsHeadsImg[i].userId;
					var LikeGoodsHeadsImgUrl = LikeGoodsHeadsImg[i].headImg;
					wantplus_details_userimg(LikeGoodsHeadsImgUrl,LikeGoodsHeadsImgId);

				}

				//获取详情页面同店推荐的商品
				var RecommendGoodsImgsBefore = $(".oneShopCommodity").text();
				var RecommendGoodsImgs = JSON.parse(RecommendGoodsImgsBefore);

				for (j=0;j < RecommendGoodsImgs.length;j++){
					var OneShopRecommendGoodsId = RecommendGoodsImgs[j].commodityId;
					var OneShopRecommendGoodsUrl = RecommendGoodsImgs[j].commodityImgUrl;
					 wantplus_details_goodsrow(OneShopRecommendGoodsUrl,OneShopRecommendGoodsId);
				}

				wantplus_details_shareicon();


			}
		});
	}
// 加载玩网页后开始执行的程序
			$(document).ready(function(){

				
				ajax_get_data();




// nav 上文字的颜色
				$("#id_navbar_home").attr({
					class:"want-nav-home2"
				})
			});

// 测试公共变量



// 动态产生id
			function wantplus_index_for(){
					//for(i = 0 ; i < strjsondata.length; i++){
				for(i = 0 ; i < strjsondata.length; i++){
					jsonid = strjsondata[i].commodityId;
					JsonGoodsImg = strjsondata[i].commodityImgUrl;
					JsonGoodsName = strjsondata[i].commodityName;
					JsonGoodsPrice = "$ "+strjsondata[i].commodityPrice;


					IdGoodsLayer = 'id-goods-layer'+jsonid;
					IdGoodsMid = 'id-goods-mid'+jsonid;
					IdGoodsText = 'id-goods-text'+jsonid;
					IdUserIconlike = 'id-user-iconlike'+jsonid;
					IdUserIconmark = 'id-user-iconmark'+jsonid;
					IdGoodsPriceout = 'id-goods-priceout'+jsonid;
					IdUserIconlikeRed = 'id-user-iconlikered'+jsonid;
					IdWantUserInbox	= 'id-wantuser-inbox'+jsonid;
					IdWantPushMidbox2 = "id-wantuser-midbox2"+jsonid;

					// 获取头像数组的长度

					var userimglist = strjsondata[i].userBrief;
					var userimglength = userimglist.length;

					// 喜欢的数字
					JsonLike = "+" + strjsondata[i].commodityLike;


// 注入首页div中的数据
					wantplus_index_box(IdGoodsText,JsonGoodsName,IdGoodsLayer,IdUserIconlike,"/wantplus/icon/like.png",
										IdUserIconmark,"/wantplus/icon/mark.png",IdGoodsMid,JsonGoodsPrice,IdGoodsPriceout,
										JsonGoodsImg,IdGoodsLayer,IdGoodsText,IdUserIconlike,
										IdUserIconmark,IdUserIconlikeRed,"/wantplus/icon/like2.png",IdWantUserInbox,IdWantPushMidbox2,
										userimglist,userimglength,JsonLike);

// 触发详情弹出框的遮罩
					$(document).on('click','#'+IdGoodsLayer+','+'#'+IdGoodsMid,function(e){
					$("#detailswindow").fadeToggle(100);
					$("body").addClass("want-scroll-hidden");
					$("#detailswindow").css("overflow-y","auto");

						var clickElementId = e.target.id;
						var str = clickElementId;
						var reg = /[^\d]+/img;
						str = str.replace(reg,"")
						var goodsId = str


						ajax_details_data(goodsId);
					});


				}
			}


// 顶部推荐白板
			function wantplus_whitebox_for(){
				for (i = 0 ; i < 5; i++){
					JsonGoodsImg = strjsondata[i].commodityImgUrl;
					wantplus_recommend_box(JsonGoodsImg);
				}
			}



// 商品推荐 div 注意不是头像
			function wantplus_recommend_box(RecommendGoodsImg) {
					var want_recommend_img = document.createElement("img");
					want_recommend_img.className = "want-recommend-img";
					want_recommend_img.src = RecommendGoodsImg;
					var want_recommend_innerbox = document.createElement("div");
					want_recommend_innerbox.className = "want-recommend-innerbox";
					want_recommend_innerbox.appendChild(want_recommend_img);

					var want_recommend_mask = document.createElement("div");
					want_recommend_mask.className = "want-recommend-mask";

					var want_recommend_box = document.createElement("div");
					want_recommend_box.className = "want-recommend-box";
					want_recommend_box.appendChild(want_recommend_mask);
					want_recommend_box.appendChild(want_recommend_innerbox);

					var wantplusGooddesk = document.getElementById("want_whitebox_gooddesk");
					wantplusGooddesk.appendChild(want_recommend_box);}


// 推荐的同店商品

//function wantplus_details_readygo(){
//	for(i = 0 ; i < 5; i++){
//		DetailsGoodsImg = strjsondata[i].commodityImgUrl;
//		wantplus_details_goodsrow(DetailsGoodsImg,i);
//	}
//}

// 本商品喜欢的人的头像




function wantplus_details_goodsrow(OneShopRecommendGoodsUrl,OneShopRecommendGoodsId){
	var want_details_goodssize = document.createElement("img");
	want_details_goodssize.className = "want-details-goodssize";
	want_details_goodssize.src = OneShopRecommendGoodsUrl;
	var want_details_goodsimg = document.createElement("div");
	want_details_goodsimg.className = "want-details-goodsimg";
	want_details_goodsimg.appendChild(want_details_goodssize);

	var want_details_boxmask = document.createElement("div");
	want_details_boxmask.className = "want-details-boxmask";

	var want_details_goodsbox = document.createElement("div");
	want_details_goodsbox.className = "want-details-goodsbox";
	want_details_goodsbox.id = "id_details_morefrom"+OneShopRecommendGoodsId;
	want_details_goodsbox.appendChild(want_details_boxmask);
	want_details_goodsbox.appendChild(want_details_goodsimg);

	var wantplusDetailsGoodsrow = document.getElementById("want_details_goodsrow");
	wantplusDetailsGoodsrow.appendChild(want_details_goodsbox);
}


function wantplus_details_userimg(LikeGoodsHeadsImgUrl,LikeGoodsHeadsImgId){
	var want_details_userimgmask = document.createElement("div");
	want_details_userimgmask.className = "want-details-userimgmask";
	var want_details_userimg = document.createElement("img");
	want_details_userimg.className = "want-details-userimg";
	want_details_userimg.src = LikeGoodsHeadsImgUrl;
	want_details_userimg.id = LikeGoodsHeadsImgId;
	var want_userimg_float = document.createElement("div");
	want_userimg_float.className = "want-userimg-float";
	want_userimg_float.appendChild(want_details_userimgmask);
	want_userimg_float.appendChild(want_details_userimg);
	var wantplusPullUserImg = document.getElementById("want_details_userinf");
	wantplusPullUserImg.appendChild(want_userimg_float);
}

function wantplus_details_shareicon(){
	// 微信

	$(".bds_weixin").mouseover(function(){
		$(".details-share-wechat").attr({
			class: 'details-share-wechat2'
		});
	})

	$(".bds_weixin").mouseleave(function(){
		$(".details-share-wechat2").attr({
			class: 'details-share-wechat'
		});
	})

// 豆瓣

	$(".bds_douban").mouseover(function(){
		$(".details-share-douban").attr({
			class: 'details-share-douban2'
		});
	})

	$(".bds_douban").mouseleave(function(){
		$(".details-share-douban2").attr({
			class: 'details-share-douban'
		});
	})

// 新浪

	$(".bds_tsina").mouseover(function(){
		$(".details-share-weibo").attr({
			class: 'details-share-weibo2'
		});
	})

	$(".bds_tsina").mouseleave(function(){
		$(".details-share-weibo2").attr({
			class: 'details-share-weibo'
		});
	})

// 脸书

	$(".bds_fbook").mouseover(function(){
		$(".details-share-facebook").attr({
			class: 'details-share-facebook2'
		});
	})

	$(".bds_fbook").mouseleave(function(){
		$(".details-share-facebook2").attr({
			class: 'details-share-facebook'
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


	window._bd_share_config = {
		"common": {
			"bdSnsKey": {},
			"bdText": "",
			"bdMini": "2",
			"bdMiniList": false,
			"bdPic": "",
			"bdStyle": "0",
			"bdSize": "32"
		},
		"share": {},

		"selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["weixin", "fbook", "tsina", "douban"]}
	};
	with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
}





