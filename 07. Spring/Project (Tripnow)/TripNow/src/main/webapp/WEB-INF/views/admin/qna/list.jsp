<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<style>

	#title {
		width: 160px;
		height: 50px;
		margin: 20px auto;
		display: flex;
	}
	
	.table {
		width: 840px;
		margin: 30px auto 10px auto;
		text-align: center;
	}
	
	.table td {
		height: 50px;
		vertical-align: middle;
	}
	
	.table th {
		text-align: center;
		height: 50px;
	}
	
	.table th:nth-child(1) { width: 60px; }
	.table th:nth-child(2) { width: 200px; }
	.table th:nth-child(3) { width: auto; }
	.table th:nth-child(4) { width: 130px; }
	.table th:nth-child(5) { width: 100px; }
	
	.table tr td:nth-child(3) {
		text-align: left;
	}
	
	#btn {
		width: 840px;
		margin: 20px auto 20px auto;
		text-align: right;
	}
	
	ul.pagination {
		justify-content: center;
	}
	
	
</style>
</head>
<body>
	<div id="content">
		<div id="title"><div id="icon"></div><h1>&nbsp;고객 센터</h1></div>
	  	
	  	
	  	<table class="table table-hover">
	  		<thead>
	  			<tr>
	  				<th>글번호</th>
	  				<th>종류</th>
	  				<th>제목</th>
	  				<th>등록일</th>
	  				<th>처리 상태</th>
	  			</tr>
	  			
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${nlist}" var="dto" varStatus="status">
	  					
	  					<tr class="bg-info">
	  						<th>${dto.qseq}</th>
	  						<td>${dto.category}</td>
	  						<td><a href="/tripnow/admin/qna/view/${dto.qseq}?notice=y&page=${nowPage}">${dto.qsubject}</a></td>
	  						<td>${dto.qregdate}</td>
	  						<td>${dto.state}</td>
	  					</tr>
	  				
	  			</c:forEach>
	  			
	  			<c:forEach items="${list}" var="dto" varStatus="status">
	  				
	  					<tr class="question">
	  						<th>${dto.qseq}</th>
	  						<td>${dto.category}</td>
	  						<td><a href="/tripnow/admin/qna/view/${dto.qseq}?notice=n&page=${nowPage}">${dto.qsubject}</a></td>
	  						<td>${dto.qregdate}</td>
	  						<td>${dto.state}</td>
	  					</tr>

	  			</c:forEach>
	  		</tbody>
	  	</table>
	  	
	  	<div id="btn"><input type="button" class="btn btn-info" value="작성하기" onclick="location.href='/tripnow/admin/qna/add'"></div>
	  	
	  		<div style="text-align: center; margin-top: 30px;">
		 		${pagebar}
		 	</div>
	  
	</div>
   
   
   <script>
   
		$('#pagebar').change(function() {
			
			location.href = '/tripnow/admin/qna/list?page=' + $(this).val();
			
		});
		
		
		$('#pagebar').val(${nowPage});
		
   </script>
   
</body>


</html>