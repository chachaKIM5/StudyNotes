<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		
		</section>
	</main>
	
	<script>

	
		<c:if test="${result == 1 && empty pseq}">	
			location.href= '/toy/board/list.do';
		</c:if>
		
		<c:if test="${result == 1 && not empty pseq}">
			location.href= '/toy/board/list.do?isSearch=${isSearch}&column=${column}&word=${word}&page=${page}';
		</c:if>
		
		<c:if test="${result == 0}">
			alert('글쓰기 실패');
			history.back();
		</c:if>
	</script>	
	
</body>
</html>