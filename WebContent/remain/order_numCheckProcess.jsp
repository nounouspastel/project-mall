<%-- idCheck에서 id중복값을 확인 후 다시 idChek로 전환해주는 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String chk_order_num = request.getParameter("order_numCheck");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select * from remain where order_num=?";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/embed21wyl");
		conn = ds.getConnection();
		
		pstmt=conn.prepareStatement(sql);  //변수가 들어가는 쿼리문일 경우에는 sql객체를 생성하여 넣는게 더 좋다.
		pstmt.setString(1, chk_order_num);

		rs=pstmt.executeQuery();		//execute=실행시킨다 qrery 쿼리문을

		if(rs.next()){                 //아이디 사용 불가
//			out.println("<script>");			
//			out.println("alert('아이디 사용이 불가능합니다.')");	
//			out.println("</script>");
			response.sendRedirect("order_numCheck.jsp?chk_order_num="+chk_order_num+"&useble=no");
		}else{                          //아이디 사용 가능
//			out.println("<script>");
//			out.println("alert('아이디 사용이 가능합니다.')");	
//			out.println("</script>");
			response.sendRedirect("order_numCheck.jsp?chk_order_num="+chk_order_num+"&useble=yes");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) 			//NullPointerException을 방지하기 위해서 사용
			pstmt.close();
			if(conn != null)
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>