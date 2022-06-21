<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String txt = request.getParameter("txt");
	String bgColor = request.getParameter("bgColor");
	String color = request.getParameter("color");
	String fontSize = request.getParameter("fontSize");
	int btns = Integer.parseInt(request.getParameter("btns"));
	String marginlr = request.getParameter("marginlr");
	String margintb = request.getParameter("margintb");
	String icon = "<i class=\"fa-solid " + request.getParameter("icon") + "\"></i>";
	String borderWidth = request.getParameter("borderWidth");
	String borderColor = request.getParameter("borderColor");
	String borderStyle = request.getParameter("borderStyle");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/jquery-ui.css" />
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/404d069474.js" crossorigin="anonymous"></script>
<style>

	table {
		border-collapse: collapse;
	}
	
	table th {
		border: 1px solid #AAAAAA;
		width: 150px;
		height: 30px;
		font-size: 15px;
	}
	
	table td {
		border: 1px solid #AAAAAA;
		padding: 30px;
		width: 450px;
		text-align: center;
	}
</style>
</head>
<body>
	
	<h1>결과</h1>
	
	<table border width="100%">
		<tr>
			<th>버튼</th>
		</tr>
		<tr>
			<td>
				<% for (int i=0 ; i<btns ; i++) { %>
					<button class="result"></button>
				<% } %>	
			</td>
		</tr>
	</table>
	
	
	<script>
		$('.result').css({
				width: <%= width %>,
				height: <%= height %>,
				'background-color': '<%= bgColor %>',
				color: '<%= color %>',
				'font-size': '<%= fontSize %>px',
				margin: '<%= margintb %>px <%= marginlr %>px <%= margintb %>px <%= marginlr %>px',
				border: '<%= borderWidth %>px <%= borderStyle %> <%= borderColor %>'
		});
		
		$('.result').html('<%= icon %> <%= txt %>');
		
	</script>
</body>
</html>