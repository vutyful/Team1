<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no,  user-scalable=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../resources/hjresources/js/profile.js"></script>

<link rel="stylesheet" href="../resources/hjresources/css/main.css" />
<link rel="stylesheet" href="../resources/hjresources/css/noscript.css" />

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>

<!-- Bootstrap CSS -->
<link href="../resources/hjresources/css/profile/assets/fonts/style.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../resources/hjresources/css/profile/libs/style.css">

<title>profile</title>
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt"> </header>

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
							<p>프로필 사진 변경 가능</p>
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
				</header>
				<ul class="features">
					<div class="container">
						<form action="profileEdit.do" id="proEditForm" class="form-horizontal" role="form">
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
								<label for="password" class="col-sm-3 control-label">현재
									비밀번호</label>
								<div class="col-sm-9">
									<input type="password" id="exPass" placeholder="현재 비밀번호"
										class="form-control" name="exPass">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">새
									비밀번호</label>
								<div class="col-sm-9">
									<input type="password" id="pass" placeholder="비밀번호 새로 설정시에만 입력"
										class="form-control" name="pass">
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="col-sm-3 control-label">비밀번호
									확인</label>
								<div class="col-sm-9">
									<input type="password" id="passConfirm" placeholder="비밀번호 새로 설정시에만 입력"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
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
											<select id="gender" name="gender" class="form-control"
												style="height: auto" >
												<option value="여">여자</option>
												<option value="남">남자</option>
												<option value="외">그 외</option>
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
				<header class="major">
					<h2>내가 쓴 댓글</h2>
					<div class="row">

						<div>
							<div class="card">
								<div class="card-body p-0">
									<div class="table-responsive">
										<table class="table">
											<thead class="bg-light">
												<tr class="border-0">
													<th class="border-0">#</th>
													<th class="border-0">Image</th>
													<th class="border-0">Product Name</th>
													<th class="border-0">Product Id</th>
													<th class="border-0">Quantity</th>
													<th class="border-0">Price</th>
													<th class="border-0">Order Time</th>
													<th class="border-0">Customer</th>
													<th class="border-0">Status</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>
														<div class="m-r-10">
															<img src="assets/images/product-pic.jpg" alt="user"
																class="rounded" width="45">
														</div>
													</td>
													<td>Product #1</td>
													<td>id000001</td>
													<td>20</td>
													<td>$80.00</td>
													<td>27-08-2018 01:22:12</td>
													<td>Patricia J. King</td>
													<td><span class="badge-dot badge-brand mr-1"></span>InTransit
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>
														<div class="m-r-10">
															<img src="assets/images/product-pic-2.jpg" alt="user"
																class="rounded" width="45">
														</div>
													</td>
													<td>Product #2</td>
													<td>id000002</td>
													<td>12</td>
													<td>$180.00</td>
													<td>25-08-2018 21:12:56</td>
													<td>Rachel J. Wicker</td>
													<td><span class="badge-dot badge-success mr-1"></span>Delivered
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>
														<div class="m-r-10">
															<img src="assets/images/product-pic-3.jpg" alt="user"
																class="rounded" width="45">
														</div>
													</td>
													<td>Product #3</td>
													<td>id000003</td>
													<td>23</td>
													<td>$820.00</td>
													<td>24-08-2018 14:12:77</td>
													<td>Michael K. Ledford</td>
													<td><span class="badge-dot badge-success mr-1"></span>Delivered
													</td>
												</tr>
												<tr>
													<td>4</td>
													<td>
														<div class="m-r-10">
															<img src="assets/images/product-pic-4.jpg" alt="user"
																class="rounded" width="45">
														</div>
													</td>
													<td>Product #4</td>
													<td>id000004</td>
													<td>34</td>
													<td>$340.00</td>
													<td>23-08-2018 09:12:35</td>
													<td>Michael K. Ledford</td>
													<td><span class="badge-dot badge-success mr-1"></span>Delivered
													</td>
												</tr>
												<tr>
													<td colspan="9"><a href="#"
														class="btn btn-outline-light float-right">View Details</a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>

				</header>

			</section>

			<!-- Get Started -->
			<section id="cta" class="main special">
				<header class="major">
					<h2>회원 탈퇴</h2>
					<p id="leaveInfo">탈퇴 시 모든 정보가 사라지며 복구가 어렵습니다.</p>

				</header>

				<ul class="features">
					<div class="container">
						<form action="leaveOK.do" id="leaveForm" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="id" class="col-sm-3 control-label">아이디</label>
								<div class="col-sm-9">
									<input type="text" id="id" placeholder="아이디"
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

		</div>

		<!-- Footer -->

		<footer id="footer"> </footer>

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
