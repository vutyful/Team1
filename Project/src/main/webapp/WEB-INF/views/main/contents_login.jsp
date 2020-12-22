<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>컨텐츠(게시글)</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<!-- Fonts-->
		<link rel="stylesheet" type="text/css" href="../resources/hyein/fonts/fontawesome/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="../resources/hyein/fonts/pe-icon/pe-icon.css">
		<!-- Vendors-->
		<link rel="stylesheet" type="text/css" href="../resources/hyein/vendors/bootstrap/grid.css">
		<link rel="stylesheet" type="text/css" href="../resources/hyein/vendors/magnific-popup/magnific-popup.min.css">
		<link rel="stylesheet" type="text/css" href="../resources/hyein/vendors/swiper/swiper.css">
		<!-- App & fonts-->
		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700|Open+Sans:400,700">
		<link rel="stylesheet" type="text/css" id="app-stylesheet" href="../resources/hyein/css/main.css"><!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<![endif]-->
</head>
<body>
<div class="page-wrap" id="root">
			
			<!-- header -->
			<header class="header header--fixed">
				<div class="header__inner">
				<p></p>
					<div class="header__logo"><a href="main_login.do"><img id="logo"  src="../resources/hyein/img/logo.png" alt=""/></a></div>
					<div class="navbar-toggle" id="fs-button">
						<div class="navbar-icon"><span></span></div>
					</div>
				</div>
				
				<!-- fullscreenmenu__module -->
				<div class="fullscreenmenu__module" trigger="#fs-button">
					
					<!-- overlay-menu -->
					<nav class="overlay-menu">
						
						<!--  -->
						<ul class="wil-menu-list">
							<li class="current-menu-item box"><a href="main.jsp">
							<img class="profile" src="../resources/upload/아닌데여.png"></a>
							</li>
							<br/><br/>
							<li><a href="bookmark.do">북마크</a>
							</li>
							<li><a href="/Project/main.jsp">로그아웃</a>
							</li>
						</ul><!--  -->
						
					</nav><!-- End / overlay-menu -->
					
				</div><!-- End / fullscreenmenu__module -->
				
			</header><!-- End / header -->
			
			<!-- Content-->
			<div class="wil-content">
				
				<!-- Section -->
				<section class="awe-section">
					<div class="container">
						
						<!-- page-title -->
						<div class="page-title pb-40">
							<a href="bm.do"><img id="bm_img" src="../resources/hyein/img/works/bm_ok.jpg"></a>
							<h2 class="page-title__title">The Myth of Ugly Design</h2>
							<p class="page-title__text">by hyein</p>
							<p class="page-title__text">작성한 시각 2020.12.22</p>
							<div class="page-title__divider"></div>
						</div><!-- End / page-title -->
						
					</div>
				</section>
				<!-- End / Section -->
				
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						
						<!--  -->
						<div>
							<div class="work-detail__entry">
								<p>In nec porttitor nisi. Nunc at egestas ante. Sed vestibulum velit eu nibh commodo, non fermentum libero pellentesque. Fusce sed posuere ex, non ultrices nibh. Fusce quis leo non ex rutrum convallis non ut ante. Phasellus hendrerit ante nec est porta, et elementum massa euismod. Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
								<p>Quisque et quam facilisis, posuere justo ut, maximus nulla. Quisque id fermentum tortor. Duis sem mi, luctus sed luctus eget, viverra et ante. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec faucibus imperdiet porttitor. Etiam fringilla ligula et porttitor tristique..</p><br>
								<div class="work-img"><img src="../resources/hyein/img/works/01.jpg" alt=""></div>
								<div class="work-img"><img src="../resources/hyein/img/works/02.jpg" alt=""></div>
								<div class="work-img"><img src="../resources/hyein/img/works/03.jpg" alt=""></div>
							</div>
							
							<p class="best_comment">BEST</p>
						<div id="comments">	
							<div class="comment_text best_comment">
							<p>베스트 댓글 자리</p>
							</div>
							<div class="comment_text best_comment">
							<p>베스트 댓글 자리</p>
							</div>
						</div>	<br/><br/><br/>
						
							<p class="best_comment">REVIEWS</p>
						<div id="comments">	
							<div class="comment_text best_comment">
								<dl  class="cmt_item" id="content_area_dl_565920886">
									<dt>
										<span class="profile_img" title="아이디">아이디</span>
										<i>2020.12.21 16:10</i>
									</dt>
									<span class="comment_option">
											<span>현재 추천수</span>
											<span>
												<a href="#" type="button">추천</a>
											</span>
											<span>
												<a href="#" type="button">수정</a>
											</span>
											<span>
												<a href="#" type="button">삭제</a>
											</span>
									</span>
									<dd >
										<span>댓글 내용~~~</span>
									</dd>
								</dl>
							</div>
							<div class="comment_text best_comment">
							<p>댓글자리 최신순</p>
							</div>
						</div>	<br/><br/><br/>
							<div>
								<input id="write_comment" type="textarea"/>
								<input type="button" value="글쓰기"/>
							</div>
						</div><!-- End /  -->
						
						<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="#">댓글 더보기
							</a>
						</div><br/><br/><br/>
					<div id="contents_zone">
						<p class="best_comment awe-text-center">
							추천컨텐츠
						</p>
						<div id="contents_slider">
							<ul>
								<li><a href="#"><img src="../resources/hyein/img/works/4.jpg"><span>
										<strong>컨텐츠 제목</strong>
									</span></a></li>
								<li><a href="#"><img src="../resources/hyein/img/works/4.jpg"><span>
										<strong>컨텐츠 제목</strong>
									</span></a></li>
								<li><a href="#"><img src="../resources/hyein/img/works/4.jpg"><span>
										<strong>컨텐츠 제목</strong>
									</span></a></li>
								<li><a href="#"><img src="../resources/hyein/img/works/5.jpg"><span>
										<strong>컨텐츠 제목</strong>
									</span></a></li>
								<li><a href="#"><img src="../resources/hyein/img/works/5.jpg"><span>
										<strong>컨텐츠 제목</strong>
									</span></a></li>
							</ul>
						</div>
					</div>	
					</div>
				</section>
				<!-- End / Section -->
				
			</div>
			<!-- End / Content-->
			
			<!-- footer -->
			<div class="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-lg-6 ">
							<p class="footer__coppy">2018 &copy; Copyright <a href="http://awe7.com/">Awe7</a>. All rights Reserved.</p>
						</div>
						<div class="col-md-6 col-lg-6 ">
							<div class="footer__social">
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-facebook"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-twitter"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-linkedin"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-behance"></i>
								</a><!-- End / social-icon -->
								
								
								<!-- social-icon -->
								<a class="social-icon" href="#"><i class="social-icon__icon fa fa-vimeo"></i>
								</a><!-- End / social-icon -->
								
							</div>
						</div>
					</div>
				</div>
			</div><!-- End / footer -->
			
		</div>
		<!-- Vendors-->
		<script type="text/javascript" src="../resources/hyein/vendors/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/imagesloaded/imagesloaded.pkgd.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/isotope-layout/isotope.pkgd.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery-one-page/jquery.nav.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery.easing/jquery.easing.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery.matchHeight/jquery.matchHeight.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/masonry-layout/masonry.pkgd.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery.waypoints/jquery.waypoints.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/swiper/swiper.jquery.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/menu/menu.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/typed/typed.min.js"></script>
		<script type="text/javascript" src="../resources/hyein/vendors/jquery.bxslider.min.js"></script>
		<!-- App-->
		<script type="text/javascript" src="../resources/hyein/js/main.js"></script>
		<script type="text/javascript" src="../resources/hyein/js/contents.js"></script>
</body>
</html>