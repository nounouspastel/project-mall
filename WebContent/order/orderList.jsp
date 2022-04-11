<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:if test="${pageInfo ne null }">
	<c:set var="listCount" value="${pageInfo.listCount }"/>
	<c:set var="nowPage" value="${pageInfo.page }"/>
	<c:set var="maxPage" value="${pageInfo.maxPage }"/>
	<c:set var="startPage" value="${pageInfo.startPage }"/>
	<c:set var="endPage" value="${pageInfo.endPage }"/>
</c:if> 
<!DOCTYPE html>
<html class="no-js">   
    <head>
<jsp:include page="/include/AdminHeader.jsp" />
    </head>   
    <body>
 <jsp:include page="/include/AdminTopFixMenu.jsp" />   
   
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
					 <jsp:include page="/include/AdminLeftMenu.jsp" />   
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <div class="alert alert-success">
                            <h4>주문리스트</h4>
                        </div>
                  <div class="navbar">
                     <div class="navbar-inner">
	                       <ul class="breadcrumb">
	                         <li>
			             <form action="adminOrder_detailList.od" >
							<select name="odOption">
								<option value="odseq">주문번호</option>
								<option value="id">주문자(ID)</option>
								<option value="idname">성명</option>
								<option value="pseq">상품코드</option>
								<option value="deli">배송상태</option>
								<option value="address1">배송지</option>								
 								<option value="address2">상세주소</option>	
								<option value="vip">등급</option>																									
							</select> 
			             	<input type="text" name="odValue" >  
			                <input type="submit" class="success" value="검색">               
			              </form>              	                                
	            		  </li>
	          			   </ul>
             	    </div>                         
                    </div>
                   <div>                	
                   	 <div class="table-responsive">
                   	 <table class="table">
                   	   <tr class="success">
                   	   	 <th>주문번호</th>
                   	   	 <th>배송상태</th>
                   	   	 <th>주문자(ID)</th>
                   	   	 <th>성명</th>
                   	   	 <th>상품코드</th>
                   	   	 <th>상품명</th>
                   	   	 <th>수량</th>
                   	   	 <th>배송지</th>
                   	   	 <th>상세주소</th>
                   	   	 <th>전화번호</th>
                   	   	 <th>VIP</th>
                   	   	 <th>총판매가</th>
                   	   	 <th>주문일</th>
                   	   </tr>
                   	 	 <c:forEach items="${order_detailList}" var="order_detail"> 
                   	 	 <tr> 
	                   	   <td><a href="adminOrder_detailview.od?odseq=${order_detail.odseq}&pseq=${order_detail.pseq}">${order_detail.odseq}</a></td>
	                   	   <td>${order_detail.deli}</td>
	                   	   <td>${order_detail.id}</td>
	                   	   <td>${order_detail.idname}</td>
	                   	   <td>${order_detail.pseq}</td>
	                   	   <td>${order_detail.name}</td>
	                   	   <td>${order_detail.quantity}</td>
	                   	   <td>${order_detail.address1}</td>
	                   	   <td>${order_detail.address2}</td>
	                   	   <td>${order_detail.phone}</td>
	                   	   <td>${order_detail.vip}</td>
	                   	   <td><fmt:formatNumber value="${order_detail.price_out * order_detail.quantity}" pattern="#,###"/>원</td>
	                   	   <td>${order_detail.indate}</td>	                    	   
	                   	  </tr>
                   	   </c:forEach>                 	 
                   	 </table>
   					<section id="pageList" >
						<c:choose>
							<c:when test="${nowPage <=1 }">
							[이전]&nbsp;
							</c:when>
						  	<c:otherwise>
							<a href="adminOrder_detailList.od?page=${nowPage-1 }&odOption=${odOption }&odValue=${odValue }">[이전]</a>&nbsp;
						 	</c:otherwise>
						</c:choose>
						<c:forEach	var="a" begin="${startPage }" end="${endPage }" step="1">
							<c:choose>
								<c:when test="${a==nowPage }">
									[${a }]
								</c:when>
								<c:otherwise>
								<a href="adminOrder_detailList.od?page=${a }&odOption=${odOption }&odValue=${odValue }">[${a }]</a>&nbsp;
								</c:otherwise>	
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${nowPage>=maxPage }">
								[다음]
							</c:when>
							<c:otherwise>
							<a href="adminOrder_detailList.od?page=${nowPage+1 }&odOption=${odOption }&odValue=${odValue }">[다음]</a>
							</c:otherwise>
						</c:choose>
					</section>                                   
                   	</div>                   	 
                    </div>
                    </div>
                    </div>                    
                    </div>
                    </div>
                <hr>


            
 <jsp:include page="/include/AdminFooter.jsp" />   
 
 
 
         