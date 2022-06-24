<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setCharacterEncoding("UTF-8");

	String subject = "";
	String attach = "";
	
	String path = application.getRealPath("/gallery/images");
	int size = 1024 * 1024 * 100;
	
	MultipartRequest multi = new MultipartRequest(
								request,
								path,
								size,								
								"UTF-8",
								new DefaultFileRenamePolicy());
			
	subject = multi.getParameter("subject");
	attach = multi.getFilesystemName("attach");
	
	int result = 0;
	
	try {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		
		String sql = "insert into tblGallery (seq, filename, subject, regdate) values (seq.nextVal, ?, ?, default)";
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, attach);
		pstat.setString(2, subject);
		
		result = pstat.executeUpdate();
		
		pstat.close();
		conn.close();
		
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
	
	<!--  -->
	<div class="container">
	
	</div>
	
	<script>
	
		<% if (result > 0) { %>
	  		
			location.href = 'list.jsp';
			
		<% } else { %>		
		
			alert('등록에 실패했습니다. 입력 정보 및 첨부 파일을 다시 확인해 주세요.');
			history.back();
			
		<% } %>
	</script>

</body>
</html>