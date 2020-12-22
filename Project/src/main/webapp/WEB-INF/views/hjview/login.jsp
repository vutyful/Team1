<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../resources/hjresources/js/login.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="../resources/hjresources/css/loginCss.css" rel="stylesheet" />
<title>login.jsp</title>
</head>
<body>
<body>
	<div>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
					
						<form method="get" action="userLogin.do" id="login" class="form">
							<h3 class="text-center text-info">로그인</h3>
							<div class="form-group">
								<label for="id" class="text-info">아이디:</label><br> <input
									type="text" name="id" id="id" class="form-control">
							</div>
							<div class="form-group">
								<label for="pass" class="text-info">비밀번호:</label><br> <input
									type="password" name="pass" id="pass" class="form-control">
							</div>

							<div class="form-group">
								<label for="remember-id" class="text-info"><span>아이디 기억하기</span> <span>
								<input id="remember-id" name="remember-id" type="checkbox" value="Y"></span></label><br>
							<input type="hidden" id="chk" name="remember-id" value="N">
							</div>

							<div class="form-group">
								<button type="button" id="loginBtn" class="btn btn-info btn-md">로그인</button>
							</div>

							<div id="joinLink" class="text-right">
								<a href="join.do" class="text-info">가입하기</a>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>



</body>
</html>