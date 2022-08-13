<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<tiles:insertAttribute name="asset" />
</head>
<body>
	<main>

		<div id="main">
			<tiles:insertAttribute name="mainmenu" />
			<tiles:insertAttribute name="submenu" />
			<tiles:insertAttribute name="content" />
		</div>
	</main>

</body>
</html>