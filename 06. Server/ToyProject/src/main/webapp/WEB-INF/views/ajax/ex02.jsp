<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h4>기존 방식</h4>
		 	
		 	<div>
			 	<input type="text" id="txt1" value="${cnt}">
			 	<input type="button" value="확인" id="btn1" onclick="location.href='/toy/ajax/ex02data.do';">
			</div>
			<div>
				<input type="text">
			</div> 	
			
			
			<h4>Ajax 방식</h4>
			<div>
				<input type="text" id="txt2">
				<input type="button" value="확인" id="btn2" onclick="test();">
			</div>
			<div>
				<input type="text">
			</div>
			
			<h4>Ajax 방식</h4>
				<input type="button" value="확인" id="btn3" onclick="test2();">
				<span id="txt3"></span>
		
		</section>
	</main>
	
	<script>
	
		let ajax;
		
		function test() {
			
			//Ajax 통신을 지원하는 자바스크립트 객체
			ajax = new XMLHttpRequest();
			
			//alert(ajax);
			if (ajax != null) {
				
				ajax.onreadystatechange = m1;
				ajax.open('GET', '/toy/ajax/ex02data2.do');
				ajax.send();
				
			} else {
				alert('접속한 브라우저가 XMLHttpRequest를 지원하지 않습니다.');
			}
		}
		
		
		function m1() {
			
			if (ajax.readyState == 4 && ajax.status == 200) {
				
				//서버에게 요청한 뒤 돌려받은 데이터
				//alert(ajax.responseText);
				$('#txt2').val(ajax.responseText);
			}
		}
		
		
		function test2() {
			
			ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = m2;
			
			//ajax.open('GET', '/toy/data.txt');
			//ajax.open('GET', '/toy/data.xml');
			//ajax.open('GET', '/toy/data.json');
			//ajax.open('GET', '/toy/data.do');
			
			ajax.open('GET', '/toy/data.txt');
			
			
			ajax.send();
			
		}
		
		function m2() {
			
			console.log('ajax.readyState', ajax.readyState);
			console.log('ajax.status', ajax.status);
			
			if (ajax.readyState == 4 && ajax.status == 200) {
				//ajax.readyState == 4: XMLHttpRequest 객체의 현재 상태, 데이터 응답 완료
				//ajax.status == 200: 서버 측에서 "오류 없이" 응답받음
				
				console.log(ajax.responseText);
				
				
				//데이터의 양에 따른 차이
				//ajax.responseText > 단일 데이터
				//ajax.responseXML  > 다중 데이터
				
				
				$('#txt3').text(ajax.responseText);
			}
			
			console.log('');
		}
		
	</script>	
	
</body>
</html>