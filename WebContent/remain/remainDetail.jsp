<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="no-js">   
    <head>
<jsp:include page="../include/AdminHeader.jsp" />
        <!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="../../Bootstrap-Admin/vendors/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css"></link>

    </head>   
    <body>
<jsp:include page="../include/AdminTopFixMenu.jsp" />            
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
					 <jsp:include page="../include/AdminLeftMenu.jsp" />   
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <div class="alert alert-success">
                            <h4>${remain.pseq}입고 현황 수정</h4>
                        </div>
                    	</div>
                   
                   <div>
                   <form action="adminRemainUpdate.re" method="post" name="form1">	 
                   	 <div class="table-responsive">
                   	 <table class="table">
 	                   <tr>
					      <th><label for = "order_num">순서</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "order_num" id ="order_num" value="${remain.order_num}" readonly="readonly"/>
					      </td>
					   </tr>                     	 
	                   <tr>
					      <th><label for = "pseq">상품코드</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "pseq" id ="pseq" value="${remain.pseq}" />
					      </td>
					   </tr>    	          				
					    <tr>
					      <th><label for = "deli">구분</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "deli" id ="deli" value="${remain.deli}"/>
					      </td>
					    </tr>      					          					   
					    <tr>
					      <th><label for = "quantity">입고수량</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "quantity" id ="quantity" value="${remain.quantity}"/>
					      </td>
					    </tr>
					    <tr>
					      <th><label for = "re_date">입고일자</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "re_date" id ="re_date" value="${remain.re_date}" readonly="readonly"/>
					      </td>
					    </tr>					              				
           			 </table>
           			 
                   	 </div>
                   	<div class="text-center">
						<input type="submit" value="수정하기"  class="btn btn-success" >
						<input type="button" value="목록보기"  class="btn btn-primary" onclick="location.href='adminRemainList.re'">
						<input type="button" value="삭제하기"  class="btn btn-danger" onclick="location.href='adminRemainDelete.re?order_num=${remain.order_num}'">
           			 </div>
            	</form>
           			 
                   </div>
            
                    
                    </div>
                </div>
           
            </div>
            <hr>


<div style="margin-bottom: 150px;">
&nbsp;
</div>
     <!-- FOOTER -->
<nav class="avbar navbar-inverse navbar-fixed-bottom" style="height:50px  ;  background-color:#000  ;">
  <div class="container text-center" style="color:#fff;">
  <p>&nbsp;</p>
   <p><a href="#" style="color:#fff;">Get Set Shopping shop</a></p>  
    <p>&nbsp;</p><p>&nbsp;</p>
  </div>
</nav>
        <!--/.fluid-container-->
        <script src="../../Bootstrap-Admin/vendors/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
        <script src="../../Bootstrap-Admin/vendors/jquery-1.9.1.min.js"></script>
        <script src="../../Bootstrap-Admin/bootstrap/js/bootstrap.min.js"></script>
		<script src="../../Bootstrap-Admin/vendors/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>
		<script src="../../Bootstrap-Admin/vendors/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>
 </body>
</html> 