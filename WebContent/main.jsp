<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <title>Admin Login</title>
    <!-- Bootstrap -->
    <link href="Bootstrap-Admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="Bootstrap-Admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="Bootstrap-Admin/assets/styles.css" rel="stylesheet" media="screen">
  </head>
  <body id="login">
    <div class="container">

      <form class="form-signin" action="adminLoginAction.ad" method="post">
        <h2 class="form-signin-heading  text-center">관리자 로그인</h2>
        <input type="text" class="input-block-level" placeholder="관리자 아이디" name="admin_id" id="admin_id" >
        <input type="password" class="input-block-level" placeholder="비밀번호" name="admin_pwd" id="admin_pwd" >
        <label class="checkbox"> </label>
        <div class="text-center">
        	<button class="btn btn-large btn-primary" type="submit" >로그인</button></div>
      </form>
    </div> <!-- /container -->
    <script src="Bootstrap-Admin/vendors/jquery-1.9.1.min.js"></script>
    <script src="Bootstrap-Admin/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>