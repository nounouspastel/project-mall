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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<!-- Start Shop Detail  -->
	<form action="basketAdd.ba" method="post" name="cartAdd">
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block w-100" src="images/${product.image}"
									alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
					<c:set var="overlap" value="${product.pseq }${id }" />
						<input type="hidden" id="overlap" name="overlap" value="${overlap}"/>
						<input type="hidden" id="totalremain" name="totalremain" value="${product.quantity }"/>
						<input type="hidden" id="id" name="id" value="${id }" />
						<input type="hidden" id="pseq" name="pseq" value="${product.pseq}" />
						<input type="hidden" id="kind" name="kind" value="${product.kind}" />
						<input type="hidden" id="name" name="name" value="${product.name }"/>
						<input type="hidden" id="price_out" name="price_out" value="${product.price_out }" />
						<h2>상품명: ${product.name}</h2>
						<br>
						<h5>판매가: ${product.price_out} 원</h5>
						<p class="available-stock">
						<h4>설명 :</h4>
																	<pre style="font-size: 18px;">
                                    <h3>${product.content}"</h3>
                                 </pre>
						<ul>
							<li>
								<div class="form-group quantity-box">
									<label class="control-label">수량</label> <input
										class="form-control" value="1" min="1" max="20" type="number" id="quantity" name="quantity" >
								</div>
							</li>
						</ul>

						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<%-- <a class="btn hvr-hover" data-fancybox-close="" href="#">주문</a>--%>
								<a class="btn hvr-hover" href="#" onclick="javascript:document.cartAdd.submit();">장바구니
									담기</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row my-5">
				<div class="card card-outline-secondary my-4">
					<div class="card-header">
						<h2>리뷰</h2>
					</div>
					<div class="card-body">
						<div class="media mb-3">
							<div class="mr-2">
								<img class="rounded-circle border p-1" src="images/review.png">
							</div>
							<div class="media-body">
								<p>생각보다 작다했는데 캠핑가서 쓸때는 무난했어요.</p>
								<small class="text-muted">작성날짜 2022/03/03</small>
							</div>
						</div>
						<hr>
						<div class="media mb-3">
							<div class="mr-2">
								<img class="rounded-circle border p-1" src="images/review2.png">
							</div>
							<div class="media-body">
								<p>첨에 잘못주문해서 판매자님께서 연락주셨는데 친절하게 응대 해주셨어여! 전용 케이스가 있어서 깔끔하게
									보관되요 가격에 좀 비싸서 별 4개.. 드려요ㅎㅎ.</p>
								<small class="text-muted">작성날짜 2022/02/03</small>
							</div>
						</div>
						<hr>
						<div class="media mb-3">
							<div class="mr-2">
								<img class="rounded-circle border p-1" src="images/review3.png">
							</div>
							<div class="media-body">
								<p>매장에서 사용 할려고 구매했어요~ 인테리어도 되고 너무 예뻐요~</p>
								<small class="text-muted">작성날짜 2022/02/21</small>
							</div>
						</div>
						<hr>
						<a href="#" class="btn hvr-hover">리뷰작성</a>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>추천상품</h1>
					</div>
					<div class="featured-products-box owl-carousel owl-theme">
						<c:forEach var="product" items="${productList}" varStatus="status">
							<div class="item">
								<div class="products-single fix">
									<div class="box-img-hover">
										<img src="images/${product.image}" class="img-fluid"
											alt="Image">
										<div class="mask-icon">
											<ul>
												<li><a href="productDetail.pd?pseq=${product.pseq}"
													data-toggle="tooltip" data-placement="right">상세정보<i
														class="fas fa-eye"></i></a></li>
											</ul>
											<a class="cart" href="cart.jsp">장바구니</a>
										</div>
									</div>
									<div class="why-text">
										<h4>상품명: ${product.name}</h4>
										<h5>판매가: ${product.price_out} 원</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	<!-- End Cart -->


	<jsp:include page="include/footer.jsp" />
</body>
</html>