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
	.table th { width: 120px; }
	.table td { display: flex; }
	.table .form-control { width: 100px; margin-right: 5px; }
	.table td span { display: block; margin-left: 10px; }
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		 	
		 	<h2>회원 가입</h2>
		 	
		 	<form>
		 		<table class="table table-bordered">
		 			<tr>
		 				<th>이름</th>
		 				<td><input type="text" class="form-control"></td>
		 			</tr>
		 			<tr>
		 				<th>아이디</th>
		 				<td>
		 					<input type="text" class="form-control" id="id">
		 					<input type="button" value="중복 검사" class="btn btn-primary" onclick="checkid();">
		 				</td>
		 			</tr>
		 			<tr>
		 				<th>암호</th>
		 				<td><input type="password" class="form-control"></td>
		 			</tr>
		 			<tr>
		 				<th>아이디</th>
		 				<td>
		 					<input type="text" class="form-control" id="id2">
		 					<input type="button" value="중복 검사" class="btn btn-primary" onclick="checkid2();">
		 					<span id="msg"></span>
		 				</td>
		 			</tr>
		 			<tr>
		 				<th></th>
		 				<td></td>
		 			</tr>
		 			<tr>
		 				<th></th>
		 				<td></td>
		 			</tr>
		 			<tr>
		 				<th></th>
		 				<td></td>
		 			</tr>
		 		</table>
		 	</form>
		</section>
	</main>
	
	<script>
		
		function checkid() {
			window.open('/toy/ajax/idcheck.do', 'idcheck', 'width=350 height=300');
		}
		
		function checkid2() {
			
			//Ajax: 아이디 전송 > 결과 반환 -> 페이지를 새로고침하지 않아도 결과 주고받기 가능
			
			ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = m1;
			ajax.open('GET', '/toy/ajax/idcheckok2.do?id=' + $('#id2').val());
			ajax.send();
			//ajax.send('id=' + $('#id2').val()); //POST 방식일 때 QueryString 적기
			
		}
		
		function m1() {
			
			if (ajax.readyState == 4 && ajax.status == 200) {
				
				//$('#msg').text(ajax.responseText);
				if (ajax.responseText == '1') {
					$('#msg').text('이미 사용중인 아이디입니다.');
				} else {
					$('#msg').text('사용 가능한 아이디입니다.');					
				}
			}
		}
	</script>	
	
</body>
</html>