<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Pragma","no-cache");
 response.setDateHeader("Expires",0);
%>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<body>
<jsp:include page="include/header.jsp" />
<div id="frame">
      <form>
         <div id="frame2">
            <span style="font-size: 16pt; font-weight: bold;">${id }님의정보</span>
            </div>
            </form>
            </div>
    <!-- End All Title Box -->

    <!-- Start My Account  -->
    <div class="my-account-box-main">
        <div class="container">
            <div class="my-account-page">
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <div class="account-box">
                            <div class="service-box">
                                <div class="service-icon">
                                    <a href="parcel.or"> <i class="fa fa-gift"></i> </a>
                                </div>
                                <div class="service-desc">
                                    <h4>내주문정보</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="account-box">
                            <div class="service-box">
                                <div class="service-icon">
                                    <a href="memberViewAction.me?id=${id}"><i class="fa fa-lock"></i> </a>
                                </div>
                                <div class="service-desc">
                                  <h4><a href="memberViewAction.me?id=${id}">내정보 보기</a></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="account-box">
                            <div class="service-box">
                                <div class="service-icon">
                                    <a href="orderList.or"> <i class="fa fa-location-arrow"></i> </a>
                                </div>
                                <div class="service-desc">
                                    <h4>주문내역</h4>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>
<jsp:include page="include/footer.jsp" />
</body>
</html>