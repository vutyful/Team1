$(function() {
		$('#joinBtn').click(function() {
			
			var name = $('#name');
			var email = $('#email');
			var id = $('#id');
			var password = $('#password');
			var passwordConfirm = $('#passwordConfirm');
			var birthDate = $('#birthDate');
			
			var Length = 0; 
			var engCheck = /[a-z]/; 
			var numCheck = /[0-9]/; 
			var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

			

			if(name.val() == ''){
				$('#info').text("이름을 입력해주세요.");
				name.focus();
				return;
			}
			if(email.val() == ''){
				$('#info').text("이메일을 입력해주세요.");
				email.focus();
				return;
			}
			if(id.val() == ''){
				$('#info').text("아이디를 입력해주세요.");
				id.focus();
				return;
			}
			if(password.val() == ''){
				$('#info').text("비밀번호를 입력해주세요.");
				password.focus();
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