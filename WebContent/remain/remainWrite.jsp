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
<script type="text/javascript">
	//입고.출고 중복 체크 안되게 하는 코드
	function checkOnlyOne(element) {
		  
		  const checkboxes 
		      = document.getElementsByName("re_ass");
		  
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
                            <h4>입고/출고 등록</h4>
                        </div>
                    	</div>
                   
                   <div>
                   <form action="adminRemainWrite.re" method="post" name="form1">	 
                   	 <div class="table-responsive">
                   	 <table class="table">
                   	 	<tr>
					      <th><label for = order_num>주문번호</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "order_num" id ="order_num" placeholder="ex)in202202230001" />
					         <input type="button" value="주문번호 중복확인" id="order_numCheck" name="order_numCheck"  onclick="window.open('remain/order_numCheck.jsp?openInit=true','','width=400, height=200')" />
					      </td>
					   </tr>  
	                   <tr>
					      <th><label for = "pseq">상품코드</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "pseq" id ="pseq" placeholder="차후 수정 불가능" />
					      </td>
					   </tr>    	          				
					    <tr>
					      <th><label for = "deli">구분(입고/출고)</label></th>
					      <td class = "td_right">
					          <input type = "checkbox" name = "deli" id ="deli" value="입고" onclick='checkOnlyOne(this)'/>입고
					          <input type = "checkbox" name = "deli" id ="deli" value="출고" onclick='checkOnlyOne(this)'/>출고
					      </td>
					    </tr>      					          					   
					    <tr>
					      <th><label for = "quantity">수량</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "quantity" id ="quantity"/>
					      </td>
					    </tr>          				
           			 </table>
           			 
                   	 </div>
                   	<div class="text-center">
           			 		<input type="submit" value="등록"  class="btn btn-success">
           			 		<input type="reset" value="취소"  class="btn btn-warning">
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