<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//1. 인코딩 처리 -> 필요없음, 글번호만 넘어왔기 때문에

	
	//2. 데이터 가져오기
	//3. DB 작업
	//	3.1 DB 연결
	//	3.2 SQL
	//	3.3 종료
	//4. 마무리 (사용자 feedback)
	
	
	//2.	
	String seq = request.getParameter("seq"); 
	
	int result = 0;
	
	try {
		//3.
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		String sql = "delete from tblAddress where seq = ?";
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, seq);
		
		result = pstat.executeUpdate();
		
		
		//4. -> <Script>에서


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
<title>주소록</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<!-- template.jsp > addok.jsp > editok.jsp > delok.jsp -->
	<main>
		<header>
			<%@ include file="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				
				<!-- 4-B. html로 피드백 -->
<%--
 				<% if (result > 0) { %>
					<div><h3>추가되었습니다.</h3></div>
					<a href="list.jsp">목록 보기</a>
				<% } else { %>
					<div><h3>수정에 실패했습니다. 입력하신 정보를 다시 확인해 주세요.</h3></div>
					<a href="#!" onclick="history.back();">돌아가기</a>
				<% } %>
				--%>
				
			</div>
		</section>
	</main>
	
	<script>
		
 		//4-A. 자바스크립트로 피드백
<%--
  		<% if (result > 0) { %>
			alert('추가되었습니다.');
			location.href = 'list.jsp';
		<% } else { %>		
			alert('수정에 실패했습니다. 입력하신 정보를 다시 확인해 주세요.');
			history.back();
		<% } %>
		--%>
		
		
 		//4-C. 자바스크립트 - 성공 피드백 없이 바로 목록 띄우기 (요즘 스타일!)

 		
  		<% if (result > 0) { %>
  		
			location.href = 'list.jsp';
			
		<% } else { %>		
		
			alert('삭제에 실패했습니다. 입력하신 정보를 다시 확인해 주세요.');
			history.back();
			
		<% } %>

	</script>

</body>
</html>