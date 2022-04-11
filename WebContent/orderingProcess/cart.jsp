<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Cart"%>
<%@ page import="vo.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<!-- Start All Title Box -->
<div id="frame">
      <form>
         <div id="frame2">
            <span style="font-size: 16pt; font-weight: bold;">${id }님의장바구니</span>
            </div>
            </form>
            </div>
	<!-- End All Title Box -->

	<!-- Start Cart  -->
	<c:choose>
		<c:when test="${cartList != null && cartList.size() > 0 }">
			<div class="cart-box-main">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="table-main table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>이미지</th>
											<th>상품 이름</th>
											<th>가격</th>
											<th>수량</th>
											<th></th>
											<th>총금액</th>
											<th>삭제</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartList" items="${cartList }"
											varStatus="status">
											<form method="post">
												<tr>

													<td class="thumbnail-img"><a href="#"> <img
															class="img-fluid" src="images/${cartList.image }" />
													</a></td>
													<td class="name-pr"><a
														href="productDetail.pd?pseq=${cartList.pseq }">
															${cartList.name } </a></td>
													<td class="price-pr">
														<p><fmt:formatNumber value="${cartList.price_out }" pattern="#,###"/>원</p>
													</td>
													<td class="quantity-box"><input type="number"
														id="quantity" name="quantity" size="3" min="1" max="100"
														class="c-input-text qty text"
														value="${cartList.quantity }" /></td>
													<td><input type="hidden" name="pseq" id="pseq"
														value="${cartList.pseq }" /> <input type="submit"
														value="변경" formaction="basketQty.ba" /></td>
													<td class="total-pr">
														<p><fmt:formatNumber value="${cartList.price_out * cartList.quantity }" pattern="#,###"/>원</p>
													</td>
													<td class="remove-pr"><a
														href="basketDelete.ba?pseq=${cartList.pseq }"> <i
															class="fas fa-times"></i>
													</a></td>
												</tr>
											</form>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>



					<div class="row my-5">
						<div class="col-lg-8 col-sm-12"></div>
						<div class="col-lg-4 col-sm-12">
							<div class="order-box">
								<h3>주문 상세</h3>
								<div class="d-flex">
									<h4>상품합계</h4>
									<div class="ml-auto font-weight-bold">&nbsp;${totalMoney }원
									</div>
								</div>
								<div class="d-flex">
									<h4>할인</h4>
									<div class="ml-auto font-weight-bold"></div>
								</div>
								<h4>배송비</h4>
								<div class="ml-auto font-weight-bold"></div>
							</div>
							<div class="d-flex gr-total">
								<h5>총합계</h5>
								<div class="ml-auto h5" style="text-align: right">&nbsp;${totalMoney }원
								</div>
							</div>
							<hr>
						</div>
					</div>
					<div class="col-12 d-flex shopping-box"
						style="display: flex !important; flex-direction: row; justify-content: space-between;">
						<a href="index.jsp" class="ml-auto btn hvr-hover">쇼핑 계속하기</a>
						<a href="order.or" class="ml-auto btn hvr-hover">주문</a>
					</div>
				</div>
			</div>
		</c:when>


		<c:otherwise>
			<div class="cart-box-main">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="table-main table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>이미지</th>
											<th>상품 이름</th>
											<th>가격</th>
											<th>수량</th>
											<th>총금액</th>
											<th>삭제</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="6"
												style="margin-top: 50px; margin-bottom: 50px; text-align: center;">장바구니가
												비어있습니다.</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>



					<div class="row my-5">
						<div class="col-lg-8 col-sm-12"></div>
						<div class="col-lg-4 col-sm-12">
							<div class="order-box">
								<h3>주문 상세</h3>
								<div class="d-flex">
									<h4>상품합계</h4>
									<div class="ml-auto font-weight-bold">&nbsp;원</div>
								</div>
								<div class="d-flex">
									<h4>할인</h4>
									<div class="ml-auto font-weight-bold"></div>
								</div>
								<h4>배송비</h4>
								<div class="ml-auto font-weight-bold"></div>
							</div>
							<div class="d-flex gr-total">
								<h5>총합계</h5>
								<div class="ml-auto h5" style="text-align: right">
									&nbsp;<span>원</span>
								</div>
							</div>
							<hr>
						</div>
					</div>
					<div class="col-12 d-flex shopping-box"
						style="display: flex !important; flex-direction: row; justify-content: space-between;">
						<a href="index.jsp" class="ml-auto btn hvr-hover">쇼핑 계속하기</a>
						<a href="order.or" class="ml-auto btn hvr-hover">주문</a>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<!-- End Cart -->
	<jsp:include page="../include/footer.jsp" />
</body>
</html>