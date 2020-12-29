$(function() {



			var email = $('#email');
			var id = $('#id');
			
			var pass = $('#pass');
			
			var info= $('#info');

//유효성	

			var Length = 0; 
			var engCheck = /[a-z]/; 
			var korCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var numCheck = /[0-9]/; 
			var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
			var emailRule	 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var passRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;


	//escape 16진수로 바꿔줌 한글은 길이6
	//바이트 구하는 함수
	var getTextLength = function(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
    if (escape(str.charAt(i)).length == 6) {
   	 len++;
      }
 	  	len++;
   	 }
    return len;
	}
	

			
	
	
	
	//프로필 수정
		
		$('#passFindBtn').click(function() {
			
		
			if(email.val() == ''){
				profileInfo.text("이메일을 입력해주세요.");
				email.focus();
				return;
			}
			if (!emailRule.test(email.val())){
				profileInfo.text("이메일 형식이 아닙니다.");
				return;
			}
			
			
		
		if(pass.val()==''){
		profileInfo.text("비밀번호를 입력해 주세요.");
		return;
		}
	
	
		
		if(idLeave.val()==''){
		leaveInfo.text("아이디를 입력해 주세요.");
		return;
		}
		if(password.val()==''){
		leaveInfo.text("비밀번호를 입력해 주세요.");
		return;
		}
		
		
  		$.ajax({
	 	type : 'post',
	 	
	 	async : true, //비동기 통신
	 	
	 	url : 'leaveCheck.do', //*****요청(request) jsp는x mvc안타겠다는 얘기
	 	
	 	contentType : 'application/x-www-form-urlencoded;charset=utf-8', //한글처리
	 	
	 	data : {'id' : $('#id').val(),
	 				'pass' : $('#pass').val(),
	 				'email' : $('#email').val()
	 	},
	 	
	 	success : function(result){
	 	
	 		info.text(result);
	 		
	 		if(info.text() == '이메일을 확인해주세요.' &&
	 		info.text()=='확인'
	 		) {
		//인증번호칸 보이기
		    $('#confirmNumDiv').show();
  		//버튼 전송->확인
    		$('#passFindBtn').text('확인');
  			}
  			
 		if(result=='탈퇴'){
  		$('#pasFind').submit();
		}
		
	 	},
	 	
	 	error : function(err){
	 		console.log(err);
	 	}
  
  		})	//ajax
		
		
  		
  		

		
		});
		
		
	});