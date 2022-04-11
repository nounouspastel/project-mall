<%-- joinForm에서 아이디 중복확인을 클릭하면 나타나는 페이지 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String openInit = "false";
	if(request.getParameter("openInit") != null){
		openInit = "true";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="init()">
<form action="pseqCheckProcess.jsp" method="post">
	<input type="text" name="pseqCheck" id="pseq"/> &nbsp; 
	<input type="submit" value="중복확인">
</form>
<%
	if(request.getParameter("chk_pseq") != null && 
		!request.getParameter("chk_pseq").equals("")){    //넘어오는 값이 null이 아니거나 빈값이 없으면 실행
		String chk_pseq = request.getParameter("chk_pseq");
		String useble = request.getParameter("useble");
		
		out.println("<hr>");
		if(useble.equals("yes")){
			out.println("<h3>"+chk_pseq+"는 사용 가능한 상품코드입니다.");
			out.println("<a href=\"javascript:ok('"+chk_pseq+"')\">사용하기</a></h3>");
		}else{
			out.print("<h3>"+chk_pseq+"는 사용 불가능한 상품코드입니다. 다시 검색하세요.</h3>");			
		}
	}
%>
<script>
	function init(){
		if(<%=openInit%>){
			document.getElementById("pseq").
			value=opener.document.getElementById("pseq").value;			
		}
	}

	function ok(v){
		opener.document.getElementById("pseq").value=v;
		window.close();
		
	}
</script>
</body>
</html>