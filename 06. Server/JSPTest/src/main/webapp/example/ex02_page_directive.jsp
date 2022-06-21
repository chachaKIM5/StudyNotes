<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex02_page_directive.jsp -->
	
	<h1>페이지 지시자</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta molestiae assumenda officia cum nisi optio itaque mollitia quo consequuntur quam aut impedit expedita velit laboriosam dolorem placeat omnis nobis totam at et. Modi nostrum obcaecati consectetur perferendis dolores voluptate ducimus asperiores fugiat explicabo eos odit sint doloribus iusto exercitationem delectus.</p>
	
	<%
	
		//Random rnd = null;
		//System.out.println(rnd.nextInt()); //NullPointerException
		
	%>
	
	<%@ include file="inc/copyright.jsp" %>

</body>
</html>