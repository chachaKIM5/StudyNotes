<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//1. 데이터 가져오기
	//2. DB 작업 > select
	//3.1 회원 테이블에 있으면 > 인증 티켓 발급
	//3.2 회원 테이블에 없으면 > X (아무 행동 X)
	//4. 피드백
	
	//1.
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	conn = DBUtil.open();
	
	//로그인 처리 SQL
	/* String sql = "select count(*) from tblUser where id = ? and pw = ?"; */
	String sql = "select * from tblUser where id = ? and pw = ?";
	
	pstat = conn.prepareStatement(sql);
	
	pstat.setString(1, id);
	pstat.setString(2, pw);
	
	rs = pstat.executeQuery();
	
	String name = "";
	int lv = 0;
	
	if (rs.next()) {
		//로그인 성공
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("lv"));
	
		//인증 티켓 발급 > 세션에 개발자가 정한 임의의 값 넣기 > 로그인 완료
		//보통 모든 페이지에서 유용하게 쓰일 수 있을 것 같은 값을 넣는다 = id
		session.setAttribute("auth", id); 	//인증 티켓 = 아이디
		
		session.setAttribute("name", rs.getString("name"));	//계정 정보(이름)
		session.setAttribute("lv", rs.getInt("lv"));		//계정 정보(등급)
		
	} else {
		//로그인 실패
	
		
	}
	
	
	rs.close();
	pstat.close();
	conn.close();
	
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
	
	<!--  -->
	<div class="container">
	
	</div>
	
	<script>
		
		<% if (session.getAttribute("auth") != null) { %>
		
			location.href = 'index.jsp';
			
		<% } %>	
		
		<% if (session.getAttribute("auth") == null) { %>
		
			alert('인증 실패');
			history.back(); //login.jsp
		
		<% } %>
		
	</script>

</body>
</html>