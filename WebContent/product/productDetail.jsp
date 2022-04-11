<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="vo.admin.AdminProduct" %>
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
                            <h4>${product.pseq}의 상품 상세 정보</h4>
                        </div>
                    	</div>
                   
                   <div>
                   <form action="" method="post" enctype="multipart/form-data"  name="form1">	 
                   	 <div class="table-responsive">
                   	 <table class="table">
	                   <tr>
					      <th>상품코드</th>
					      <td><input type="text" id="pseq" name="pseq" value="${product.pseq}" readonly="readonly"></td>
					   </tr>    	 
           				<tr>
           				    <th>상품카테고리</th>
					        <td><input type="text" value="${product.kind}" readonly="readonly"></td>
           				</tr>		           				
           				<tr>
					      <th>상품명</th>
					      <td><input type="text" value="${product.name}" readonly="readonly"></td>
					   </tr>	         				
           				   <tr>
						      <th>원가</th>
						      <td><input type="text" value="${product.price_in}" readonly="readonly"></td> 
						      <th>판매가</th>
						      <td><input type="text" value="${product.price_out}" readonly="readonly"></td>  
						   </tr>
           			    <tr>
           				 <th>상세설명</th>
           				 <td colspan="5">
	                      <textarea style="width:98%;height:200px;" readonly="readonly">${product.content}</textarea> 
           				 </td>
           				</tr>          				
           			 	<tr>
           				 <th>상품이미지</th>
           				 <td colspan="5" > 
	                       <input type="hidden" id="image" name="image" value="images/${product.image}"/><img src="images/${product.image}">
           				 </td>
           				</tr>	           							
           			 </table>         			  
                   	 </div>
                   	<div class="text-center">
<input type="button" value="수정하기"  class="btn btn-success" onclick="location.href='adminProductUpdateForm.ad?pseq=${product.pseq}'">
<input type="button" value="목록보기"  class="btn btn-primary" onclick="location.href='adminProductList.ad'">
<input type="button" value="삭제하기"  class="btn btn-danger" onclick="location.href='adminProductDelete.ad?pseq=${product.pseq}'">
    			 	
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
        <script src="../../Bootstrap-Admin/vendors/jquery-1.9.1.min.js"></script>
        <script src="../../Bootstrap-Admin/bootstrap/js/bootstrap.min.js"></script>
        <script src="../../Bootstrap-Admin/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="../../Bootstrap-Admin/assets/scripts.js"></script>

 </body>
</html> 