
   // 4. bxslider 효과 주기
    $('#contents_slider>ul').css('left-padding','30px');
    $('#contents_slider>ul').bxSlider({
        minSlides : 5,
        maxSlides : 5,
        slideMargin: 10,
        slideWidth :150,
        auto : true,
        moveSlides: 5,
        speed : 100,
        pager : false
    });
    
    //댓글 작성
  $('#write_comment').click(function(){
    alert("글쓰기 클릭");
    $.ajax({
        type: 'post',
        async : true,
        url : 'insertReply.do',
        contentType : 'application/x-www-form-urlencoded;charset=utf-8',
        data : {'rcontent':$('#ta_comment').val(),
            'connum':$('#connum').val()
        },//보내는 데이터
        success : function(result){
            $('#ta_comment').val('');
            alert('댓글 작성이 완료되었습니다.');
            //기존 댓글 리스트 없애기
            $('.foreach').css('display','none');
                    test(result);
            $('.aja').css('display','inline-block');
            },
        error : function(err){console.log(err);}
    })

    function test(result)
    {
        let html = "<div id=\'ajax_list\'>";
        $.each(result,function (index,item){
        html = "<div class=\'comment_text best_comment replys aja\' style='display:none'>";
        html+="<dl  class=\'cmt_item\'><dt>";
        html+="<span><img id=\'profile_pic\' class=\'profile_reply box_reply\' src=\'../resources/upload/" + item[index].memberVO.pic + "\'/></span>";
        html+="<span id=\'reply_id\' title=\'아이디\'>" +  item[index].memberVO.id + "</span>";
        html+="<i id=\'reply_date\'>" + item[index].redate + "</i>";
        html+="</dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\'comment_option\'><span class=\'reply_reco\'>" + item[index].rreco + "</span>&nbsp;&nbsp;&nbsp;";
        html+="<span><c:choose><c:when test=\'${fn:contains(myLike," + item[index].replynum + ")}\'>";
        html+="<img class=\'reply_reco_icon\' src=\'../resources/hyein/img/works/like_ok.png\'/></c:when>";
        html+="<c:otherwise><img class=\'reply_reco_icon\' src=\'../resources/hyein/img/works/like_no.png\'/></c:otherwise></c:choose></span>";
        html+="<c:if test=\'${sessionScope.login eq "+ item[index].memberVO.id + "}\'>";
        html+="<span class=\'reply_modify\'><span>수정</span></span>";
        html+="<span class=\'reply_delete\'><span>삭제</span></span></c:if></span>";
        html+="<dd><span><textarea class=\'ta_comment ta_modify\'>" + item[index].rcontent + "</textarea>";
        html+="<input class=\'modify_btn\' type=\'button\' value=\'등록\'/>";
        html+="<input class=\'replynum\' type=\'hidden\' value=\'" + item[index].replynum + "\'/>";
        html+="<p class=\'rcontent\'>&nbsp;&nbsp;" + item[index].rcontent + "</p></span></dd></dl></div>";
        });
        html+="</div>";

        $('#ajaxReplyList').html(html);
        $('.aja').css('display','inline-block');
    }

});
//--------------------------------------------------------------
				
	// 댓글 추천 (hover)			
	$('.reply_reco_icon').css('cursor','pointer');
	
	$('.reply_reco_icon').each(function(){
  $(this).click(function(){
      var like;
        $.ajax({
            type: 'post',
            async : false,
            url : 'updateReco.do',
            contentType : 'application/x-www-form-urlencoded;charset=utf-8',
            data : {'replynum':$(this).parent().parent().next().find('.replynum').val()
            },// 해당 댓글번호 보내기
            success : function(result){
                like = result;
            },
            error : function(err){console.log(err);}
        });
            //
            // if(result === 'ok') {
            //     $(this).attr('src', $(this).attr('src').replace('no', 'ok'));
            // }else{
            //     $(this).attr('src',$(this).attr('src').replace('ok','no'));
            // }

        // 하트 모양 바꿔주기

        if(like === 'ok') {
            $(this).attr('src', $(this).attr('src').replace('no', 'ok'));
        }else{
            $(this).attr('src',$(this).attr('src').replace('ok','no'));
        }

        //댓글 추천 수 실시간 반영
        var reco;
        $.ajax({
            type: 'post',
            async : false,
            url : 'getReco.do',
            contentType : 'application/x-www-form-urlencoded;charset=utf-8',
            data : {'replynum':$('.replynum').val()
            },// 해당 댓글번호 보내기
            success : function(result){
                reco = result;
            },
            error : function(err){console.log(err);}
        });
        // function resultFunc(result){
        //     $(this).parent().prev().text(reco);
        // }
        $(this).parent().prev().text(reco);

 })
});
					
	
//--------------------------------------------------------------				
			
		//수정 ta/btn 숨기기(default)	
		$('.ta_comment').css('display','none');
		$('.modify_btn').css('display','none');
				
				
	//수정 태그 활성화(toggle)
	
        var reply_modifys = $('.reply_modify>span');

        reply_modifys.hover(function () {
            $(this).css('cursor', 'pointer');
            $(this).css('color', '#66AEE7');
        }, function () {
            $(this).css('cursor', 'none');
            $(this).css('color', 'black');
        });

	reply_modifys.click(function () {
	
		if( $(this).attr('class') == 'on' ){
			$(this).removeClass('on');
            $(this).parent().parent().next().find('textarea').css('display','none');
            $(this).parent().parent().next().find('input').css('display','none');
            $(this).parent().parent().next().find('p').css('display','inline-block');
            
		}else{ 
			$(this).addClass('on');
            $(this).parent().parent().next().find('textarea').css('display','inline-block');
            $(this).parent().parent().next().find('input').css('display','inline-block');
            $(this).parent().parent().next().find('p').css('display','none');
            }
        });
        
     //댓글 수정 시 등록 버튼 눌렸을 때
     
 	var modify_btns = $('.modify_btn'); //등록버튼 

	modify_btns.click(function (){
		var moidfy_comment = $(this).prev().val(); //수정한 내용
		alert(moidfy_comment);
	
    $.ajax({
        type : 'post',
        async :  'true',
        url : 'updateReply.do',
        contentType : 'application/x-www-form-urlencoded;charset=utf-8',
        data : {'rcontent' : $(this).prev().val(),
        		'replynum' : $(this).next().val()
        		},
        success : function (result){
				alert(result);
           		
        },
        error : function (err) {console.log(err);}
    });
    		//DB 연동 후 다시 수정 등록 form 없애기
        	$(this).siblings('p').text(moidfy_comment);       	
        	$(this).parents('dd').prev().children('span.reply_modify').removeClass('on');
			$(this).siblings('textarea').css('display','none');
        	$(this).css('display','none');
        	$(this).siblings('p').css('display','inline-block');
            	
})

	// 댓글 삭제 버튼 눌렸을 때
	var reply_deletes = $('.reply_delete'); //삭제 버튼들
	
	  reply_deletes.hover(function () {
            $(this).css('cursor', 'pointer');
            $(this).css('color', '#66AEE7');
        }, function () {
            $(this).css('cursor', 'none');
            $(this).css('color', 'black');
        });
	
	
	reply_deletes.click(function(){
		if(confirm("정말 삭제하시겠습니까?") == true){
			 $.ajax({
       			 type : 'post',
       			 async :  'true',
       			 url : 'deleteReply.do',
       			 contentType : 'application/x-www-form-urlencoded;charset=utf-8',
       			 data : {'replynum' : $('.replynum').val()},
       			 success : function (result){
						alert(result);
       			 },
       			 error : function (err) {console.log(err);}
   			});
   			
   			$(this).parents('.comment_text best_comment replys').remove();
   			
			 $.ajax({
      			  	type : 'post',
        			async :  'true',
        			url : 'getAllreply.do',
       			 	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
       				 data : {'connum' : $('.connum').val()},
       				 dataType : JSON,
       				 success : function (rep){
          				 for(var i=0;i<rep.length;i++){
              			 alert(rep[0].title);
         			 	 }
      				  },
     			   error : function (err) {console.log(err);}
   				 });
			
			
		}else{
			return;
		}
	
	})
	

