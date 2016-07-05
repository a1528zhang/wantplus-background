
	//function click_details_mask(){
	//	//var detailsinner2 = $(window).height();
	//	//var detailsword1 = $("#detailsword").outerHeight(true);
	//	//var detailsword2 = $("#detailsword").height();
	//	//var marginnumber = (detailsinner2 - detailsword2)/2;
	//	//if (detailsword1 >= detailsinner2){
	//	//	$("#zezhao").css("height",detailsword1);
	//	//} else {
	//	//	$("#zezhao").css("height",detailsinner2);
	//	//	$("#detailsword").css("margin-top",marginnumber);
	//	//}
    //
	//	$(document).on('click','#detailsword',function(){
	//		$("#detailswindow").fadeToggle(100);
	//		$("#detailswindow").css("overflow-y","hidden");
	//		$("body").removeClass("want-scroll-hidden");
    //
	//	});
    //
	//}

	document.addEventListener("click",function(e){
		if(e.target.id == "detailsword"){
			$("#detailswindow").fadeToggle(100);
			$("#detailswindow").css("overflow-y","hidden");
			$("body").removeClass("want-scroll-hidden");
		}
		//alert(e.target);
	},false);

	$(document).get(0).addEventListener('mousewheel', removeWheelEvent, false);
	$('#detailswindow').get(0).addEventListener('mousewheel', enAbleScroll, false);

	function enAbleScroll(e) {

		e.stopPropagation();
		e.cancelBubble = false;
		var obj = $('#detailswindow').get(0);
		var delta = 0;

		if (e.wheelDelta) { /* IE/Opera. */
			delta = e.wheelDelta/120;
		} else if (e.detail) { /** Mozilla case. */
		delta = -e.detail/3;
		}
		console.log(delta);
		if($(obj).innerHeight() + $(obj).scrollTop() >= obj.scrollHeight) {
			console.log('bottom');
			if(delta < 0) {
				console.log('to bottom!!');
				e.preventDefault();
				return false;
			}
		}
		if($(obj).scrollTop() === 0) {
			console.log('top');

			if(delta > 0) {
				console.log('to top!!');
				e.preventDefault();
				return false;
			}
		}
		return false;
	}
	function removeWheelEvent (e) {
		var state = $("#detailswindow").css("display");
		if (state !="none"){
			console.log('ssss');
			e.stopPropagation();
			e.preventDefault();
			e.cancelBubble = false;
			return false;
		}
	}



// 点赞按钮，点击变红
function mouseclickfun(IdUserIconlikeRed){
	$('#'+IdUserIconlikeRed).attr({
		class: 'want-user-iconlikered2'
	});
	event.stopPropagation();//防冒泡
}

// 点赞按钮，点击变黑
function mouseclickfun2(IdUserIconlikeRed){
	$('#'+IdUserIconlikeRed).attr({
		class: 'want-user-iconlikered'
	});
	event.stopPropagation();
}

// 覆盖再首页div上后触发的效果
function mouseoverfun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark){
	$('#'+IdGoodsLayer).attr({
		class: 'want-goods-layer2'
	});
	$('#'+IdGoodsText).attr({
		class: 'want-goods-text2'
	});
	$('#'+IdUserIconlike).attr({
		class: 'want-user-iconlike2'
	});
	$('#'+IdUserIconmark).attr({
		class: 'want-user-iconmark2'
	});
}

// 离开覆盖的div上后触发的效果
function mouseleavefun(IdGoodsLayer,IdGoodsText,IdUserIconlike,IdUserIconmark){
	$('#'+IdGoodsLayer).attr({
		class: 'want-goods-layer'
	});
	$('#'+IdGoodsText).attr({
		class: 'want-goods-text'
	});
	$('#'+IdUserIconlike).attr({
		class: 'want-user-iconlike'
	});
	$('#'+IdUserIconmark).attr({
		class: 'want-user-iconmark'
	});
}

	