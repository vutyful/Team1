<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="../resources/hjresources/css/loginCss.css" rel="stylesheet" />
<title>leave.jsp</title>
</head>
<body>

	<div class="container">
	  <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		<form action="bye.do" class="form-horizontal" id="bye">
			<h2>다음에 또 만나요!</h2>
			<br/><br/>
			<fieldset>
				<!-- Select Basic -->



				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label"
						for="Pleaseselectthetypeofleave.">탈퇴하려는 이유를 알려주세요.</label>
					<div class="col-md-4">
						<select id="Pleaseselectthetypeofleave."
							name="Pleaseselectthetypeofleave." class="form-control">
							<option value="0" selected disabled>-------------선택------------</option>
							<option value="1">비슷한 다른 플랫폼을 이용중입니다.</option>
							<option value="2">더 이상 서비스를 이용하지 않습니다.</option>
							<option value="3">개인정보 문제로 탈퇴합니다.</option>
							<option value="4">이용하는데 불편합니다.</option>
							<option value="4">기타</option>
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
						<p>	<br/>그 동안 이용해 주셔서 감사합니다.</p>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button type="submit" id="bye"  class="btn btn-info">확인</button>
					</div>

				</div>

			</fieldset>
		</form>
	</div>
	<!-- ./container -->
</body>
</html>