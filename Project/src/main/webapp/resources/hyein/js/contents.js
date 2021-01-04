
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
    
    
    
    
    
    //파라미터 구하는 함수
	function getParam(sname) {
    var params = location.search.substr(location.search.indexOf("?") + 1);
    var sval = "";
    params = params.split("&");
    for (var i = 0; i < params.length; i++) 
    {
        temp = params[i].split("=");
        if ([temp[0]] == sname) { sval = temp[1]; }
    }
    return sval;
	}
	
	if(getParam("link")=='true')
	{
    	$('html, body').animate(
    	{
			scrollTop: $('#comments').offset().top
		}, 0);
	}
	
    
    //댓글 작성
  
  
  

    
    


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
	
    $.ajax({
        type : 'post',
        async :  'true',
        url : 'updateReply.do',
        contentType : 'application/x-www-form-urlencoded;charset=utf-8',
        data : {'rcontent' : $(this).prev().val(),
        		'replynum' : $(this).next().val()
        		},
        success : function (result){
           		
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
         			 	 }
      				  },
     			   error : function (err) {console.log(err);}
   				 });
			
			
		}else{
			return;
		}
	
	})
	

