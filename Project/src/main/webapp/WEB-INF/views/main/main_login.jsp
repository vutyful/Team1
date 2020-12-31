<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>simsim 메인 페이지</title>
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
					<div class="header__logo"><a href="#"><img id="logo"  src="../resources/hyein/img/logo.png" alt=""/></a></div>
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
							<li class="current-menu-item box"><a href="/Project/hjview/profile.do">
							<img class="profile" src="../resources/upload/${sessionScope.pic}"></a>
							</li>
							<br/><br/>
							<li><a href="../main/bookmark.do">북마크</a>
							</li>
							<li><a href="logout.do">로그아웃</a>
							</li>
							<c:if test="${sessionScope.auth >= 5}"><li><a href="../manageContents/ContentsList.do">관리자</a>
							</li></c:if>
						</ul><!--  -->
						
					</nav><!-- End / overlay-menu -->
					
				</div><!-- End / fullscreenmenu__module -->
				
			</header><!-- End / header -->
			
			<!-- Content-->
			<div class="wil-content">
				
				<!-- Section -->
				<section class="awe-section">
					<!-- <div class="container">
						
						page-title
						<div class="page-title">
							<h2 class="page-title__title">Hello, my name is Erik Minimis.<br>I
								
								typing__module
								<div class="typing__module">
									<div class="typed-strings"><span>'m a web designer</span><span> do creative</span><span>'m a frontend developer</span>
									</div><span class="typed"></span>
								</div>End / typing__module
								
							</h2>
							<p class="page-title__text"></p>
							<div class="page-title__divider"></div>
						</div>End / page-title
						
					</div> -->
				</section>
				<!-- End / Section -->
				
				
				<!-- Section -->
				<section class="awe-section bg-gray">
					<div class="container">
						<!-- <div class="row">
							<div class="col-lg-12 ">
								
								title
								<div class="title">
									<h2 class="title__title">광고 영역</h2>
								</div>End / title
								
							</div>
						</div> -->
						<div class="grid-css grid-css--masonry" data-col-lg="3" data-col-md="2" data-col-sm="2" data-col-xs="1" data-gap="30">
							<div id="grid__inner" class="grid__inner">
								<div class="grid-sizer"></div>
								<div id="ad" class="grid-item">  <!-- 광고 고정위치 -->
										<div class="grid-item__inner">
											<div class="grid-item__content-wrapper">
												<!-- work -->
												<div class="work"><a href="../managerAd/click_login.do?gender=${sessionScope.gender}&birth=${sessionScope.birth}&link=${ad.adlink}&adnum=${ad.adnum}">
														
														<!-- hoverbox ef-slide-right -->
														<div class="hoverbox ef-move-right light">
															<!-- hb_front -->
															<div class="hb_front"><img src="../resources/upload/${ad.adimg}"/>
															</div><!-- End / hb_front -->
															
															
															<!-- hb_back -->
															<div class="hb_back">
																<h2 class="work__title">${ad.adname}</h2><span class="work__text">광고</span>
															</div><!-- End / hb_back -->
															
														</div><!-- End / hoverbox ef-slide-bottom -->
														</a>
												</div><!-- End / work -->
											</div>
										</div>
									</div>
							<c:forEach items="${contents}" var="con"> <!-- 랜덤 컨텐츠 -->
								<div class="grid-item">
									<div class="grid-item__inner">
										<div class="grid-item__content-wrapper">
											<!-- work -->
											<div class="work"><a href="contents_login.do?connum=${con.connum}&cate=${con.cate}">
													
													<!-- hoverbox ef-slide-right -->
													<div class="hoverbox ef-move-right light">
														<!-- hb_front -->
														<div class="hb_front"><img src="../resources/upload/${con.img}"/>
														</div><!-- End / hb_front -->
														
														
														<!-- hb_back -->
														<div class="hb_back">
															<h2 class="work__title"> ${con.title} </h2><span class="work__text"> ${con.ccontent} </span>
														</div><!-- End / hb_back -->
														
													</div><!-- End / hoverbox ef-slide-bottom -->
													</a>
											</div><!-- End / work -->
										</div>
									</div>
								</div>
							</c:forEach>
							</div>
						</div>
						
						<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary" href="#">새 컨텐츠
							</a>
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
							<p class="footer__coppy">2020 &copy; Copyright <a href="http://www.ikosmo.co.kr/">kosmo</a>. simsim.</p>
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
		<!-- App-->
		<script type="text/javascript" src="../resources/hyein/js/main.js"></script>
</body>
</html>