<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no,  user-scalable=no">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"	src="../resources/hjresources/js/profile.js"></script>

<link rel="stylesheet" href="../resources/hjresources/css/main.css" />
<link rel="stylesheet" href="../resources/hjresources/css/noscript.css" />

<link	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script 	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"	rel="stylesheet" id="bootstrap-css">
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<!-- Bootstrap CSS -->
<link href="../resources/hjresources/css/profile/assets/fonts/style.css"	rel="stylesheet">


<title>profile</title>
</head>

<body class="is-preload">
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">
	  	<header>

			<div class="headMargin">
				<a href="../main/main_login.do"><img id="logo"
					src="../resources/hyein/img/logo.png" alt="logo" /></a>
				<div style="float: right">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-header" id="bookMarkLink">
							<span class="glyphicon glyphicon-bookmark">북마크</span>
						</button>
						<button type="button" class="btn btn-header" id="logOutLink">
							<span class="glyphicon glyphicon-log-out">로그아웃</span>
						</button>
					</div>
				</div>
			</div>



		</header>
		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="#intro" class="active">프로필 사진</a></li>
				<li><a href="#first">프로필 수정</a></li>
				<li><a href="#second">내가 쓴 댓글</a></li>

			</ul>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Introduction -->
			<section id="intro" class="main">
				<form action="uploadPic.do" method="post"	enctype="multipart/form-data" id="picForm">
					<div class="spotlight">
						<div class="content">
							<header class="major">
								<h2>프로필 사진</h2>
							</header>
							<p id="picInfo"></p>
							<ul class="actions">
								<li><div class="filebox">
										<label for="picFile">업로드</label> <input type="file"
											name="file" id="picFile">
									</div></li>
							</ul>
						</div>
						<span class="image"><img
								src="../resources/upload/${member.pic}" alt="profile" /></span>
					</div>
				</form>
					<!-- /.form-group -->
					<footer class="major">
						<ul class="actions special">
							<button type="submit" id="picBtn" class="btn btn-primary btn-block">확인</button>
						</ul>
					</footer>

			</section>

			<!-- First Section -->
			<section id="first" class="main special">
				<header class="major">
					<h2>프로필 수정</h2>
					<p id="profileInfo">수정 할 정보를 입력해 주세요.</p>
				</header>
				<ul class="features">
					<div class="container">
						<form action="profileEdit.do" method="post" id="proEditForm"  class="form-horizontal" role="form">
							<div class="form-group">
								<label for="name" class="col-sm-3 control-label">이름(별명)</label>
								<div class="col-sm-9">
									<input type="text" id="name" placeholder="이름(별명)"
										class="form-control" autofocus name="name" value="${member.name}">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-3 control-label">이메일 </label>
								<div class="col-sm-9">
									<input type="email" id="email" placeholder="이메일"
										class="form-control" name="email" value="${member.email}">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">현재 비밀번호</label>
								<div class="col-sm-9">
									<input type="password" id="pass" placeholder="현재 비밀번호"
										class="form-control" name="pass">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">새 비밀번호</label>
								<div class="col-sm-9">
									<input type="password" id="newPass" placeholder="비밀번호 새로 설정시에만 입력"
										class="form-control" name="newPass">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">비밀번호 확인</label>
								<div class="col-sm-9">
									<input type="password" id="passConfirm" placeholder="비밀번호 새로 설정시에만 입력"
										class="form-control">
								</div>
							</div>
							
							<div class="form-group"  >
								<label for="birthDate" class="col-sm-3 control-label">생년월일</label>
								<div class="col-sm-9">
									<input type="date" id="birthDate" class="form-control" name="birth" value="${member.birth}">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3">성별</label>
								<div class="col-sm-6">
									<div class="form-group">
										<div class="col-md-4">
											<input type="hidden" id="userGender" value="${member.gender}">
											<select id="gender" name="gender" class="form-control"
												style="height: auto" >
												<option value="여">여자</option>
												<option value="남">남자</option>
												<option value ="외">그 외</option>
											</select>
										</div>
									</div>
								</div>
							</div>
						</form>
						<!-- /form -->
							<!-- /.form-group -->
							<footer class="major">
								<ul class="actions special">
									<button type="submit" id="proEditBtn" class="btn btn-primary btn-block">확인</button>
								</ul>
							</footer>
					</div>
					<!-- ./container -->
				</ul>


			</section>

			<!-- Second Section -->
			<section id="second" class="main special">
				<header  class="major">
					<h2>내가 쓴 댓글</h2>
				</header>

							<div class="card " >
								<div class="card-body p-0">
									<div class="table-responsive">
										<table class="table" >
											<thead class="bg-light">
												<tr class="border-0">
													<th class="border-0">#</th>
													<th class="border-0"> 컨 텐 츠  이 미 지 </th>
													<th class="border-0"> 제 목 </th>
													<th class="border-0"> 댓 글  날 짜  </th>
													<th class="border-0"> 댓 글  내 용  </th>
													<th class="border-0"> 추 천 수  </th>
												</tr>
											</thead>
											<tbody>
										<c:forEach items="${replyList}" var="map">
												<!-- 프라퍼티이름 변경 -->
												<tr>
												<td>${map.RNUM}</td>
												<td>
													<div class="m-r-10">
												<a href="/Project/main/contents_login.do?	connum=${map.CONNUM}">
													<img src="../resources/upload/${map.IMG}" alt="user" class="rounded" width="45">
												</a>
													</div>
												</td>
													<td>${map.TITLE}</td>
													<td >${map.REDATE}</td>
													<td>${map.RCONTENT}</td>
													<td>${map.RRECO}</td>
												</tr>
											</c:forEach>
											</tbody>
									</table>
									</div>
								</div>
							</div>

		
					<table  class="table" >
					<tr>
						<td><c:choose>
								<c:when test="${firstPage gt 1}">
									<a href="profile.do?page=${firstPage-1}&loca=reply"><span>이전페이지</span></a>
								</c:when>
								<c:otherwise>
									<span>이전페이지</span>
								</c:otherwise>
							</c:choose></td>
						<td><c:forEach var="i" begin="${firstPage}" end="${lastPage}">
								<a href="profile.do?page=${i}&loca=reply"><span><c:out
											value="[${i}]" /></span></a>
							</c:forEach></td>
						<td><c:choose>
								<c:when test="${lastPage lt pageTotalCount}">
									<a href="profile.do?page=${lastPage+1}&loca=reply"><span>다음페이지</span></a>
								</c:when>
								<c:otherwise>
									<span>다음페이지</span>
								</c:otherwise>
							</c:choose></td>
					</tr>
					</table>
	

			</section>

			<footer class="major">
			</footer>

			<!-- Get Started -->
			<section id="cta" class="main special">
				<header class="major">
					<h2>회원 탈퇴</h2>
					<p id="leaveInfo">탈퇴 시 모든 정보가 사라지며 복구가 어렵습니다.</p>

				</header>

				<ul class="features">
					<div class="container">
						<form action="leave.do" id="leaveForm" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="id" class="col-sm-3 control-label">아이디</label>
								<div class="col-sm-9">
									<input type="text" id="idLeave" placeholder="아이디"
										class="form-control" name="id" autofocus>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">비밀번호</label>
								<div class="col-sm-9">
								<input type="password" id="password" placeholder="비밀번호"
										class="form-control" name="pass">
								</div>
							</div>
							
							<div class="form-group" id="confirmNumDiv" style="display: none">
								<label for="confirmNum" class="col-sm-3 control-label">인증번호</label>
								<div class="col-sm-9">
									<input type="text" id="confirmNum" placeholder="인증번호"
										class="form-control">
								</div>
							</div>
						</form>
						<!-- /form -->
							<footer class="major">
								<ul class="actions special">
									<button type="submit" class="btn btn-primary btn-block" id="leaveBtn">확인</button>
								</ul>
							</footer>
					</div>
					<!-- ./container -->
				</ul>
			</section>


		<!-- Footer -->

		<footer id="footer"> </footer>

	</div>
	</div>

	<!-- Scripts -->
	<script src="../resources/hjresources/js/jquery.min.js"></script>
	<script src="../resources/hjresources/js/jquery.scrollex.min.js"></script>
	<script src="../resources/hjresources/js/jquery.scrolly.min.js"></script>
	<script src="../resources/hjresources/js/browser.min.js"></script>
	<script src="../resources/hjresources/js/breakpoints.min.js"></script>
	<script src="../resources/hjresources/js/util.js"></script>
	<script src="../resources/hjresources/js/main.js"></script>
	<script src="../resources/hjresources/js/jquery-3.3.1.min.js"></script>
	<script src="../resources/hjresources/js/bootstrap.bundle.js"></script>

</body>
</html>
