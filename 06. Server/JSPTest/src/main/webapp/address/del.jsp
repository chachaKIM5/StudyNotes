<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//1. 데이터 가져오기 (?seq=5)
	//2. delok.jsp?seq=5 -> delok에게 전달하기
	
	String seq = request.getParameter("seq");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- template.jsp > del.jsp -->
	<main>
		<header>
			<%@ include file="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				
				<div class="btns">
					<input type="button" value="취소하기" class="btn btn-secondary" onclick="location.href='/jsp/address/list.jsp';">
					<input type="button" value="삭제하기" class="btn btn-primary" onclick="location.href='/jsp/address/delok.jsp?seq=<%= seq %>';">
				</div>
			</div>
		</section>
	</main>
	
	<script>
	
	</script>

</body>
</html>