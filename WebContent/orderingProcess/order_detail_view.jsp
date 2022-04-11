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
<jsp:include page="../include/header.jsp" />
<style>
#frame {
	width: 80%;
	margin: 0 auto;
	padding: 50px 50px;
	background-color: #fff;
}

#frame2 {
	border-bottom: solid 3px #000;
	padding: 20px 0;
}

.home {
	float: right;
	clear: both;
}

ol {
	list-style: square;
}

table#productInfo {
	border: 1px solid #e0e0eb;
	border-collapse: collapse;
	background-color: #f5f5f0;
	width: 100%;
	font-size: 10pt;
}

table#productInfo th, td {
	border: 1px solid #e0e0eb;
	text-align: center;
	padding: 20px 0;
}
</style>
<body>
	<div id="backbody">
		<div id="frame">
			<div id="frame2">
				<span style="font-size: 16pt; font-weight: bold;">주문 상세 내역</span> <span
					class="home"></span> <span> </span>
			</div>
			<br /> <br /> <br /> <span
				style="font-size: 10pt; font-weight: bold; display: inline-block; padding: 10px 10px;">주문
				상품 정보</span>
			<c:choose>
				<c:when test="${orderview != null && orderview.size() > 0 }">
					<table id="productInfo">
						<thead>
							<tr>
								<th style="width: 270px;">주문번호</th>
								<th>이미지</th>
								<th style="width: 270px;">상품이름</th>
								<th style="width: 100px;">수량</th>
								<th style="width: 150px;">상품구매금액</th>
								<th>주문처리상태</th>
								<th>취소/교환/반품</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="orderview" items="${orderview }"
								varStatus="status">
								<tr>
									<td>${orderview.odseq }</td>
									<td><img src="images/${orderview.image }"
										style="width: 100px;"></td>
									<td><a href="productDetail.pd?pseq=${orderview.pseq }">${orderview.name }</a></td>
									<td>${orderview.quantity }</td>
									<td><fmt:formatNumber value="${orderview.totalprice }" pattern="#,###"/>원</td>
									<td>${orderview.deli }</td>
									<td><a
										href="ordercancellation.or?odseq=${orderview.odseq }&pseq=${orderview.pseq}"
										onclick="return confirm('주문을 취소 하시겠습니까?');"
										style="background-color: #fff; color: blue; font-weight: bold;">주문취소</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="cart-box-main">
						<div class="container">
							<div class="row">
								<div class="col-sm-6 col-lg-6 mb-3">
									<div class="checkout-address">
										<div class="title-left">
											<h3>배송정보</h3>
										</div>
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
												value="${orderId.phone }" readonly="readonly">
										</div>
										<div class="mb-3">
											<label for="email">이메일 주소 *</label> <input type="text"
												name="email" class="form-control" id="email"
												value="${orderId.email }" readonly="readonly">
										</div>
										<div class="mb-3">
											<label for="address">주소 *</label> <input type="text"
												class="form-control" id="address1" name="address1"
												value="${orderId.address1 }" readonly="readonly">
										</div>
										<div class="mb-3">
											<label for="address2">상세주소 *</label> <input type="text"
												class="form-control" id="address2"
												value="${orderId.address2 }" readonly="readonly">
										</div>
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
														<span style="color: red">- 영업일 기준 오후 1시 이전 결제 완료
															주문건 : 당일 출고됩니다.</span> (일부 상품 제외) <br>- 공휴일의 경우 다음 영업일에
														출고됩니다. (출고된 경우 서울/수도권 지역은 대부분 다음날 수령, 지방은 1~3일 이내에 배송됩니다.<br>
														따라서 전체 배송 기간은 (업무일 기준) 3일~7일 정도 소요되며, 일부 택배사 사정에 따라 변동될 수
														있습니다.) <br>※ <span style="color: red">주문 상품이
															재고 부족일 경우 부득이하게 배송 시간은 달라질 수 있는 점 양해 부탁드립니다.</span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br />
									<div class="col-md-12 col-lg-12">
										<div class="order-box">
											<div class="title-left">
												<h3>결제하신 총금액</h3>
											</div>
											<div class="d-flex">
												<div class="font-weight-bold">결제하신</div>
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

												<div class="ml-auto font-weight-bold">
													&nbsp; 0 원 <span style="color: red; font-size: 0.7em">&nbsp;&nbsp;
														*&nbsp; 50000원이상 구매시 배송료 무료</span>
												</div>
											</div>
											<hr>
											<div class="d-flex gr-total">
												<h5>결제 하신 금액</h5>
												<div class="ml-auto h5">&nbsp;${sumPrice} 원</div>
											</div>
											<hr>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<a href="javascript:history.back();" style="float: right; color:#fff;"
						class="ml-auto btn hvr-hover">돌아가기</a>

				</c:when>
				<c:otherwise>
					<div align="center">
						<span style="display: inline-block; padding-top: 30px;">주문
							내역이 없습니다.</span><br /> <br />
					</div>
					<div align="center">
						<a href="index.jsp" style="color: #fff;"
							class="ml-auto btn hvr-hover">쇼핑 계속하기</a> <a
							href="javascript:history.back();" style="color: #fff;"
							class="ml-auto btn hvr-hover">돌아가기</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<jsp:include page="../include/footer.jsp" />
</html>