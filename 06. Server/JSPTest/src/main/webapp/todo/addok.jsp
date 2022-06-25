<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setCharacterEncoding("UTF-8");
	
	String todo = request.getParameter("todo");
	String grade = request.getParameter("grade");
	
	int result = 0;
	
	System.out.println(todo);
	System.out.println(grade);
	
	try {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		
		String sql = "insert into tblTodo (seq, todo, regdate, priority, complete) values (seqTodo.nextVal, ?, default, ?, default)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, todo);
		pstat.setString(2, grade);
		
		result = pstat.executeUpdate();
		
		pstat.close();
		conn.close();
		
	} catch(Exception e) {
		System.out.println(e);
	}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- addok.jsp -->
	<div class="container">
	
	</div>
	
	<script>
	
		<% if (result > 0) { %>
			
		location.href = 'list.jsp';
		
		<% } else { %>		
	
		alert('등록에 실패했습니다. 입력 정보를 다시 확인해 주세요.');
		history.back();
			
		<% } %>
		
	</script>

</body>
</html>