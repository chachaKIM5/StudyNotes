<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- ex04.jsp -->
	
	<h1>쿠키 예제</h1>
	
	<form method="POST" action="login.jsp">
		<table border>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<label>
						<input type="checkbox" name="cb" id="cb">
						아이디 기억하기
					</label>
				</td>
			</tr>
		</table>
		
		<input type="button" value="로그인" style="margin-top: 10px;" id="btn">
	</form>
	
	<%= session.getId() %>
	
	<script src="js/cookie.js"></script>
	<script>
	
		const id = document.getElementById('id');
		const pw = document.getElementById('pw');
		const cb = document.getElementById('cb');
		const btn = document.getElementById('btn');
		
		if (getCookie('id') == '') {
			id.focus();		
		} else {
			id.value = getCookie('id');
			pw.focus();
			cb.checked = true;
		}
		
		
		btn.onclick = function() {
			
			if (id.value == 'hong' && pw.value == '1111') {
				
				//아이디 기억하기 체크했는지 확인하기
				if (cb.checked) {
					
					//쿠키에 입력한 아이디 저장하기
					setCookie('id', id.value, 365);
					setCookie('pw', pw.value, 365);
					
					//로그인 페이지로 이동
					
				} else {
					
					//체크 해제하고 로그인 시 -> 저장됐던 아이디 삭제 -> 쿠키에 저장된 아이디 삭제하기
					setCookie('id', '', -1);
				}
				
			} else {
				alert('failed');
			}
			
		};
		
	</script>
</body>
</html>