<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<div id="frame2">
					<span style="font-size: 16pt; font-weight: bold;">배송 현황</span> <span
						class="home"></span> <span> </span>
				</div>
				<br />
				<br /> <br /> <span
					style="font-size: 10pt; font-weight: bold; display: inline-block; padding: 10px 10px;">주문
					상품 정보</span>
				<c:choose>
					<c:when test="${orderPacel != null && orderPacel.size() > 0 }">
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
								<c:forEach var="orderPacel" items="${orderPacel }" varStatus="status">
									<tr>
										<td><a href="paymentView.or?odseq=${orderPacel.odseq }">${orderPacel.odseq }</a></td>
										<td><img src="images/${orderPacel.image }" style="width: 100px;"></td>
										<td>${orderPacel.name }</td>
										<td>${orderPacel.quantity }</td>
										<td><fmt:formatNumber value="${orderPacel.totalprice }" pattern="#,###"/>원</td>
										<td>${orderPacel.deli }</td>
										<td><a href="paymentView.or?odseq=${orderPacel.odseq }" style="background-color:#fff; color:blue; font-weight: bold;">주문취소</a></td>
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
</body>
<jsp:include page="../include/footer.jsp" />
</html>