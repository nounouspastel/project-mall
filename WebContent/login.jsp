<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css" type="text/css"
	media="all" />
<script src="js/login.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<div id="container" class="main_container">
		<div style="padding: 20px;">
		<div class="login_container">
			<div class="form_container">
				<form name="login" action="./memberLoginAction.me" method="post">
					<div class="form_title_div">
						<p class="form_title_p">로그인</p>
					</div>
					<br>
					<div>
						<div>
							<a class="form_item_name">아이디</a>
						</div>
						<div>
							<input type="text" id="id" name="id" placeholder="아이디를입력하세요"
								class="form-control" />
						</div>
						<div class="form_text_alert_padding">
							<div id="alert_username" class="form_text_alert"></div>
						</div>
					</div>
					<div>
						<div>
							<a class="form_item_name">비밀번호</a>
						</div>
						<div>
							<input type="password" name="pwd" id="pwd" placeholder="비밀번호를입력하세요"
								class="form-control" />
						</div>
						<div class="form_text_alert_padding">
							<div id="alert_password" class="form_text_alert"></div>
						</div>
					</div>
					<br>
					<div>
						<input type="submit" class="btn btn-success" value="로그인" />
							<a href="join.jsp" class="btn btn-warning">회원가입</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<br>
	<br>
	<jsp:include page="./include/footer.jsp" />
</body>
</html>