<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.File"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String seq = request.getParameter("seq");
	String filename = request.getParameter("filename");
	int result = 0;

	
	
	try {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		
		
		
		//파일 삭제
		
		String path = application.getRealPath("/gallery/images");
		File img = new File(path + "/" + filename);
		
		img.delete();
		
		
		//DB 삭제
		conn = DBUtil.open();
		String sql = "delete from tblGallery where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, seq);
		
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
	
	<!-- delok.jsp -->
	<div class="container">
	
	</div>
	
	<script>
		
		<% if (result > 0) { %>
  		
			location.href = 'list.jsp';
		
		<% } else { %>		
		
			alert('삭제에 실패했습니다.');
			history.back();
			
		<% } %>
	
	</script>

</body>
</html>