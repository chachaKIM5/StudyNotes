<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>파일 가져오기</h1>
	<div>텍스트 데이터: ${data}</div>
	<div>첨부파일: <a href="/spring/resources/files/${filename}" download>${filename}</a></div>
	<div>첨부파일: <a href="/spring/download?filename=${filename}">${filename}</a></div>
</body>
</html>