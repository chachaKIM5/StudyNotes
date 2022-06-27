<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//이름은 session의 auth 값에 넣어뒀는데 등급은 어떻게?
	//방법 A: 필요한 회원 정보를 한두 페이지에서만 사용할 경우
	//		select .. where id = session.getAttribute("id");
	//방법 B: 수많은 페이지에서 사용 -> session에 저장할 시 공간을 차지하니까
	//		미리 session 안에 다른 속성으로 이름, 등급 등 계정 정보를 넣어둠

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
	
	<!-- index.jsp -->
	<div class="container">
		<h1>인증, 허가</h1>
		
		<!-- 
			
			- 국내 사이트: Register, Login, Logout
			- 해외 사이트: Signup, Signin, Signout
			
		-->

		<% if (session.getAttribute("auth") == null) { %>
			<fieldset>
				<input type="button" value="로그인(Log in, Sign in)" class="btn btn-primary" onclick="location.href='login.jsp';">
			</fieldset>
		<% } %>
		
		<% if (session.getAttribute("auth") != null) { %>
			<fieldset>
				<input type="button" value="로그아웃(Log out, Sign out)" class="btn btn-primary" onclick="location.href='logout.jsp';">				

				<hr>

				<div>
					<%= session.getAttribute("name") %>(<%= session.getAttribute("auth") %>) 등급 <%= session.getAttribute("lv") %>
				</div>
			</fieldset>
		<% } %>
				
		<hr>
		
		<!-- 등급 > 허가 -->
		<!-- A. 비노출 방식 -->
		<% if (session.getAttribute("auth") != null && (int)session.getAttribute("lv") < 3) { %>		
			<a href="member.jsp" class="btn btn-success">회원 전용 페이지</a>
		<% } %>

		<hr>
		
		<!-- B. 노출 방식 -->
		<% if (session.getAttribute("auth") == null || (int)session.getAttribute("lv") == 3) { %>		
			<a href="#!" class="btn btn-success" onclick="alert('회원만 접근이 가능합니다.');">회원 전용 페이지</a>
		<% } else { %>
			<a href="member.jsp" class="btn btn-success">회원 전용 페이지</a>
		<% } %>
		
		
		
		<hr>
		
		<% if (session.getAttribute("auth") == null || (int)session.getAttribute("lv") != 1) { %>
			<a href="#!" class="btn btn-success" onclick="alert('관리자만 접근이 가능합니다.');">관리자 전용 페이지</a>
		<% } else { %>
			<a href="admin.jsp" class="btn btn-success">관리자 전용 페이지</a>
		<% } %>
		 
	</div>
	
	<script>
	
	</script>

</body>
</html>