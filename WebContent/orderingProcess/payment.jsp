<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../include/header.jsp" />
<%
	response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<style>
#frame {
	width: 80%;
	margin: 0 auto;
	padding: 50px 50px;
	background-color: #fff;
}

#frame2 {
	border-bottom: solid 1px #e0e0eb;
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
			<form>
				<div style="text-align: center;">
					<h1 style="font-size: 2em; font-weight: bold;">주문이 완료 되었습니다!</h1>
				</div>
				<br /> <br /> <br /> <span
					style="font-size: 10pt; font-weight: bold; display: inline-block; padding: 10px 10px;">주문
					상품 정보</span>
				<c:choose>
					<c:when
						test="${ordertodayview != null && ordertodayview.size() > 0 }">
						<table id="productInfo">
							<thead>
								<tr>
									<th style="width: 170px;">주문번호</th>
									<th style="width: 170px">이미지</th>
									<th style="width: 170px;">상품이름</th>
									<th style="width: 100px;">수량</th>
									<th style="width: 150px;">상품구매금액</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="orderview" items="${ordertodayview }"
									varStatus="status">
									<tr>
										<td>${orderview.odseq }</td>
										<td><img src="images/${orderview.image }"
											style="width: 100px;"></td>
										<td>${orderview.name }</td>
										<td>${orderview.quantity }</td>
										<td>${orderview.totalprice }원</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div align="center">
							<span style="display: inline-block; padding-top: 30px;">주문
								내역이 없습니다.</span>
						</div>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>
	<div class="col-12 d-flex shopping-box"
		style="display: flex !important; flex-direction: row; justify-content: center;">
		<a href="index.jsp" class="ml-auto btn hvr-hover">쇼핑 계속하기</a>&nbsp;&nbsp;
		<a href="orderList.or" class="ml-auto btn hvr-hover">주문 내역 보기</a>
	</div>
</body>
<jsp:include page="../include/footer.jsp" />
</html>