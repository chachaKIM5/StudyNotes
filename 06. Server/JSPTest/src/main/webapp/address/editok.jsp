<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//1. 인코딩 처리
	//2. 데이터 가져오기
	//3. DB 작업
	//	3.1 DB 연결
	//	3.2 SQL
	//	3.3 종료
	//4. 마무리 (사용자 feedback)
	
	
	//1.
	request.setCharacterEncoding("UTF-8");

	//2.
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	
	String seq = request.getParameter("seq"); //hidden 태그로 받은 수정할 사람의 seq
	
	int result = 0;
	
	try {
		//3.
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		String sql = "update tblAddress set name = ?, age = ?, address = ?, gender = ?, tel = ? where seq = ?";
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, name);
		pstat.setString(2, age);
		pstat.setString(3, address);
		pstat.setString(4, gender);
		pstat.setString(5, tel);
		pstat.setString(6, seq);
		
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
	
	<!-- template.jsp > addok.jsp > editok.jsp -->
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
 		//ex) 글쓰기 -> 글쓰기에 성공하였습니다? 이런 알림은 최근 잘 볼 수 없음 -> 사용자가 불편해하기 때문에
 		
  		<% if (result > 0) { %>
  		
			location.href = 'list.jsp';
			
		<% } else { %>		
		
			alert('수정에 실패했습니다. 입력하신 정보를 다시 확인해 주세요.');
			history.back();
			
		<% } %>

	</script>

</body>
</html>