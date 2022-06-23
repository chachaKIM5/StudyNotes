<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!-- JSTL 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	

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
	
	<!-- ex23_jstl.jsp -->
	<div class="container">
	
		<h1>JSTL</h1>
		<p>JSTL은 자바(언어)로 하는 프로그래밍 기능의 일부를 태그 형식으로 표현해서 지원하는 기술
		
		<h2>변수 선언</h2>
		<%
			
			int a = 10; //지역 변수
			pageContext.setAttribute("b", 20);
		
		%>
		
		<c:set var="c" value="30" /> <!-- JSTL 변수 -->
		
		<div>a: <%= a %></div>
		<div>a: ${a}</div>
		
		<div>b: <%= pageContext.getAttribute("b") %></div>
		<div>b: ${b}</div>
		
		<div>c: <%= pageContext.getAttribute("c") %></div>
		<div>c: ${c}</div>
		<!-- jstl로 만든 변수는 EL로 출력할 수 있다? jstl은 내장 객체(pageContext)에 값을 넣는 코드를 '태그'로 만든 것 -->
		
		
		<h2>변수 수정하기(값 바꾸기)</h2>
		
		<c:set var="c" value="100" />
		<div>c: ${c}</div> <!-- 100 -->
		
		
		<h2>변수 삭제하기(컬렉션의 요소 삭제)</h2>
		<div>${empty c}</div>
		<c:remove var="c" />
		<div>c: ${c}</div>
		<div>${empty c}</div>
		
		
		<h2>조건문</h2>
		<c:set var="num" value="0" />
		<div>num: ${num}</div>
		
		<!-- 조건은 EL로 입력한다 -->
		<c:if test="${num > 0}">
			<div>${num}은 양수입니다.</div>	
		</c:if>
		
		<c:if test="${num < 0}">
			<div>${num}은 음수입니다.</div>
		</c:if>
		
		<c:if test="${num == 0}">
			<div>${num}은 양수도 아니고 음수도 아닙니다.</div>
		</c:if>
		
		
		<c:set var="a" value="10" />
		<c:set var="b" value="5" />
		
		<!-- XXX 모든 표현은 중괄호 안에서 해결해야 함 -->
		<%-- <c:if test="${a} > ${b}"> --%>
		<!-- jstl로 넣은 변수는 문자열로 들어감 -> 문자열 > 문자열 비교는 형변환 자동으로 일어나지 않음! -->
		<c:if test="${Integer.parseInt(a) > Integer.parseInt(b)}">
			<div>a는 b보다 큽니다.</div>
		</c:if> 
		
		
		
		<h2>조건문</h2>
		
		<c:choose>
			<c:when test="${num > 0}">양수</c:when>
			<c:when test="${num < 0}">음수</c:when>
			<%-- <c:when test="${num == 0}">영</c:when> --%>
			<c:otherwise>영</c:otherwise>			
		</c:choose>
		
		
		
		<h2>반복문 (일반 for문 + 향상된 for문)</h2>
		
		<%-- <c:set var="i" /> --%>
		<!-- 주의 *** step에는 양수만 넣을 수 있다 -->
		<c:forEach var="i" begin="0" end="9" step="1">
			<div>아이템 ${i}</div>
		</c:forEach>	
			
		<%
			String[] names = { "홍길동", "아무개", "하하하", "호호호", "후후후" };
			pageContext.setAttribute("names", names);
		%>
		
		<ol>
			<c:forEach var="names" items="${names}">
				<li> ${names} </li>
			</c:forEach>
		</ol>
		
	</div>
	
	<script>
	
	</script>

</body>
</html>