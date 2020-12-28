<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
							<li class="current-menu-item box"><a href="/Project/hjview/profile.do">
							<img class="profile" src="../resources/upload/아닌데여.png"></a>
							</li>
							<br/><br/>
							<li><a href="bookmark.do">북마크</a>
							</li>
							<li><a href="logout.do">로그아웃</a>
							</li>0
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
							<a href="bm.do?connum=${content.connum}">
							<c:choose>
								<c:when test="${check eq 'true'}">
									<img id="bm_img" src="../resources/hyein/img/works/bm_ok.jpg"></a>
								</c:when>
								<c:when test="${check eq 'false'}">
									<img id="bm_img" src="../resources/hyein/img/works/bm_no.jpg"></a>
								</c:when>
							</c:choose>
							<h2 class="page-title__title"> ${content.title} </h2>
							<p class="page-title__text">by ${content.memnum} </p>
							<p class="page-title__text">${content.postdate} </p>
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
								<p> ${content.ccontent} </p>
								<div class="work-img"><img src="../resources/upload/${content.img}" alt=""></div>
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
							<c:forEach items="${replys}" var="rep">
							<div class="comment_text best_comment replys">
								<dl  class="cmt_item">
									<dt>
										<span><img id="profile_pic" class="profile_reply box_reply" src="../resources/upload/${rep.memberVO.pic}"/></span>
										<span id="reply_id" title="아이디"> ${rep.memberVO.id}${sessionScope.login}</span>
										<i id="reply_date"> ${rep.redate} </i>
									</dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<span class="comment_option">
											<span id="reply_reco">${rep.rreco}</span>
											<span>
												<a href="reco.do?rreco=${rep.rreco}&replynum=${rep.replynum}" class="reply_reco" type="button">추천</a>
											</span>
											<c:choose>
												<c:when test="${sessionScope.login eq rep.memberVO.id}">
													<span class="reply_modify">
														<span>수정</span>
													</span>
													<span class="reply_delete">
														<span>삭제</span>
													</span>
												</c:when>
												<c:when test="${sessionScope.login ne rep.memberVO.id}">
													<span class="reply_modify">
														<span>수정</span>
													</span>
													<span class="reply_delete">
														<input type="button">삭제</a>
													</span>
												</c:when>
											</c:choose>
									</span>
									<dd>
										<span>
										<textarea class="ta_comment ta_modify">${rep.rcontent}</textarea>
										<input class="modify_btn" type="button" value="등록"/>
										<input class="replynum" type="hidden" value="${rep.replynum}"/>
										<p class="rcontent">&nbsp;&nbsp;${rep.rcontent}</p>
										</span>
									</dd>
								</dl>
							</div>
							</c:forEach>
						</div>	<br/><br/><br/>
							<div>
								<textarea id="ta_comment"></textarea>
								<input id="connum" type="hidden" value="${content.connum}"/>
								<button id="write_comment">글쓰기</button>
							</div>
						</div><!-- End /  -->
						
						<div class="awe-text-center mt-50">
							<a class="md-btn md-btn--outline-primary " href="#">댓글 더보기
							</a>
						</div><br/><br/><br/>
					<div id="contents_zone">
						<p class="best_comment awe-text-center">
							연관컨텐츠
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
  <!-- 	<script type="text/javascript">
		
  	$('.comment_text best_comment').each(function(){
		var reply_modifys = $(this).find('input[class="reply_modify"]');
	
		reply_modifys.click(function(){
			alert('수정 클릭');
				$('.taxtarea').css('display','inline-block');
				$('.modify_btn').css('display','inline-block');
				$('.rcontent').css('display','none');
			})
	})

			
		</script>  -->
</body>
</html>