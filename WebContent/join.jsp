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
<link rel="stylesheet" href="css/login.css" type="text/css" media="all" />
<script src="js/login.js" type="text/javascript"></script>
</head>
<body>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {

							var fullAddr = '';
							var extraAddr = '';

							if (data.userSelectedType === 'R') {
								fullAddr = data.roadAddress;

							} else {
								fullAddr = data.jibunAddress;
							}

							if (data.userSelectedType === 'R') {

								if (data.bname !== '') {
									extraAddr += data.bname;
								}

								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}

								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById('sample6_address').value = fullAddr;

							document.getElementById('sample6_address2').focus();
						}
					}).open();
		}
	</script>
	<%--주소 API 끝나는부분 --%>
	<jsp:include page="include/header.jsp" />
	<div id="container" class="main_container">
		<div style="padding: 20px;">
			<div class="login_join">
				<div class="form_container">
					<form name="join" action="./memberJoinAction.me" method="post">
						<div class="form-group">
							<p class="form_title_p">회원가입</p>
						</div>
						<br>
						<div class="form_item_name">
							<div>
								<label for="id">아이디</label>
							</div>
							<div class="form_item_name">
								<input type="text" class="form-control" name="id" id="id"
									value="${member.id}" placeholder="아이디입력하세요">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label id="pwd">비밀번호</label>
							</div>
							<div class="form_item_name">
								<input type="password" class="form-control" name="pwd" id="pwd"
									value="${member.pwd }" placeholder="비밀번호입력하세요">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label id="name">이름</label>
							</div>
							<div class="form_item_name">
								<input type="text" class="form-control" name="name" id="name"
									value="${member.name}" placeholder="이름입력하세요">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label id="email">이메일</label>
							</div>
							<div class="form_item_name">
								<input type="email" class="form-control" name="email" id="email"
									value="${member.email}" placeholder="이메일입력하세요">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label id="address1">주소</label>
							</div>
							<div class="form_item_name">
								<input type="text" id="sample6_address" placeholder="주소입력하세요"
									name="address1" class="form-control" value="${member.address1}">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label id="address1">상세주소</label>
							</div>
							<div class="form_item_name">
								<input type="text" id="sample6_address2" placeholder="상세주소입력하세요"
									name="address2" class="form-control" value="${member.address2}">
							</div>
						</div>
						
						<div class="form-group">
							<div >
								<label id="phone">전화번호</label>
							</div>
							<div class="form_item_name">
								<input type="text" class="form-control" name="phone" id="phone"
									value="${member.phone}" placeholder="전화번호입력하세요">
							</div>
						</div>
						
						<div class="form-group">
							<div>
								<label id="zip_num">우편번호</label>
							</div>
							<div class="form_item_name">
								<input type="text" id="sample6_postcode" placeholder="우편번호입력하세요"
									name="zip_num" class="form-control" value="${member.zip_num}" />
							</div>
							<br>
							
							<div class="col-sm-3">
								<input type="button" onclick="sample6_execDaumPostcode()"
									value="우편번호 찾기" class="btn btn-primary" />
							</div>
						</div>
						<br>
						
						<div class="form-group">
							<div>
								<input type="submit" class="btn btn-success" value="회원가입" /> <a
									href="index.jsp" class="btn btn-warning">취소</a>
							</div>
						</div>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<jsp:include page="include/footer.jsp" />
</body>
</html>