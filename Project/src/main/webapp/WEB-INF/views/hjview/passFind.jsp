<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/hjresources/js/join.js"></script>
<link	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="../resources/hjresources/js/passFind.js"></script>
<link href="../resources/hjresources/css/loginCss.css" rel="stylesheet" />

<title>passFind.jsp</title>
</head>
<body>


	<div class="container">
		<form action="login.do" method="post" id="passFind"
			class="form-horizontal" role="form">
			<h2>비밀번호 찾기</h2>

			<div class="form-group">
				<label for="id" class="col-sm-3 control-label">아이디</label>
				<div class="col-sm-9">
					<input type="text" id="id" placeholder="아이디" class="form-control"
						name="id" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">이메일 </label>
				<div class="col-sm-9">
					<input type="email" id="email" placeholder="이메일"
						class="form-control" name="email">
				</div>

			</div>

			<div class="form-group float-right">
				<label id="info"></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="passFindBtn" class="btn btn-info">전송</button>
			</div>
		
		</form>
		<!-- /form -->
	</div>
	<!-- ./container -->

</body>
</html>

