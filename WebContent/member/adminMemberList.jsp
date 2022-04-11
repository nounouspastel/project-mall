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
                            <h4>회원리스트</h4>
                        </div>                      
                  <div class="navbar">
                     <div class="navbar-inner">
	                       <ul class="breadcrumb">
	                         <li>
			             <form action="adminMemberList.mb" >
							<select name="mOption">
								<option value="id">아이디</option>
								<option value="name">이름</option>
								<option value="address1">주소</option>								
 								<option value="address2">상세주소</option>	
								<option value="phone">전화번호</option>	
								<option value="vip">등급</option>	
								<option value="indate">가입일</option>																										
							</select> 
			             	<input type="text" name="mValue" >  
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
                   	   	 <th>아이디</th>
                   	   	 <th>이름</th>
                   	   	 <th>이메일</th>
                   	   	 <th>우편번호</th>
                   	   	 <th>주소</th>
                   	   	 <th>상세주소</th>
                   	   	 <th>전화번호</th>
                   	   	 <th>등급</th>
                   	   	 <th>가입일</th>
                   	   </tr>					   
                   	 	 <c:forEach items="${memberList}" var="member"> 
	                   	  <tr>
						   <td>${member.id}</td>	
	                   	   <td>${member.name}</td>
	                   	   <td>${member.email}</td>
	                   	   <td>${member.zip_num}</td>
	                   	   <td>${member.address1}</td>
	                   	   <td>${member.address2}</td>
	                   	   <td>${member.phone}</td>
	                   	   <td>${member.vip}</td>
	                   	   <td>${member.indate}</td>                    	   
	                   	  </tr>
                   	   </c:forEach>
                   	 </table>
   					<section id="pageList" >
						<c:choose>
							<c:when test="${nowPage <=1 }">
							[이전]&nbsp;
							</c:when>
						  	<c:otherwise>
							<a href="adminMemberList.mb?page=${nowPage-1 }&mOption=${mOption }&mValue=${mValue }">[이전]</a>&nbsp;
						 	</c:otherwise>
						</c:choose>
						<c:forEach	var="a" begin="${startPage }" end="${endPage }" step="1">
							<c:choose>
								<c:when test="${a==nowPage }">
									[${a }]
								</c:when>
								<c:otherwise>
								<a href="adminMemberList.mb?page=${a }&mOption=${mOption }&mValue=${mValue }">[${a }]</a>&nbsp;
								</c:otherwise>	
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${nowPage>=maxPage }">
								[다음]
							</c:when>
							<c:otherwise>
							<a href="adminMemberList.mb?page=${nowPage+1 }&mOption=${mOption }&mValue=${mValue }">[다음]</a>
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
 
 
 
         