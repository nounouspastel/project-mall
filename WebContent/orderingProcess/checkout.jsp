<%@page import="java.util.ArrayList"%>
<%@page import="vo.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <span style="font-size: 16pt; font-weight: bold;">결제</span>
            </div>
            </form>
            </div>
	<!-- End All Title Box -->

	<!-- Start Cart  -->
	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="checkout-address">
						<div class="title-left">
							<h3>배송정보</h3>
						</div>
						<form class="needs-validation">
							<div class="row">
								<div class="col-md-6 mb-3">
									<c:set var="name" value="${orderId.name }" />
									<label for="firstName">이름 *</label> <input type="text"
										class="form-control" id="firstName"
										value="${fn:substring(name,1,3) }" readonly="readonly">
								</div>
								<div class="col-md-6 mb-3">
									<label for="lastName">성 *</label> <input type="text"
										class="form-control" id="lastName"
										value="${fn:substring(name,0,1) }" readonly="readonly">
								</div>
							</div>
							<div class="mb-3">
								<label for="username">아이디 *</label>
								<div class="input-group">
									<input type="text" class="form-control" id="username"
										value="${orderId.id }" required readonly="readonly">
								</div>
							</div>
							<div class="mb-3">
								<label for="email">전화번호 *</label> <input type="text"
									class="form-control" id="phone" name="phone"
									value="${orderId.phone }">
							</div>
							<div class="mb-3">
								<label for="email">이메일 주소 *</label> <input type="text"
									name="email" class="form-control" id="email"
									value="${orderId.email }">
							</div>
							<div class="mb-3">
								<label for="address">주소 *</label> <input type="text"
									class="form-control" id="address1" name="address1"
									value="${orderId.address1 }">
							</div>
							<div class="mb-3">
								<label for="address2">상세주소 *</label> <input type="text"
									class="form-control" id="address2" value="${orderId.address2 }">
							</div>

							<hr class="mb-4">
							<div class="title">
								<span>결재방법</span>
							</div>
							<div class="d-block my-3">
								<div class="custom-control custom-radio">
									<input id="credit" name="paymentMethod" type="radio"
										class="custom-control-input" checked required> <label
										class="custom-control-label" for="credit">신용카드</label>
								</div>
								<div class="custom-control custom-radio">
									<input id="debit" name="paymentMethod" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="debit">체크카드</label>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="cc-name">카드이름</label> <input type="text"
										class="form-control" id="cc-name" placeholder="" required>
									<small class="text-muted">Full name as displayed on
										card</small>
									<div class="invalid-feedback">Name on card is required</div>
								</div>
								<div class="col-md-6 mb-3">
									<label for="cc-number">카드번호</label> <input type="text"
										class="form-control" id="cc-number" placeholder="" required>
									<div class="invalid-feedback">Credit card number is
										required</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-3">
									<label for="cc-expiration">Expiration</label> <input
										type="text" class="form-control" id="cc-expiration"
										placeholder="" required>
									<div class="invalid-feedback">Expiration date required</div>
								</div>
								<div class="col-md-3 mb-3">
									<label for="cc-expiration">CVV</label> <input type="text"
										class="form-control" id="cc-cvv" placeholder="" required>
									<div class="invalid-feedback">Security code required</div>
								</div>
								<div class="col-md-6 mb-3">
									<div class="payment-icon">
										<ul>
											<li><img class="img-fluid"
												src="images/payment-icon/1.png" alt=""></li>
											<li><img class="img-fluid"
												src="images/payment-icon/2.png" alt=""></li>
											<li><img class="img-fluid"
												src="images/payment-icon/3.png" alt=""></li>
											<li><img class="img-fluid"
												src="images/payment-icon/5.png" alt=""></li>
											<li><img class="img-fluid"
												src="images/payment-icon/7.png" alt=""></li>
										</ul>
									</div>
								</div>
							</div>
							<hr class="mb-1">
						</form>
					</div>
				</div>
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="row">
						<div class="col-md-12 col-lg-12">
							<div class="shipping-method-box">
								<div class="title-left">
									<h3>배송가능 시간 안내</h3>
								</div>
								<div class="mb-4">
									<div class="custom-control custom-radio"
										style="font-size: 0.8em">
										<span style="color: red">- 영업일 기준 오후 1시 이전 결제 완료 주문건 :
											당일 출고됩니다.</span> (일부 상품 제외) <br>- 공휴일의 경우 다음 영업일에 출고됩니다. (출고된
										경우 서울/수도권 지역은 대부분 다음날 수령, 지방은 1~3일 이내에 배송됩니다.<br> 따라서 전체
										배송 기간은 (업무일 기준) 3일~7일 정도 소요되며, 일부 택배사 사정에 따라 변동될 수 있습니다.) <br>※
										<span style="color: red">주문 상품이 재고 부족일 경우 부득이하게 배송 시간은
											달라질 수 있는 점 양해 부탁드립니다.</span>
									</div>
								</div>
							</div>
							<div class="col-md-12 col-lg-12">
								<div class="odr-box">
									<div class="title-left">
										<h3>장바구니</h3>
									</div>
									<c:choose>
										<c:when test="${cartList != null && cartList.size() > 0 }">
											<c:forEach var="cartList" items="${cartList }" varStatus="status" begin="0" end="${fn:length(cartList) }" step="1">
												<form method="post" name="cart" id="cart" action="payment.or">
													<c:set var="today" value="<%=new java.util.Date() %>" />
					                               	 	<c:set var="date">
					                                		<fmt:formatDate value="${today }" pattern="yyMMdd"/>
					                                	</c:set>
                                	  				<input type="hidden" formaction="paymentToday.or"id="date" name="date" value="%${date }%"/>
													<input type="hidden" formaction="payment.or" id="id" name="id" value="${cartList.id }" /> 
													<input type="hidden" formaction="payment.or" id="pseq" name="pseq" value="${cartList.pseq }" /> 
													<input type="hidden" formaction="payment.or" id="quantity" name="quantity" value="${cartList.quantity }" />
													<div class="rounded p-2 bg-light">
														<div class="media-body">
															<a href="productView.cp?pseq=${cartList.pseq }">
																${cartList.name }</a>
															<div class="small text-muted">
																Price: ${cartList.price_out } 원<span class="mx-2">|</span>
																Qty : ${cartList.quantity } <span class="mx-2">|</span>
																Subtotal: ${cartList.price_out * cartList.quantity } 원
															</div>
														</div>
													</div>
													<div class="media mb-2 border-bottom"></div>
													<c:set var="pseq" value="${cartList.pseq }" />
													<jsp:useBean id="now" class="java.util.Date" />
													<fmt:formatDate value="${now}" pattern="yyMMdd" var="today" />
													<c:set var="ran"><%=java.lang.Math.round(java.lang.Math.random() * 10000)%></c:set>
													<input type="hidden" name="odseq" id="odseq"
														value="out${today }${fn:substring(pseq,0,1)}${ran}" />
												</form>
											</c:forEach>
										</c:when>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="col-md-12 col-lg-12">
						<div class="order-box">
							<div class="title-left">
								<h3>총금액</h3>
							</div>
							<div class="d-flex">
								<div class="font-weight-bold">결제하실</div>
								<div class="ml-auto font-weight-bold">금액</div>
							</div>
							<hr class="my-1">
							<div class="d-flex">
								<h4>제품가격</h4>
								<div class="ml-auto font-weight-bold">&nbsp;${totalMoney }원</div>
							</div>
							<div class="d-flex">
								<h4>할인</h4>
								<div class="ml-auto font-weight-bold">&nbsp;0 %</div>
							</div>
							<hr class="my-1">
							<div class="d-flex">
								<h4>배송비</h4>
								<c:set var="deli" value="2500" />
								<c:choose>
									<c:when test="${totalMoney > 50000 }">
										<div class="ml-auto font-weight-bold">
											&nbsp;${deli - 2500} 원 <span style="font-size: 0.8em;">(-2500원)</span>
											<span style="color: red; font-size: 0.7em">&nbsp;&nbsp;
												*&nbsp; 50000원이상 구매시 배송료 무료</span>
										</div>
									</c:when>
									<c:otherwise>
										<div class="ml-auto font-weight-bold">
											&nbsp;${deli } 원 <span style="color: red; font-size: 0.7em">&nbsp;&nbsp;
												*&nbsp; 50000원이상 구매시 배송료 무료</span>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							<hr>
							<div class="d-flex gr-total">
								<h5>총가격</h5>
								<c:choose>
									<c:when test="${totalMoney > 50000 }">
										<div class="ml-auto h5">&nbsp;${totalMoney } 원</div>
									</c:when>
									<c:otherwise>
										<div class="ml-auto h5">&nbsp;${totalMoney + deli} 원</div>
									</c:otherwise>
								</c:choose>
							</div>
							<hr>
						</div>
					</div>
					<div class="col-12 d-flex shopping-box">
						<button type="submit"  form="cart"
							class="ml-auto btn hvr-hover" style="color:#fff;">결제</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- End Cart -->
	<jsp:include page="../include/footer.jsp" />
</body>
</html>