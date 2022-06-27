<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//1. 인증 티켓을 삭제하기
	
	//A. 속성 하나씩 지워주기
	session.removeAttribute("auth"); //로그아웃
	
	session.removeAttribute("name");
	session.removeAttribute("lv");
	
	//B. 세션을 초기화
	//session.invalidate(); //세션 초기화, but 세션에 지워지면 안 될 정보 있을 수도

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/auth/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!--  -->
	<div class="container">
	
	</div>
	
	<script>
		location.href = 'index.jsp';
	</script>

</body>
</html>