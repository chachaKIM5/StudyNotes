<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/toy/asset/css/tagify.css" />
<script src="/toy/asset/js/jQuery.tagify.min.js"></script>
<style>
	.tags-look .tagify__dropdown__item{
	  display: inline-block;
	  border-radius: 3px;
	  padding: .3em .5em;
	  border: 1px solid #CCC;
	  background: #F3F3F3;
	  margin: .2em;
	  font-size: .85em;
	  color: black;
	  transition: 0s;
	}
	 
	.tags-look .tagify__dropdown__item--active{
	  color: black;
	}
	 
	.tags-look .tagify__dropdown__item:hover{
	  background: lightyellow;
	  border-color: gold;
	}
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		
		 	<h2>Board</h2>
		 	
			<form method="POST" action="/toy/board/addok.do" enctype="multipart/form-data">
				<table class="table table-bordered vertical">
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" class="form-control" required autocomplete="off"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" class="form-control" required></textarea></td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="attach" class="form-control"></td>
					</tr>
					<tr>
						<th>태그</th>
						<td><input name="tags" class="form-control"></td>
					</tr>
				</table>
				
				<div class="btns">
					<c:if test="${reply == 1}">
					<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/board/view.do?seq=${pseq}&isSearch=${isSearch}&column=${column}&word=${word}&page=${page}';">
					</c:if>
					
					<c:if test="${empty reply}">
					<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/board/list.do';">
					</c:if>
					
					<input type="submit" value="글쓰기" class="btn btn-primary">
				</div>
				
				<input type="hidden" name="reply" value="${reply}">
				<input type="hidden" name="thread" value="${thread}">
				<input type="hidden" name="depth" value="${depth}">
				
				<input type="hidden" name="pseq" value="${pseq}">
				<input type="hidden" name="isSearch" value="${isSearch}">
				<input type="hidden" name="column" value="${column}">
				<input type="hidden" name="word" value="${word}">
				<input type="hidden" name="page" value="${page}">
				
			</form>
		 	
		</section>
	</main>
	
	
	
	<script>
	
	
		const obj = {
	         dropdown: {
	            classname: 'tags-look',
	            enabled: 0,
	            closeOnSelect: false
	         }
	      };
	   
	      let temp = [];
	      
	      <c:forEach items="${taglist}" var="tag">
	         temp.push('${tag}');
	      </c:forEach>
	      
	      obj.whitelist = temp;
	      
	      $('input[name=tags]').tagify(obj);
	
	</script>	
	
</body>
</html>