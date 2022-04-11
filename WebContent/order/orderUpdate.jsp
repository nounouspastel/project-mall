<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String pseq = request.getParameter("pseq");
%>     
<!DOCTYPE html>
<html class="no-js">   
    <head>
<jsp:include page="../include/AdminHeader.jsp" />
        <!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="../../Bootstrap-Admin/vendors/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css"></link>

    </head>   
    <body>
<jsp:include page="../include/AdminTopFixMenu.jsp" />   
<script type="text/javascript">
	function checkOnlyOne(element) {
		  
		  const checkboxes 
		      = document.getElementsByName("deli");
		  
		  checkboxes.forEach((cb) => {
		    cb.checked = false;
		  })
		  
		  element.checked = true;
		}
</script>           
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
					 <jsp:include page="../include/AdminLeftMenu.jsp" />   
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <div class="alert alert-success">
                            <h4>배송상태 수정</h4>
                        </div>
                    	</div>
                   
                   <div>
                   <form action="adminOrder_detailUpdate.od" method="post" name="form1">	 
                   	 <div class="table-responsive">
                   	 <table class="table">
	                   <tr>
					      <th><label for = "odseq">주문번호</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "odseq" id ="odseq" value="${order_detail.odseq}" readonly="readonly" /><small>(수정불가)</small>
					      </td>
					   </tr>
					   <tr>
					      <th><label for = "pseq">상품코드</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "pseq" id ="pseq" value="<%=pseq %>" readonly="readonly" /><small>(수정불가)</small>
					      </td>
					   </tr>    	 
           				<tr>
           				    <th><label for = "deli">배송상태</label></th>
					        <td class = "td_right">
					          <input type = "checkbox" name = "deli" id ="deli" value="배송중" onclick='checkOnlyOne(this)'/>배송중
					          <input type = "checkbox" name = "deli" id ="deli" value="배송완료" onclick='checkOnlyOne(this)'/>배송완료     
					        </td>
           				</tr>		           				         							
           			 </table>
           			 
                   	 </div>
                   	<div class="text-center">
           			 		<input type="submit" value="등록"  class="btn btn-success">
	 						<input type="button" value="목록보기"  class="btn btn-primary" onclick="location.href='adminOrder_detailList.od'">
							<input type="button" value="삭제하기"  class="btn btn-danger" onclick="location.href='adminOrder_detailDelete.od?odseq=${order_detail.odseq}&pseq=<%=pseq%>'">
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
   <p ><a href="" style="   color:#fff;">Get Set Shopping shop</a></p>  
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