$(function() {

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





		$('#joinBtn').click(function() {
			
			var name = $('#name');
			var email = $('#email');
			var id = $('#id');
			var password = $('#password');
			var passwordConfirm = $('#passwordConfirm');
			var birthDate = $('#birthDate');
			
			var Length = 0; 
			var engCheck = /[a-z]/; 
			var korCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var numCheck = /[0-9]/; 
			var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

			

			if(name.val() == ''){
				$('#info').text("이름을 입력해주세요.");
				name.focus();
				return;
			}
			if (name.val().search(/\s/) != -1) {
				$('#info').text("이름은 빈칸을 포함 할 수 없습니다.");
				return;
			}
			if(getTextLength(name.val())>20){
				$('#info').text("이름은 한글 1~10자, 영문 및 숫자 2~20자 입니다.");
				return;
			}
			if (specialCheck.test(name.val())){
				$('#info').text("이름 특수문자를 포함 할 수 없습니다.");
				return;
			}

			
			
			
			
			if(email.val() == ''){
				$('#info').text("이메일을 입력해주세요.");
				email.focus();
				return;
			}
			if (email.val().search(/\s/) != -1) {
				$('#info').text("이메일은 빈칸을 포함 할 수 없습니다.");
				return;
			}
			if(getTextLength(email.val())>30){
				$('#info').text("이메일이 너무 깁니다.");
				return;
			}
			
			
			
			
			if(id.val() == ''){
				$('#info').text("아이디를 입력해주세요.");
				id.focus();
				return;
			}
				if (id.val().search(/\s/) != -1) {
				$('#info').text("아이디는 빈칸을 포함 할 수 없습니다.");
				return;
			}
			if(getTextLength(id.val())>20){
				$('#info').text("아이디는 영문 및 숫자 2~20자 입니다.");
				return;
			}
			if (specialCheck.test(id.val())){
				$('#info').text("아이디는 특수문자를 포함 할 수 없습니다.");
				return;
			}
			if (korCheck.test(id.val())){
				$('#info').text("아이디는 한글을 포함 할 수 없습니다.");
				return;
			}
			
			
			
			
			if(password.val() == ''){
				$('#info').text("비밀번호를 입력해주세요.");
				password.focus();
				return;
			}
				if (password.val().search(/\s/) != -1) {
				$('#info').text("비밀번호는 빈칸을 포함 할 수 없습니다.");
				return;
			}
			if(getTextLength(password.val())>20){
				$('#info').text("비밀번호는 영문 및 숫자 2~20자 입니다.");
				return;
			}
			
			
			if(passwordConfirm.val() == ''){
				$('#info').text("비밀번호 확인을 입력해주세요.");
				passwordConfirm.focus();
				return;
			}
			
			
			if(password.val() != passwordConfirm.val()){
				$('#info').text("비밀번호가 일치하지 않습니다.");
				password.val('');
				passwordConfirm.val('');
				password.focus();
				return;
			}
			
			if(birthDate.val() == ''){
				$('#info').text("생일 선택해주세요.");
				return;
			}
			
			$('#join').submit();
		});
	});