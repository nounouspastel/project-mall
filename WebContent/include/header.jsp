<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">
<meta charset="UTF-8">

<script type="text/javascript">
	function changeView(value) {

		if (value == "1") //로그인
		{
			location.href = "login.jsp";
		} else if (value == "2") //회원가입
		{
			location.href = "join.jsp";
		} else if (value == "3") //로그아웃
		{
			location.href = "logout.jsp";
		} else if (value == "4") //내정보
		{
			location.href = "my-account.jsp";
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<!-- Start Main Top -->
	<div class="main-top">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="our-link">
						<ul>
							<li><a href="my-account.jsp"><i
									class="fa fa-user s_color"></i>&nbsp;${id}환영합니다</a></li>
							<li><a href="main.jsp"><i class="fas fa-headset"></i>&nbsp;관리자페이지</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="text-slid-box">
						<div id="offer-box" class="carouselTicker">
							<ul class="offer-box">
								<li><i class="fab fa-opencart"></i> 텐트 20% 할인중</li>
								<li><i class="fab fa-opencart"></i> 의자 30% 할인중</li>
								<li><i class="fab fa-opencart"></i> 테이블 15% 할인중</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Main Top -->
	<!-- 메인 탑 시작 -->
	<header class="main-header">
		<!-- Start Navigation -->
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
			<div class="container">
				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbar-menu" aria-controls="navbars-rs-food"
						aria-expanded="false" aria-label="Toggle navigation">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="index.jsp"><img
						src="images/logo.png" class="logo" alt=""></a>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li class="nav-item"><a class="nav-link"
							href="mainProductList.pd?kind=c">의자</a></li>
						<li class="nav-item"><a class="nav-link"
							href="mainProductList.pd?kind=t">테이블</a></li>
						<li class="nav-item"><a class="nav-link"
							href="mainProductList.pd?kind=p">텐트</a></li>
						<li class="dropdown"><a href="#" class="nav-link dropdown"
							data-toggle="dropdown">주문상세</a>
							<ul class="dropdown-menu">
								<li><a href="parcel.or">배송현황</a></li>
								<li><a href="orderList.or">주문내역</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link"
							href="basketList.ba"><i class="fa fa-shopping-bag">장바구니</i></a></li>							
					</ul>
				</div>
				<!-- /.navbar-collapse -->

				<!-- Start Atribute Navigation -->
				<div id="wrap">
					<p>
						<%
							// 로그인 안되었을 경우 - 로그인, 회원가입 버튼을 보여준다.
						if (session.getAttribute("id") == null) {
						%>
					
					<div class="collapse navbar-collapse" id="navbar-menu">
						<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
							data-out="fadeOutUp">
							<li class="dropdown"><a href="#" class="nav-link dropdown"
								data-toggle="dropdown">접속</a>
								<ul class="dropdown-menu">
									<li><a onclick="changeView(1)">로그인</a></li>
									<li><a onclick="changeView(2)">회원가입</a></li>
								</ul></li>
						</ul>
					</div>
					<%
						// 로그인 되었을 경우 - 로그아웃 보여준다.
					} else {
					%>
					<div class="collapse navbar-collapse" id="navbar-menu">
						<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
							data-out="fadeOutUp">
							<li class="dropdown"><a href="#" class="nav-link dropdown"
								data-toggle="dropdown">접속</a>
								<ul class="dropdown-menu">
									<li><a onclick="changeView(3)">로그아웃</a></li>
									<li><a onclick="changeView(4)">내정보</a></li>
								</ul></li>
						</ul>
					</div>
					<%
						}
					%>
					</p>
				</div>
				<!-- End Atribute Navigation -->
			</div>
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->

	<!-- Start Top Search -->
	<div class="top-search">
		<div class="container">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-search"></i></span>
				<input type="text" class="form-control" placeholder="Search">
				<span class="input-group-addon close-search"><i
					class="fa fa-times"></i></span>
			</div>
		</div>
	</div>
	<!-- End Top Search -->
</body>
</html>