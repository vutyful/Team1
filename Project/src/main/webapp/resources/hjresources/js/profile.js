$(function() {

//파라미터 구하는 함수
	function getParam(sname) {
    var params = location.search.substr(location.search.indexOf("?") + 1);
    var sval = "";
    params = params.split("&");
    for (var i = 0; i < params.length; i++) {
        temp = params[i].split("=");
        if ([temp[0]] == sname) { sval = temp[1]; }
    }
    return sval;
}


//댓글 페이지 클릭 후 위치 내 댓글 고정	
	if(getParam("loca")=='profile'){
	$('html, body').animate({
	scrollTop: $('#first').offset().top
	}, 0);
	}
//프로필 수정 후 위치 프로필 수정 고정
	if(getParam("loca")=='reply'){
	$('html, body').animate({
	scrollTop: $('#second').offset().top
	}, 0);
	}
	
	
	
	//북마크
	$('#bookMarkLink').click(function(){
		location.href='/Project/main/bookmark.do'
	})
	//로그아웃
		$('#logOutLink').click(function(){
		location.href='/Project/main/logout.do'
	})
	
	

	
		

		//프로필 사진 바꾸기

			var picFile = $('#picFile');
			
		$('#picBtn').click(function() {
			
			//파일 업로드 없을 때
			if(picFile.val() == null || picFile.val() ==''){
				alert("프로필 사진을 업로드해 주세요. \n(사진 로딩에는 시간이 걸립니다.)")
				location.reload();
			}else{
				$('#picForm').submit();
			}
			

		});
		
		

			
			
	//수정

	//사용자 성별  기본 selected
	$('#gender').val($.trim($('#userGender').val()));

			var name = $('#name');
			var email = $('#email');
			var id = $('#id');
			
			var pass = $('#pass');
			var newPass = $('#newPass');
			var passConfirm = $('#passConfirm');
			var birthDate = $('#birthDate');
			
			var profileInfo= $('#profileInfo');

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
		
		$('#proEditBtn').click(function() {
		
			if(name.val() == ''){
				profileInfo.text("이름을 입력해주세요.");
				name.focus();
				return;
			}
			if (name.val().search(/\s/) != -1) {
				profileInfo.text("이름은 빈칸을 포함 할 수 없습니다.");
				return;
			}
			if(getTextLength(name.val())>20){
				profileInfo.text("이름은 한글 1~10자, 영문 및 숫자 2~20자 입니다.");
				return;
			}
			if (specialCheck.test(name.val())){
				profileInfo.text("이름 특수문자를 포함 할 수 없습니다.");
				return;
			}
		
		
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
	
		
	//새 비밀번호
	//칸이 비어있지 않을 때만
			if(newPass.val()!=''){

			if (!passRule.test(newPass.val())){
				profileInfo.text("비밀번호는 영문자, 특수문자, 숫자 포함 형태의 8~15자리 이내로 설정하셔야 합니다.");
				return;
			}
			
				if(passConfirm.val() == ''){
				profileInfo.text("비밀번호 확인을 입력해주세요.");
				passConfirm.focus();
				return;
			}
			
				if(newPass.val() != passConfirm.val()){
				profileInfo.text("비밀번호가 일치하지 않습니다.");
				newPass.val('');
				passConfirm.val('');
				newPass.focus();
				return;
			}
			
			
			}//end of if
			

			
		if(birthDate.val()==''){
		profileInfo.text("생일을 입력해 주세요.");
		return;
		}
		
		
		//중복 확인(닉네임, 이메일)
		$.ajax({
	 	type : 'post',
	 	
	 	async : true, //비동기 통신
	 	
	 	url : 'checkProfile.do', //*****요청(request) jsp는x mvc안타겠다는 얘기
	 	
	 	contentType : 'application/x-www-form-urlencoded;charset=utf-8', //한글처리
	 	
	 	data : {'name' : $('#name').val(),
	 				'email' : $('#email').val(),
	 				'pass' : $('#pass').val(),
	 				'birth' : $('#birth').val(),
	 				'gender' : $('#gender').val(),
	 				'newPass' : $('#newPass').val()
	 	},
	 	
	 	success : function(result){
	 		profileInfo.text(result);
	 		if(result=='성공'){
	 		$('#proEditForm').submit();
	 		}
	 	},
	 	
	 	error : function(err){
	 		console.log(err);
	 	}
	 	
	 }) //end of ajax 
			

		});
		
		
		
		
		
		

			

		

			//탈퇴
		var idLeave = $('#idLeave');
		var password = $('#password');
		var leaveInfo= $('#leaveInfo');

					
		$('#leaveBtn').click(function() {

		
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
	 	
	 	data : {'id' : $('#idLeave').val(),
	 				'pass' : $('#password').val(),
	 				'confirmNum' : $('#confirmNum').val()
	 	},
	 	
	 	success : function(result){
	 	
	 		leaveInfo.text(result);
	 		
	 		if(leaveInfo.text() == '이메일을 확인해주세요.' &&
	 		$('#leaveBtn').text()=='확인'
	 		) {
	 		alert("이메일이 전송되었습니다. \n확인 후, 인증번호를 입력해 주세요.");
		//인증번호칸 보이기
		    $('#confirmNumDiv').show();
  		//버튼 확인->탈퇴
    		$('#leaveBtn').text('탈퇴');
  			}
  			
 		if(result=='탈퇴'){
 		alert("탈퇴 되었습니다.")
  		$('#leaveForm').submit();
		}
		
	 	},
	 	
	 	error : function(err){
	 		console.log(err);
	 	}
  
  		})	
		
		
  		
  		

		
		});
		
		
	});
	
	


	