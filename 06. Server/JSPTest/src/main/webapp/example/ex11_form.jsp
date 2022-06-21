<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/jquery-ui.css" />
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/404d069474.js" crossorigin="anonymous"></script>
</head>
<style>
	table {
		border-collapse: collapse;
	}
	
	table th {
		border: 1px solid #AAAAAA;
		width: 150px;
		font-size: 15px;
	}
	
	table td {
		border: 1px solid #AAAAAA;
		padding: 8px;
		width: 450px;
	}
	
	input {
		padding: 3px;
	
	}
	
	input[type='number']{
		width: 100px;
		height: 25px;
		text-align: right;
	}
	
	input[type='color']{
		width: 50px;
		height: 25px;
	}
	
	input[type='text'] {
		width: 200px;
		height: 25px;
	}
	
	input[type='range'] {
		width: 450px;
	}
	
	span {
		margin-bottom: '30px';
	}

	
</style>
<body>

	<form method="POST" action="ex11_ok.jsp">
	
	<h1>버튼 만들기</h1>
	
	<table border width="600">
	
		<tr>
			<th>너비(px)</th>
			<td><input type="number" name="width" step="5" min="10" max="200"></td>
		</tr>
		<tr>
			<th>높이(px)</th>
			<td><input type="number" name="height" step="5" min="10" max="200"></td>
		</tr>
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" autocomplete= "off"></td>
		</tr>
		<tr>
			<th>배경색</th>
			<td><input type="color" name="bgColor"></td>
		</tr>
		<tr>
			<th>글자색</th>
			<td><input type="color" name="color"></td>
		</tr>
		<tr>
			<th>글자 크기(px)</th>
			<td><input type="number" min="5" max="25" name="fontSize"></td>
		</tr>
		<tr>
			<th>버튼 개수(ea)</th>
			<td><input type="number" min="1" max="10" name="btns"></td>
		</tr>
		<tr>
			<th>버튼 간격</th>
			<td>
				<p>좌우 간격:</p>
				<input type="range" name="marginlr" value="0">
				<p>상하 간격:</p>
				<input type="range" name="margintb" value="0">
			</td>
		</tr>
		
		<tr>
			<th>아이콘</th>
			<td>
				<label><input type="radio" name="icon" value="">없음</label>
				<label><input type="radio" name="icon" value="fa-heart"><i class="fa-solid fa-heart"></i></label>
				<label><input type="radio" name="icon" value="fa-headphones-simple"><i class="fa-solid fa-headphones-simple"></i></label>
				<label><input type="radio" name="icon" value="fa-camera"><i class="fa-solid fa-camera"></i></label>
				<label><input type="radio" name="icon" value="fa-video"><i class="fa-solid fa-video"></i></label>
				<label><input type="radio" name="icon" value="fa-magnet"><i class="fa-solid fa-magnet"></i></label>
			</td>
		</tr>
		
		<tr>
			<th>테두리</th>
			<td>
				<p>테두리 설정</p>
					<span>색상: </span> <input type="color" name="borderColor"><br><br>
					<span>종류: </span> <select name="borderStyle">
											<option value="solid">실선</option>
											<option value="dashed">쇄선</option>
											<option value="dotted">점선</option>
									   </select><br><br>
					<span>두께: </span> <input type="number" name="borderWidth" min="0" max="10" value="1">

			</td>
	</table>		
	
	<input type="submit" value="만들기">
	</form>
	
</body>
</html>