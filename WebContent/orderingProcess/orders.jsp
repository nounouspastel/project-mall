<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<span style="font-size: 16pt; font-weight: bold;">주문조회</span> <span
						class="home"></span> <span> </span>
				</div>
				<br />
				<div
					style="border: 1px solid #e0e0eb; background-color: #f5f5f0; padding: 10px 10px; font-size: 13pt; font-weight: bold;">
					주문내역조회</div>
				<br />
				<div id="search">
					<div style="border: 1px solid gray; padding: 20px;">
				<form action="category.or" method="post">
						<select style="padding: 5px; float: right; margin-top: 20px;" id="deli" name="deli" onchange="this.form.submit()">
							<option>전체상품</option>
							<option>배송준비</option>
							<option>배송중</option>
							<option>배송완료</option>
						</select>&nbsp;
				</form>	 
				<form method="post" name="search">
						<input type="date" style="padding: 3px;" id="startdate" name="startdate"/>~
						<input type="date" style="padding: 3px" id="enddate" name="enddate"/>&nbsp; 
						<input type="submit" value="조회" formaction="search.or" 
						style="border: 1px solid gray; font-size: 12pt; font-weight: bold; background-color: #6699ff; color: #fff;"/>
				</form>
					</div>
					<ol style="padding: 10px 20px; font-size: 10pt; color: gray;">
						<li>기본적으로 최근 개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
						<li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
						<li>취소/교환/반품 신청은 주문완료일 기준 30일까지 가능합니다.</li>
					</ol>
				</div>
				<br /> <br /> <span
					style="font-size: 10pt; font-weight: bold; display: inline-block; padding: 10px 10px;">주문
					상품 정보</span>
				<c:choose>
					<c:when test="${orderList != null && orderList.size() > 0 }">
						<table id="productInfo">
							<thead>
								<tr>
									<th style="width: 130px;">주문번호</th>
									<th style="width: 270px;">상품이름</th>
									<th style="width: 100px;">수량</th>
									<th style="width: 150px;">상품구매금액</th>
									<th>주문처리상태</th>
									<th>주문날짜</th>
									<th>취소/교환/반품</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="orderList" items="${orderList }" varStatus="status">
									<tr>
										<td><a href="paymentView.or?odseq=${orderList.odseq }">${orderList.odseq }</a></td>
										<td>${orderList.name }</td>
										<td>${orderList.quantity }</td>
										<td><fmt:formatNumber value="${orderList.totalprice }" pattern="#,###"/>원</td>
										<td>${orderList.deli }</td>
										<td>${orderList.indate }</td>
										<c:choose>
										<c:when test="${orderList.deli == '배송완료' }">
										<td><span style="background-color:#fff; color:blue; font-weight: bold;">배송완료</span></td>
										</c:when>
										<c:otherwise>
										<td><a href="paymentView.or?odseq=${orderList.odseq }" style="background-color:#fff; color:blue; font-weight: bold;">취소/교환/반품</a></td>
										</c:otherwise>
										</c:choose>
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