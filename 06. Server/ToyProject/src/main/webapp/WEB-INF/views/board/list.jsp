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
		 	
		 	<h2>Board</h2>
		 	
		 	<c:if test="${map.isSearch == 'y'}">
		 	<div style="text-align: center; margin-bottom: 10px; color: #999">
		 		'${map.word}'으로 검색한 결과 총 ${totalCount}개의 게시물이 발견되었습니다.
		 	</div>
		 	</c:if>
		 	<table class="table table-bordered horizontal">
		 		<tr>
		 			<th>번호</th>
		 			<th>제목</th>
		 			<th>이름</th>
		 			<th>날짜</th>
		 			<th>읽음</th>
		 		</tr>
		 		
		 		
		 		<c:forEach items="${list}" var="dto">

		 		<tr>
		 		
			 		<c:if test="${dto.id == 'admin'}">
		 			<td style="color: tomato; font-weight: bold;">${dto.seq}</td>
			 		</c:if>
			 		
			 		<c:if test="${dto.id != 'admin'}">
			 		<td>${dto.seq}</td>
			 		</c:if>
			 		
		 			<td>
		 			
		 				<!-- depth로 답변글 들여쓰기 -->
		 				<c:if test="${dto.depth > 0}">
		 					<i class="fa-solid fa-caret-right" style="margin-left: ${dto.depth * 20}px;"></i>
		 				</c:if>
		 			
		 				<c:if test="${not empty dto.filename}">
		 					<span style="font-size: 12px;"><i class="fa-solid fa-paperclip"></i></span>
		 				</c:if>
		 				
		 				<a href="/toy/board/view.do?seq=${dto.seq}&isSearch=${map.isSearch}&column=${map.column}&word=${map.word}&page=${nowPage}">${dto.subject}</a>
		 				<c:if test="${dto.commentcount > 0}">
		 				<span class="badge">${dto.commentcount}</span>
		 				</c:if>
		 				
		 				<c:if test="${(dto.isNew * 24) < 3}">
		 					<span style="color: #FF6C6C; font-size: 3px;">&nbsp;<i class="fa-solid fa-n"></i><i class="fa-solid fa-e"></i><i class="fa-solid fa-w"></i></span>
		 				</c:if>
		 				
		 			</td>
		 			<td>${dto.name}</td>
		 			<td>${dto.regdate}</td>
		 			<td>${dto.readcount}</td>
		 		</tr>
		 		</c:forEach>
		 		<c:if test="${list.size() == 0}">
		 		<tr>
		 			<td colspan="5">게시물이 없습니다.</td>
		 		</tr>
		 		</c:if>
		 	</table>
		 	
		 	
		 	<div style="text-align: center;">
				<%--
				<select id="pagebar">
		 			<c:forEach var="i" begin="1" end="${totalPage}">
			 			<option value="${i}">${i}페이지</option>
		 			</c:forEach>
		 		</select>
		 		--%>
		 		${pagebar}
		 	</div>

		 	
		 	<c:if test="${not empty auth}">
			 	<div class="btns">
			 		<button type="button" class="btn btn-primary" onclick="location.href='/toy/board/add.do';"><i class="fas fa-pen"></i> 글쓰기</button>
			 	</div>
		 	</c:if>
			
		 	<div>
		 		<form method="GET" action="/toy/board/list.do">
			 		<table class="search">
			 			<tr>
			 				<td>
			 					<select name="column" class="form-control">
			 						<option value="subject">제목</option>
			 						<option value="content">내용</option>
			 						<option value="name">이름</option>
			 					</select>
			 				</td>
			 				<td>
			 					<input type="text" name="word" class="form-control" required>
			 				</td>
			 				<td>
			 					<button class="btn btn-primary">
			 					검색하기
			 					</button>
			 					<c:if test="${map.isSearch == 'y'}">
			 					<button class="btn btn-secondary" type="button" onclick="location.href='/toy/board/list.do';">
			 					전체글 보기
			 					</button>
			 					</c:if>
			 				</td>
			 			</tr>
			 		</table>
		 		</form>
		 	</div>
		 	
		 	
		</section>
	</main>
	
	<script>
	
		//검색중
		<c:if test="${map.isSearch == 'y'}">
			$('select[name=column]').val('${map.column}');
			$('input[name=word]').val('${map.word}');
		</c:if>
		
		
		$('#pagebar').change(function() {
			
			location.href = '/toy/board/list.do?page=' + $(this).val() + "&column=${map.column}&word=${map.word}";
			
		});
		
		
		$('#pagebar').val(${nowPage});
	
	</script>	
	
</body>
</html>