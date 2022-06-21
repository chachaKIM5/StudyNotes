<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%

	//한글 인코딩
	request.setCharacterEncoding("UTF-8");

	//텍스트 박스
	//1. 입력하면 > 입력값 반환
	//2. 입력하지 않으면 > "" 반환
	String txt1 = request.getParameter("txt1");
	
	//암호 박스
	String txt2 = request.getParameter("txt2");
	
	//다중 텍스트
	String txt3 = request.getParameter("txt3");
	txt3 = txt3.replace("\r\n", "<br>");
	
	//체크 박스
	//1. value 있을 때
	//- 체크 O > value 반환
	//- 체크 X > null 반환
	//2. value 없을 때
	//- 체크 O > "on" 반환
	//- 체크 X > null 반환
	String cb1 = request.getParameter("cb1");
	String cb2 = request.getParameter("cb2");
	
	
	//체크 박스들
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	String cb5 = request.getParameter("cb5");
	
	String hobby = cb3 + ", " + cb4 + ", " + cb5;
	
	hobby = "";
	
	for (int i=6 ; i<=8 ; i++) {
		hobby += request.getParameter("cb" + i) + ",";
	}

	
	//같은 name이 여러 개 전송된 경우
	String[] hobbies = request.getParameterValues("cb9");
	
	
	//라디오 버튼
	String gender = request.getParameter("rb");
	
	//셀렉트 박스
	String sel1 = request.getParameter("sel1");
	
	//셀렉트 박스 + multiple
	String[] sel2 = request.getParameterValues("sel2");

	//히든 태그
	String id = request.getParameter("id");
	
	//그 외 나머지 태그 (색상 태그)
	String color = request.getParameter("color");
	
	
	//사용자 정의 컨트롤
	String left = request.getParameter("left");
	String top = request.getParameter("top");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color: <%= color %>;
	}
</style>
</head>
<body>
	<!-- ex10_ok.jsp -->
	
	<h1>결과</h1>
	
	<h3>텍스트 박스</h3>
	<div><%= txt1 %></div>
	
	<h3>암호 박스</h3>
	<div><%= txt2 %></div>
	
	<h3>다중 텍스트</h3>
	<div><%= txt3 %></div>
	
	<h3>체크 박스</h3>
	<div><%= cb1 %>, <%= cb2 %></div>
	
	<h3>체크 박스들</h3>
	<div><%= hobby %></div>
	
	<h3>체크 박스들</h3>
	<div><%= Arrays.toString(hobbies) %></div>
	
	<h3>라디오 버튼</h3>
	<div><%= gender %></div>	
	
	<h3>셀렉트 박스</h3>
	<div><%= sel1 %></div>
	
	<h3>셀렉트 박스</h3>
	<div><%= Arrays.toString(sel2) %></div>
	
	<h3>히든 태그</h3>
	<div><%= id %></div>
	
	<h3>색상</h3>
	<div><%= color %></div>
	
	<h3>좌표</h3>
	<div><%= left %>, <%= top %></div>
	
</body>
</html>