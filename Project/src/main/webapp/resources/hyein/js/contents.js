
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
							alert(result);
						},
						error : function(err){console.log(err);}
					})
				});
				
	// 댓글 추천 hover			
	$('.reply_reco').click(function(){
   		alert("댓글 추천!");
					$.ajax({
						type: 'post',
						async : true, 
						url : 'updateReco.do',
						contentType : 'application/x-www-form-urlencoded;charset=utf-8',
						data : {'rcontent':$('#ta_comment').val(),
								'connum':$('#connum').val()
								},//보내는 데이터
						success : function(result){
							$('#ta_comment').val('');
							alert(result);
						},
						error : function(err){console.log(err);}
					})
				});
			
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
        
     //수정 등록 버튼 눌렸을 때
     
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

