<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//부모 페이지 영역의 데이터를 조각 페이지에도 전달할 수 있을까?
	//session, application은 당연히 될 테니 '현재 페이지에 종속되는 변수들'만 테스트해 보기!
	
	//결론 -> 모두 된다, but 지역 변수&멤버 변수는 사용하지 않고 pageContext를 가장 많이 쓴다
			
	//1. 지역 변수
	int a = 10;
	
	
	//3. pageContext
	pageContext.setAttribute("c", 30);
	
	
	//4. request
	request.setAttribute("d", 40);
	
%>

<%!

	//2. 멤버 변수
	int b = 20;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- ex21_scope_3.jsp -->
	<div class="container">
		<h1>부모 페이지</h1>
		
		부모 페이지 영역
		
		<hr>
		
		<%@ include file="inc/ex21_sub.jsp" %>
		
		<hr>
		
		부모 페이지 영역
		
	</div>
	
	<script>
	
	</script>

</body>
</html>