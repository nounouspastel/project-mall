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
	<!-- Start All Title Box -->
<div id="frame">
      <form>
         <div id="frame2">
            <span style="font-size: 16pt; font-weight: bold;">상품</span>
            </div>
            </form>
            </div>
	<!-- End All Title Box -->
	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div
					class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row">
							<div class="col-12 col-sm-8 text-center text-sm-left">
								<div class="toolbar-sorter-right">
									<span>정렬 기준 </span>
								</div>
							</div>
							<div class="col-12 col-sm-4 text-center text-sm-right">
								<ul class="nav nav-tabs ml-auto">
									<li><a class="nav-link active" href="#list-view"
										data-toggle="tab"> <i class="fa fa-list-ul"></i>
									</a></li>
								</ul>
							</div>
						</div>
						<!-- 메인상품시작 -->
						<c:forEach var="product" items="${productList}" varStatus="status">
							<div class="list-view-box">
								<div class="row">
									<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
										<div class="products-single fix">
											<div class="box-img-hover">
												<img src="images/${product.image}" class="img-fluid"
													alt="Image" id="productImage" />
												<div class="mask-icon">
													<ul>
														<li><a href="productDetail.pd?pseq=${product.pseq}"
															data-toggle="tooltip" data-placement="right">상세정보<i
																class="fas fa-eye"></i></a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
										<div class="why-text full-width">
											<h4>상품명: ${product.name}</h4>
											<h5>판매가: ${product.price_out} 원</h5><br><br>
											<h5>재고: ${product.quantity} 개</h5>
											<br> <br>
											<h4>설명 :</h4>
											<pre style="font-size: 18px;">
                                    <h3>${product.content}</h3>
                                 </pre>
											<a class="btn hvr-hover" href="productDetail.pd?pseq=${product.pseq}">상세정보</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Shop Page -->
	<jsp:include page="include/footer.jsp" />
</body>
</html>