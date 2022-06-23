<%@page import="com.test.jsp.Student"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp"%>
<style>
</style>
</head>
<body>

	<!-- ex29_el.jsp -->
	<div class="container">

		<h1>EL</h1>

		<%
		//자바 데이터
		int a = 10;
		//pageContext 안에 자바데이터를 넣고 EL 사용해 보기
		pageContext.setAttribute("a", a+100);

		//내장 객체 데이터
		pageContext.setAttribute("b", 20);

		request.setAttribute("c", 30);

		session.setAttribute("d", 40);
		%>

		<h2>표현식</h2>
		<div>
			a:
			<%=a%></div>
		<div>
			pageContext의 b:
			<%=pageContext.getAttribute("b")%></div>

		<h2>EL</h2>
		<div>a: ${a}</div>
<%-- 		<div>b: ${pageContext.getAttribute("b")}</div> --%>
		<div>b: ${b}</div>
		<div>c: ${c}</div>
		<div>d: ${d}</div>


		<hr>

		<h2>EL 기능들</h2>

		<h3>EL 연산</h3>

		<!-- 표현식 -->
		<div>
			a + 10 =
			<%=a + 10%></div>
		<div>
			b + 10 =
			<%=(int) pageContext.getAttribute("b") + 10%></div>
		<!-- 내장 객체에 담은 데이터는 object형 -> 형변환 필요-->

		<!-- EL 연산 = 자동 형변환! -->
		<div>b + 10 = ${b + 10}</div>
		<div>b - 10 = ${b - 10}</div>
		<div>b * 10 = ${b * 10}</div>
		<div>b / 10 = ${b / 10}</div>
		<div>b mod 10 = ${b mod 10}</div>

		<hr>

		<!-- EL 비교 연산 -->
		<div>b &gt; 10 = ${d > 10}</div>
		<div>b &lt; 10 = ${d < 10}</div>

		<div>b &gt; 10 = ${d gt 10}</div>
		<div>b &lt; 10 = ${d lt 10}</div>

		<hr>

		<!-- EL 논리 연산 -->
		<div>${true && false}</div>
		<div>${true || false}</div>
		<div>${!true}</div>

		<hr>

		<!-- EL 3항 연산 -->
		<div>${b > 0 ? "양수" : "음수"}</div>

		<hr>

		<!-- EL equal 연산 -->
		<%--  		<div>${"홍길동".equals("홍길동")}</div> --%>
		<div>${"홍길동" == "홍길동"}</div>




		<%
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("name", "홍길동");
		map.put("age", "20");
		map.put("job", "학생");

		/* EL을 사용하려면 내장 객체에 담기 */
		pageContext.setAttribute("map", map);
		%>

		<h2>HashMap 출력 지원</h2>
		<div>
			이름:
			<%=map.get("name")%></div>
		<div>
			나이:
			<%=Integer.parseInt(map.get("age")) - 1%></div>
		<!-- 만 나이 출력 -->
		<div>
			직업:
			<%=map.get("job")%></div>

		<!-- EL로 출력 -> get 메소드 없이도 [], 프로퍼티로 표현 가능, 형변환도 알아서 -> 생산성 ▲ -->
		<div>이름: ${map.get("name")}</div>
		<div>나이: ${map["age"]-1}</div>
		<div>직업: ${map.job}</div>




		<%
		Student s = new Student();

		s.setName("홍길동");
		s.setKor(100);
		s.setEng(90);
		s.setMath(80);

		request.setAttribute("s", s);
		%>

		<h2>자바 객체 출력 지원</h2>

		<div>
			이름:
			<%=s.getName()%></div>
		<div>
			총점:
			<%=s.getKor() + s.getEng() + s.getMath()%></div>

		<div>이름: ${s.getName()}</div>
		<div>이름: ${s["name"]}</div>

		<div>이름: ${s.name}</div>
		<!-- Student 객체의 멤버변수에 접근한 것 X!! (private로 생성했기 때문에) -> name > get + Name -> getName() -->

		<!-- getter/setter를 만들지 않은 Student 객체의 s.gender? -->
		<div>성별: ${s.gender}</div>
		<!-- 에러: [gender] 특성이 [com.test.jsp.Student] 유형에 없습니다. -> s.getGender() 호출한 것 -->
		<!-- Getter를 만들면 ? s.gender 에러 X -->

		<!-- Student 객체에 String nick 멤버변수가 없지만 getNick이라는 getter만 생성하면? -->
		<div>별명: ${s.nick}</div>

		<div>총점: ${s.kor + s.eng + s.math}</div>


		<hr>

		<%
		Student s2 = null;
		pageContext.setAttribute("s2", s2);
		%>

		<div><%=s2 == null%></div>
		<div>${s2 == null}</div>
		<div>${empty s2}</div>
		<!-- EL에서 권장하는 연산자 "empty" -->

		<!-- s3을 정의한 적 없는데 비교가 가능한 이유? EL 안의 s3은 변수가 아니라 내장객체를 의미하기 때문에 -->
		<div>${s3 == null}</div>
		<div>${empty s3}</div>



		<hr>


		<%
			//key값이 같아서 충돌하면? -> 생명주기가 짧은 내장 객체가 이긴다
			//충돌했을 때 사용하고 싶은 내장 객체 지정하기 -> requestScope.color처럼 내장객체명Scope.key이름으로 지정
			pageContext.setAttribute("color", "red");
			request.setAttribute("color", "gold");
			session.setAttribute("color", "cornflowerblue");
			application.setAttribute("color", "yellowgreen");
		%>

		<h2>내장 객체의 우선 순위</h2>

		<div style="background-color:<%=pageContext.getAttribute("color")%>">Lorem
			ipsum dolor sit amet, consectetur adipisicing elit. Earum quis eos
			excepturi debitis sint nihil et. Accusamus hic aperiam illum iste
			saepe ullam. Placeat et ullam deleniti. Aut quas explicabo.</div>
			
		<br>

		<div style="background-color: ${color}">Lorem ipsum dolor sit
			amet, consectetur adipisicing elit. Vel accusantium consequuntur
			illum porro in voluptate nemo consectetur nulla commodi fugit
			inventore temporibus esse maiores alias at quos maxime. Beatae
			itaque!</div>

		<script>
			
		</script>
</body>
</html>