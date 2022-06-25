<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String complete = request.getParameter("complete");
	String seq = request.getParameter("seq");
	int result = 0;
	
	try {
		
		if (complete.equals("y")) {
			complete = "n";
		} else {
			complete = "y";
		}
		
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		String sql = "update tblTodo set complete = ? where seq = ?";
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, complete);
		pstat.setString(2, seq);
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	

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
	
	<!-- editok.jsp -->
	<div class="container">
	
	</div>
	
	<script>
		
		<% if (result > 0) { %>
  		
			location.href = 'list.jsp';
			
		<% } else { %>		
		
			alert('수정에 실패했습니다. 입력하신 정보를 다시 확인해 주세요.');
			history.back();
			
		<% } %>
		
	</script>

</body>
</html>