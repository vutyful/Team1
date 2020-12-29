$(function() {



			var email = $('#email');
			var id = $('#id');
			
			var info= $('#info');

//유효성	

			var emailRule	 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var passRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

	
		
		$('#passFindBtn').click(function() {
			
			if(id.val()==''){
			info.text("아이디를 입력해 주세요.");
			return;
			}
			
			if(email.val() == ''){
				info.text("이메일을 입력해주세요.");
				email.focus();
				return;
			}
			if (!emailRule.test(email.val())){
				info.text("이메일 형식이 아닙니다.");
				return;
			}
	
	
		

		
		
		
  		$.ajax({
	 	type : 'post',
	 	
	 	async : true, //비동기 통신
	 	
	 	url : 'checkEmail.do', //*****요청(request) jsp는x mvc안타겠다는 얘기
	 	
	 	contentType : 'application/x-www-form-urlencoded;charset=utf-8', //한글처리
	 	
	 	data : {'id' : $('#id').val(),
	 				'email' : $('#email').val()
	 	},
	 	
	 	success : function(result){
	 	
	 	if(result=='성공'){
	 	alert("임시 비밀번호가 발급되었습니다. \n이메일을 확인하세요.")
		$('#passFind').submit();
	 	}
	 	
	 		info.text(result);
	 			 		
	 	},
	 	
	 	error : function(err){
	 		console.log(err);
	 	}
  
  		})	//ajax
		
		
  		
  		

		
		});
		
		
	});