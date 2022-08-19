<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트립나우</title>
<style>

	#eventcontent {
	    margin-top: 17px;
	    width: 830px;
	    height: 800px;
	    float: left;
	    clear: right;
    
	}
	
	#header{
		
		font-size:25px;
		border-bottom: 1px solid black;
		width:150px;
		margin-bottom:10px;
		
	}


	/* 	table */
	
	#main > table{
		width: 825px;
	}
	
	.table.textcenter th {
		text-align: center;
		background-color: #b7b7b7;
	}
	
	.table.textcenter td {
		text-align: center;
	}
	
	.table.textcenter > tbody > tr:hover {
		background-color: #f3f3f3;
	}
	
	.table.textcenter th:nth-child(1) { width: 70px; }
	.table.textcenter th:nth-child(2) { width: 90px; }
	.table.textcenter th:nth-child(3) { width: auto; }
	.table.textcenter th:nth-child(4) { width: 120px; }
	.table.textcenter th:nth-child(5) { width: 110px; }

	
	.btncolor {
		float: right;
		margin-bottom: 20px;
		margin-right: 10px;
		background-color: #3b4890;
	}
	
	.purple {
		background-color: #f7e8ed;
		font-weight: bold;
	}
	
</style>

</head>
<body>
	<div id="eventcontent">
		<div id="header">쿠폰 및 이벤트</div>
			<div style="float: right; margin-bottom:7px;">
				<form method="GET" action="/tripnow/admin/event/eventmain">
					<table class="search">
						<tr>
							<td>
								<select name="column" class="form-control">
									<option value="eventname">제목</option>
								</select>
							</td>
							<td>
								<input type="text" name="word" class="form-control" >
							</td>
							<td>
								<button class="btn btn-primary">
									검색하기
								</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		<table class="table table-bordered textcenter">
					<tr>
						<th>번호</th>
						<th>유형</th>
						<th>제목</th>
						<th>만료일</th>
						<th>진행상태</th>
					</tr>
					<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.seq}</td>
						<td>${list.value}</td>
						<td>
							<a href="/tripnow/admin/event/event?seq=${list.seq}">
							${list.eventname} 
							</a>
							</td>
						<td>${list.enddate.substring(0,10)}</td>
						<td>${list.finished =='y' ? '진행중' : '종료' }</td>
					</tr>
					</c:forEach>
					
					<c:if test="${list.size() == 0}">
					<tr>
						<td colspan="5">게시물이 없습니다.</td>
					</tr>
					</c:if>
				</table>
				
				<div>
					<input type="button" value="이벤트 작성" class="btn btn-primary btncolor" onclick="location.href='/tripnow/admin/event/eventadd';">
				</div>
				
				 <div style="display: block; text-align: center;">		
					<c:if test="${paging.startPage != 1 }">
						<a href="/tripnow/admin/event/eventmain?nowPage=${paging.startPage - 1 }&column=${paging.column}&word=${paging.word}">&lt;</a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="/tripnow/admin/event/eventmain?nowPage=${p}&column=${paging.column}&word=${paging.word}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a href="/tripnow/admin/event/eventmain?nowPage=${paging.endPage+1 }&column=${paging.column}&word=${paging.word}">&gt;</a>
					</c:if>
				</div>	
				
				
				
	</div>
</body>
</html>















