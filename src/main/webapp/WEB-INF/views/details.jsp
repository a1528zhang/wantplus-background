<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title id="title">details</title>
    <link href="${pageContext.request.contextPath}/css/want.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/want1.2.css">
</head>
<body>
<nav id="id_want_navbar"></nav>
<div class="want-details-container" id="id_details_navbar">
    <header class="want-details-box">
        <div class="want-details-cutline">
            <div class="want-details-innerbox">
                <div class="want-details-heightcenter">
                    <div class="want-details-innerimg">
                        <img class="want-details-imgheight" src="${pageContext.request.contextPath}/img/desk.jpg"/>
                    </div>
                </div>
                <div class="want-details-undericon ">
                    <div class="want-details-doubleicon">
                        <img class="want-details-likeicon" src="${pageContext.request.contextPath}/icon/like.png"/>

                        <div class="want-details-likebox">
                            <span class="want-details-textheight">LIKE</span>
                        </div>
                        <img src="${pageContext.request.contextPath}/icon/mark.png" class="want-details-markicon"/>

                        <div class="want-details-markbox">
                            <span class="want-details-textheight2">COLLECT</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="want-details-innerbox">
                <div class="want-details-innertext">
                    <span class="want-details-title">${requestScope.commodityName}</span><br>

                    <div class="want-details-bybox">
                        <span class="want-details-bytext">BY</span> Beings小店
                    </div>
                    <div class="want-details-innerbtn">${requestScope.commodityPrice}元于淘宝</div>
                    <div>
                        <div class="want-details-userinf" id="want_details_userinf">

                        </div>
                        <div class="want-details-usernum"> +${requestScope.commodityLike}</div>
                        <div class="want-clearboth"></div>

                    </div>
                    <div class="want-details-username">
                        <span style="color: #D8D8D8">Found by</span>
                        <span class="want-details-findby">@${requestScope.userName}</span>
                    </div>
                </div>
                <div class="want-details-undericon ">
                    <div class="want-details-iconbox bdsharebuttonbox">
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信" id="details_mask_weixin"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/wechat.svg" class="details-share-imgsize" id="details_mask_weixin2"/>
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a href="#" class="bds_douban" data-cmd="douban" title="分享到豆瓣网" id="details_mask_douban"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/douban.svg" class="details-share-imgsize" id="details_mask_douban2"/>
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博" id="details_mask_xinlang"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/webo.svg" class="details-share-imgsize" id="details_mask_xinlang2"/>
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a href="#" class="bds_fbook" data-cmd="fbook" title="分享到Facebook" id="details_mask_facebook"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/facebook.svg" class="details-share-imgsize" id="details_mask_facebook2"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="want-details-background">
        <div>
            <div class="want-details-related">同品小屋</div>
            <!--内容块-->
            <div class="want-details-titlegoods">
                <div class="want-details-titleonly">
                    <span><span id="want_more_username">Beings小店</span></span>
                    <a href=""><span class="want-details-titlefloat">更多</span></a>
                </div>
                <div class="want-details-cutline2"></div>
                <div class="want-details-goodsrow" id="want_details_goodsrow">


                </div>
                <div class="want-clearboth"></div>
            </div>
            <div class="want-details-cutline2"></div>

            <div style="width: 100%;height: 200px;background-color:white;">

            </div>

        </div>
    </div>

</div>
<!--javascript-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/details.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/navbar.js"></script>
<script>
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
};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
</body>
</html>
