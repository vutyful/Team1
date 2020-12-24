$(function() {

			var picFile = $('#picFile');

		$('#picBtn').click(function() {
			
			if(picFile.val() == null || picFile.val() ==''){
				alert("변경사항이 없습니다.");
				return;
			}
			
			$('#picForm').submit();
		});
		
		
		
		$('#proEditBtn').click(function() {
			
			
			
			$('#proEditForm').submit();
		});
		
		
		
		
		//탈퇴
			var id = $('#id');
			var password = $('#password');
			var leaveInfo= $('#leaveInfo');
			

		
		$('#leaveBtn').click(function() {
		
		
		if(id.val()==''){
			leaveInfo.text("아이디를 입력해 주세요.");
			return;
		}

		
  		$.ajax({
	 	type : 'post',
	 	
	 	async : true, //비동기 통신
	 	
	 	url : 'leave.do', //*****요청(request) jsp는x mvc안타겠다는 얘기
	 	
	 	contentType : 'application/x-www-form-urlencoded;charset=utf-8', //한글처리
	 	
	 	data : {'id' : $('#id').val(),
	 				'pass' : $('#password').val(),
	 				'confirmNum' : $('#confirmNum').val()
	 	},
	 	
	 	success : function(result){
	 		leaveInfo.text(result);
	 		
	 		if(leaveInfo.text() == '이메일을 확인해주세요.' &&
	 		$('#leaveBtn').text()=='확인'
	 		) {
		//인증번호칸 보이기
		    $('#confirmNumDiv').show();
  		//버튼 확인->탈퇴
    		$('#leaveBtn').text('탈퇴');
  			}
  			
 
  			
	 		return;
	 	},
	 	
	 	error : function(err){
	 		console.log(err);
	 	}
  
  		})	
		
		
  		
  		
		//$('#leaveForm').submit();
		
		});
		
		
	});