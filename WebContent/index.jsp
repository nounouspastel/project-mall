<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<!-- 메인 바디 시작 -->
	<div id="slides-shop" class="cover-slides">
		<ul class="slides-container">
			<li class="text-center"><img src="images/img-pro-01.jpg" alt="">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1 class="m-b-20">
								<strong>get set shop </strong>
							</h1>
						</div>
					</div>
				</div></li>
			<li class="text-center"><img src="images/img-pro-02.jpg" alt="">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1 class="m-b-20">
								<strong>get set shop </strong>
							</h1>
						</div>
					</div>
				</div></li>
			<li class="text-center"><img src="images/img-pro-03.jpg" alt="">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1 class="m-b-20">
								<strong>get set shop </strong>
							</h1>
						</div>
					</div>
				</div></li>
		</ul>
		<div class="slides-navigation">
			<a href="#" class="next"><i class="fa fa-angle-right"
				aria-hidden="true"></i></a> <a href="#" class="prev"><i
				class="fa fa-angle-left" aria-hidden="true"></i></a>
		</div>
	</div>
	<!-- End Slider -->

	<!-- Start Categories  -->
	<div class="categories-shop">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="images/categories_img_01.jpg" alt="" onclick="location.href='mainProductList.pd?kind=c';"/>
						<a class="btn hvr-hover" href="mainProductList.pd?kind=c">의자</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="images/categories_img_02.jpg" alt="" onclick="location.href='mainProductList.pd?kind=t';"/>
						<a class="btn hvr-hover" href="mainProductList.pd?kind=t">테이블</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="images/categories_img_03.jpg" alt="" onclick="location.href='mainProductList.pd?kind=p';"/>
						<a class="btn hvr-hover" href="mainProductList.pd?kind=p">텐트</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Categories -->

	<jsp:include page="include/footer.jsp" />

</body>

</html>