/**
 * Created by maverick on 16/1/2.
 */
// 首页商品的展示div
function wantplus_index_box(idGoodsText,goodsname,idGoodsLayer,idUserIconlike,imgiconlike,
                            idUserIconmark,imgiconmark,idGoodsmid,pricecount,idGoodsPriceout,
                            imgsrc,IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark,idUserIconlikered
    ,imgiconlikered,IdWantUserInbox,IdWantPushMidbox2,userimglist,userimglength) {

// 覆盖在div上的白色遮罩以及上面的文字
    var want_goods_text = document.createElement("div");
    want_goods_text.className = "want-goods-text";
    want_goods_text.id = idGoodsText;
    want_goods_text.innerText = goodsname;
    var want_goods_layer = document.createElement("div");
    want_goods_layer.className = "want-goods-layer";
    want_goods_layer.onmouseover = function(){mouseoverfun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark);};
    want_goods_layer.onmouseleave = function(){mouseleavefun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark);};
    want_goods_layer.id = idGoodsLayer;
    want_goods_layer.appendChild(want_goods_text);

// 点赞收藏以及价格的div拼接
    var want_user_iconlike = document.createElement("img");
    want_user_iconlike.className = "want-user-iconlike";
    want_user_iconlike.id = idUserIconlike;
    want_user_iconlike.src = imgiconlike;
    want_user_iconlike.onclick = function(){mouseclickfun(idUserIconlikered);};
    var want_user_iconlikered = document.createElement("img");
    want_user_iconlikered.className = "want-user-iconlikered";
    want_user_iconlikered.id = idUserIconlikered;
    want_user_iconlikered.src = imgiconlikered;
    want_user_iconlikered.onclick = function(){mouseclickfun2(idUserIconlikered);};
    var want_user_iconmark = document.createElement("img");
    want_user_iconmark.className = "want-user-iconmark";
    want_user_iconmark.id = idUserIconmark;
    want_user_iconmark.src = imgiconmark;
    var want_goods_mid = document.createElement("div");
    want_goods_mid.className = "want-goods-mid";
    want_goods_mid.id = idGoodsmid;
    want_goods_mid.onmouseover = function(){mouseoverfun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark);};
    want_goods_mid.onmouseleave = function(){mouseleavefun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark);};
    want_goods_mid.appendChild(want_user_iconlike);
    want_goods_mid.appendChild(want_user_iconlikered);
    want_goods_mid.appendChild(want_user_iconmark);
    var want_goods_priceinner = document.createElement("div");
    want_goods_priceinner.className = "want-goods-priceinner";
    want_goods_priceinner.innerText = pricecount;
    var want_goods_priceout = document.createElement("div");
    want_goods_priceout.className = "want-goods-priceout";
    want_goods_priceout.id = idGoodsPriceout;
    want_goods_priceout.appendChild(want_goods_mid);
    want_goods_priceout.appendChild(want_goods_priceinner);



// 拼接头像模块2 ——头像在 div 中的位置
    var want_user_inbox = document.createElement("div");
    want_user_inbox.className = "want-user-inbox";
    want_user_inbox.id = IdWantUserInbox;
    var want_user_midbox = document.createElement("div");
    want_user_midbox.className = "want-user-midbox";
    want_user_midbox.appendChild(want_user_inbox);

    var want_user_midbox2 = document.createElement("div");
    want_user_midbox2.className = "want-user-midbox2";
    want_user_midbox2.id = IdWantPushMidbox2;

    var want_user_outbox = document.createElement("div");
    want_user_outbox.className = "want-user-outbox";
    want_user_outbox.appendChild(want_user_midbox);
    want_user_outbox.appendChild(want_user_midbox2);


// 核心商品图片载入
    var want_goods_imgwidth = document.createElement("img");
    want_goods_imgwidth.className = "want-goods-imgwidth";
    want_goods_imgwidth.src = imgsrc;
    var want_goods_inner = document.createElement("div");
    want_goods_inner.className = "want-goods-inner";
    want_goods_inner.appendChild(want_goods_imgwidth);

// 将上述所有的盒子推入次外层容器
    var want_goods_details = document.createElement("div");
    want_goods_details.className = "want-goods-details";
    want_goods_details.appendChild(want_goods_layer);
    want_goods_details.appendChild(want_goods_priceout);
    want_goods_details.appendChild(want_user_outbox);
    want_goods_details.appendChild(want_goods_inner);

//最外层容器div
    var want_goods_box = document.createElement("div");
    want_goods_box.className = "want-goods-box";
    want_goods_box.appendChild(want_goods_details);

// 将上述拼装的div注入网页
    var wantplusIndex = document.getElementById("want_index_container");
    wantplusIndex.appendChild(want_goods_box);

    // 判断的头像数是否大于5
    if (userimglength < 5){
        for (j = 0 ; j < userimglength ;j++ ) {
            var jsonUserId = userimglist[j].userId;
            var jsonUserImg = userimglist[j].headImg;
            IdWantIndexHeadimgBox = 'id-wantindex-userimg'+jsonUserId+'_'+jsonid;
            wantplus_index_userimg(jsonUserImg,j,IdWantIndexHeadimgBox);
        }
        wantplus_index_pushuserimg(j,JsonLike,IdWantPushMidbox2);
    }else {
        for (j = 0 ; j < 5; j++){
            var jsonUserId = userimglist[j].userId;
            var jsonUserImg = userimglist[j].headImg;
            IdWantIndexHeadimgBox = 'id-wantindex-userimg'+jsonUserId+'_'+jsonid
            wantplus_index_userimg(jsonUserImg,j,IdWantIndexHeadimgBox);
        }
        wantplus_index_pushuserimg(j,JsonLike,IdWantPushMidbox2); //执行往对应的关注头像后写入数字
    }
}

// 拼接头像模块1 ——头像样式
function wantplus_index_userimg(jsonUserImg,j,IdWantIndexHeadimgBox)
{
    var want_user_indexhead = document.createElement("img");
    want_user_indexhead.className = "want-user-indexhead";
    want_user_indexhead.src = jsonUserImg;

    var want_user_shade = document.createElement("div");
    want_user_shade.className = "want-user-shade";


    var want_index_headimgbox = document.createElement("div");
    want_index_headimgbox.className = "want-index-headimgbox";
    want_index_headimgbox.id = IdWantIndexHeadimgBox;
    want_index_headimgbox.appendChild(want_user_indexhead);
    want_index_headimgbox.appendChild(want_user_shade);


    var wantplusIndexUserimg = document.getElementById(IdWantUserInbox);
    wantplusIndexUserimg.appendChild(want_index_headimgbox);

    var want_get_imgheadpic = j * 28;
    var want_get_imgheadzindex = 10 - j;
    $("#" + IdWantIndexHeadimgBox).css({
        "margin-left": want_get_imgheadpic + "px",
        "z-index": want_get_imgheadzindex,
    });
}

function wantplus_index_pushuserimg(j,JsonLike,IdWantPushMidbox2) {
    var want_index_likecount = document.createElement("div");
    want_index_likecount.className = "want-index-headimgbox2";
    want_index_likecount.innerText = JsonLike;

    var wantplusIndexLikeCount = document.getElementById(IdWantPushMidbox2);
    wantplusIndexLikeCount.appendChild(want_index_likecount);

    var want_get_likecount = j * 28 + 8;
    $('#'+IdWantPushMidbox2).css({
        "margin-left":want_get_likecount+"px",
    });
}

