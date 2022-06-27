<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String classname = "";

	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	try {
		
		conn = DBUtil.open();
		String sql = "select * from tblTodo order by regdate";
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		
	} catch(Exception e) {
		System.out.println(e);
	}
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<h1>Todo <small>List</small></h1>
		
		<table class="table table-bordered list">
			
			<tr>
				<th>★</th>
				<th>할일</th>
				<th>날짜</th>
			</tr>
			
			<% while (rs.next()) { 
			
				if (rs.getString("complete").equals("y")) {
					 classname = "complete";

				} else { 
					 classname = "";	 
				}
			%>
								
				<tr class="<%= classname %>">
					<td><%= rs.getString("priority") %></td>
					<td onclick="changeComplete('<%= rs.getString("complete") %>', <%= rs.getString("seq") %>)"><%= rs.getString("todo") %></td>
					<td><%= rs.getString("regdate") %></td>
				</tr>
				
			<% } %>
			
		</table>
		
		<div class="btns">
			<input type="button" value="등록하기"
				class="btn btn-warning" onclick="location.href='add.jsp';">
		</div>
	</main>
	
	<script>
		
		function changeComplete(complete, seq) {
			
			event.target.parentElement.classList.toggle("complete");
			location.href = 'editok.jsp?complete=' + complete + '&seq=' + seq;

		};
		
	</script>

</body>
</html>
















