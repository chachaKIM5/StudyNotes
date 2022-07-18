<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	
	#back {
		width: 1060px;
		height: 900px;
		background-image: url('/tripnow/images/balloons.jpg');
		background-repeat: no-repeat;
		background-size: contain;
	}

	#loginbox {
		width: 400px;
		height: 500px;
		border: none;
		float: right;
		text-align: center;
		margin-top: 50px;
		margin-right: 50px;
		background-color: black;
		opacity: .4;
		box-shadow: rgb(33 37 41 / 10%) 0px 4px 8px 0px;
		padding: 20px;
	}
	
	#loginbox p {
		color: white;
		z-index: 1;
		opacity: 1;
		font-size: 30px;
	}
	
	
</style>
</head>
<body>
	<!--  -->
   <main>
      <%@ include file="/WEB-INF/views/inc/header.jsp" %>
      <div id="back">
      <div id="loginbox">
      	
      	<p>로그인</p>
      
      </div>
      
      <div id="contents">
      
      </div>
      </div>
   </main>
   	  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
   <script>
   
   </script>

</body>
</html>