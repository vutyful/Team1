<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>leave.jsp</title>
</head>
<body>

	<div class="container">
		<form class="form-horizontal">
			<h2>회원 탈퇴</h2>
			<fieldset>
				<!-- Select Basic -->



				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label"
						for="Pleaseselectthetypeofleave.">탈퇴하려는 이유를 알려주세요.</label>
					<div class="col-md-4">
						<select id="Pleaseselectthetypeofleave."
							name="Pleaseselectthetypeofleave." class="form-control">
							<option value="1">이유1</option>
							<option value="2">이유2</option>
							<option value="3">이유3</option>
							<option value="4">이유4</option>
						</select>
					</div>
				</div>



				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="ReasonforLeave">자세한
						이유를 적어주세요.</label>
					<div class="col-md-4">
						<textarea class="form-control" id="ReasonforLeave"
							name="ReasonforLeave"></textarea>	
						<p>	<br/>모든 북마크와 댓글을 포함한 모든 정보가 사라집니다.<br /> 정말 탈퇴하시겠습니까?</p>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">탈퇴하기</button>
					</div>

				</div>

			</fieldset>
		</form>
	</div>
	<!-- ./container -->
</body>
</html>