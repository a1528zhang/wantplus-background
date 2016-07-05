<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="want-details-container" id="id_details_navbar">
    <header class="want-details-box">
        <div class="want-details-cutline">
            <div class="want-details-innerbox">
                <div class="want-details-heightcenter">
                    <div class="want-details-innerimg">
                        <img class="want-details-imgheight" src="${requestScope.commodityImgUrl}"/>
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
                        <span class="want-details-bytext">BY</span> ${requestScope.shopName}
                    </div>
                    <div class="want-details-innerbtn">>${requestScope.commodityPrice}元 于${requestScope.platform}</div>
                    <div>
                        <div class="want-details-userinf" id="want_details_userinf">

                        </div>
                        <a class="userBriefJson" style="display:none">${requestScope.userBrief}</a>
                        <div class="want-details-usernum"> +${requestScope.commodityLike}</div>
                        <div class="want-clearboth"></div>

                    </div>
                    <div class="want-details-username">
                        <span style="color: #D8D8D8">Found by</span>
                        <span class="want-details-findby">@${requestScope.commodityUploadUserName}</span>
                    </div>
                </div>
                <div class="want-details-undericon ">
                    <div class="want-details-iconbox bdsharebuttonbox">
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a  class="bds_weixin" data-cmd="weixin" title="分享到微信" style="opacity: 0;"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/wechat.svg" class="details-share-wechat" />
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a  class="bds_douban" data-cmd="douban" title="分享到豆瓣网" style="opacity: 0;" ></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/douban.svg" class="details-share-douban" />
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a class="bds_tsina" data-cmd="tsina" title="分享到新浪微博" style="opacity: 0;"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/webo.svg" class="details-share-weibo" />
                            </div>
                        </div>
                        <div class="details-share-box">
                            <div class="details-share-layer2">
                                <a class="bds_fbook" data-cmd="fbook" title="分享到Facebook" style="opacity: 0;"></a>
                            </div>
                            <div class="details-share-layer1">
                                <img src="${pageContext.request.contextPath}/icon/facebook.svg" class="details-share-facebook" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="want-details-background">
        <div>
            <div class="want-details-related">RELATED</div>
            <!--内容块-->
            <div class="want-details-titlegoods">
                <div class="want-details-titleonly">
                    <span>More from <span id="want_more_username">Sagaform</span></span>
                    <span class="want-details-titlefloat">View this brand</span>
                </div>
                <div class="want-details-cutline2"></div>
                <a class="oneShopCommodity" style="display:none">${requestScope.oneShopCommodity}</a>
                <div class="want-details-goodsrow" id="want_details_goodsrow">

                </div>
                <div class="want-clearboth"></div>
            </div>
        </div>
    </div>
</div>





