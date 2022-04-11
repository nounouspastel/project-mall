<%@page import="java.text.DateFormat"%>
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
<html class="js">   
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
                            <h4>입고/출고 현황</h4>
                     </div>
                 <div class="navbar">
                     <div class="navbar-inner">
	                       <ul class="breadcrumb">
	                         <li>
			             <form action="adminRemainList.re" >
							<select name="rOption">
								<option value="order_num">입/출고 전표</option>
								<option value="pseq">상품코드</option>
								<option value="name">상품명</option>
								<option value="kind">상품종류</option>				
							</select> 
			             	<input type="text" name="rValue" >  
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
                   	   	 <th>입/출고 전표 </th>
                   	   	 <th>상품코드 </th>
                   	   	 <th>상품명</th>
                   	   	 <th>상품종류</th>
                   	   	 <th>입고/출고 구분</th>
                   	   	 <th>입고/출고 수량</th>
                   	   	 <th>등록일</th>
                   	   </tr>
	                   <c:forEach var = "remain" items="${remainList}" varStatus="status">
	                   	   <tr>
	                   	   	 <th><a href="adminRemainDetail.re?order_num=${remain.order_num}">${remain.order_num}</a></th>	                   	   
	                   	   	 <th>${remain.pseq}</th>
	                   	   	 <th>${remain.name}</th>
	                   	   	 <th>${remain.kind}</th>
	                   	   	 <th>${remain.deli}</th>
	                   	   	 <th>${remain.quantity}</th>
	                   	   	 <th>${remain.re_date}</th>
	                   	   </tr>  
                   	   </c:forEach>                  	  
                   	 </table>
                   	  <section id="pageList">
						<c:choose>
							<c:when test="${nowPage <=1 }">
							[이전]&nbsp;
							</c:when>
						  	<c:otherwise>
							<a href="adminRemainList.re?page=${nowPage-1 }&rOption=${rOption }&rValue=${rValue }">[이전]</a>&nbsp;
						 	</c:otherwise>
						</c:choose>
						<c:forEach	var="a" begin="${startPage }" end="${endPage }" step="1">
							<c:choose>
								<c:when test="${a==nowPage }">
									[${a }]
								</c:when>
								<c:otherwise>
								<a href="adminRemainList.re?page=${a }&rOption=${rOption }&rValue=${rValue }">[${a }]</a>&nbsp;
								</c:otherwise>	
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${nowPage>=maxPage }">
								[다음]
							</c:when>
							<c:otherwise>
							<a href="adminRemainList.re?page=${nowPage+1 }&rOption=${rOption }&rValue=${rValue }">[다음]</a>
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