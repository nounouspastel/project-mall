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
	//상품종류 중복 체크 안되게 하는 코드
	function checkOnlyOne(element) {
		  
		  const checkboxes 
		      = document.getElementsByName("kind");
		  
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
                            <h4>상품 등록</h4>
                        </div>
                    	</div>
                   
                   <div>
                   <form action="adminProductWrite.ad" method="post" enctype="multipart/form-data"  name="write">	 
                   	 <div class="table-responsive">
                   	 <table class="table">
	                   <tr>
					      <th><label for = "pseq">상품코드</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "pseq" id ="pseq" placeholder="차후 수정 불가능" />
					         <input type="button" value="상품코드 중복확인" id="pseqCheck" name="pseqCheck"  onclick="window.open('product/pseqCheck.jsp?openInit=true','','width=400, height=200')" />
					      </td>
					   </tr>    	 
           				<tr>
					      <th><label for = "name">상품명</label></th>
					      <td class = "td_right">
					         <input type = "text" name = "name" id ="name" />
					      </td>
					   </tr>           			           			
           				<tr>
           				    <th><label for = "kind">상품카테고리</label></th>
					        <td class = "td_right">
					          <input type = "checkbox" name = "kind" id ="kind" value="c" onclick='checkOnlyOne(this)'/>의자(c)
					          <input type = "checkbox" name = "kind" id ="kind" value="t" onclick='checkOnlyOne(this)'/>테이블(t)
					          <input type = "checkbox" name = "kind" id ="kind" value="p" onclick='checkOnlyOne(this)'/>텐트(p)     
					        </td>
           				</tr>		           					        		        				
           				   <tr>
						      <th><label for = "price_in">원가</label></th>
						      <td class = "td_right"><input type = "text" name = "price_in" id ="price_in"/></td> 
						      <th><label for = "price_out">판매가</label></th>
						      <td class = "td_right"><input type = "text" name = "price_out" id ="price_out"/></td>
						   </tr>
           			    <tr>
           				 <th><label for = "content">상세설명</label></th>
           				 <td colspan="5"> 
	                      <textarea id="content" style="width:98%;height:200px;" name="content"></textarea> 
           				 </td>
           				</tr>          				
           			 	<tr>
           				 <th><label for = "image">상품이미지</label></th>
           				 <td colspan="5"> 
	                       <input type="file" name="image" id="image"> 
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
         
 


		

  