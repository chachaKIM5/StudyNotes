<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

	main {
		width: 840px;
		margin: 0 auto;
	}
	
	main > h1 {
		padding: 50px 0px;
		border-bottom: 1px solid #CCC;
		text-align: center;
	}
	
	#choice {
		margin: 20px 0px;
		display: flex;
		justify-content: right;
	}
	
	#date {
		border: none;
		width: 120px;
		height: 35px;
		text-align: center;
		margin-right: 10px;
	}
	
	
	#contents {
		width: 840px;
		height: 500px;
		display: flex;
	}
	
	li.list-group-item {
	    display: flex;
	    justify-content: center;
	    align-items: center;
		width: 140px;
		height: 55px;	
		border: none;
		border-top: 1px dashed #DDD;
	}
	
	li.list-group-item:last-child {
		border-bottom: 1px dashed #DDD;
	}
	
	#main {
		margin-left: 20px;
		width: 780px;
	}

	
</style>
</head>
<body>
	<!--  -->
   <main>
      <%@ include file="/WEB-INF/views/inc/header.jsp" %>

		
		<h1>매출 현황</h1>
		
		<div id="choice">
			<select id="date">
				<c:forEach var="i" begin="0" end="11">
					<c:if test="${i == 11}">
					<option value="0" selected>${dates[11-i]}</option>
					</c:if>
					
					<c:if test="${i != 11}">
					<option value="${-(11-i)}">${dates[11-i]}</option>
					</c:if>
				</c:forEach>
			</select>
	
			<input type="button" class="btn btn-info" value="조회하기">
		</div>		
      
      
		<div id="contents">
			<div id="menu">
				<ul class="list-group list-group-flush">
					<li class="list-group-item">상품 등록</li>
					<li class="list-group-item">예약 관리</li>
					<li class="list-group-item">매출 현황</li>
					<li class="list-group-item">리뷰 답변</li>
				</ul>
			</div>
			
			
			<div id="main">
				
				<input type="button" value="전체">
				<input type="button" value="숙소">
				<input type="button" value="렌터카">
				<input type="button" value="액티비티">
				<table class="table table-bordered">
					<tr>
						<td>숙소명: 신라호텔 방이름: 301호 가격: 200000원</td>
					
					</tr>
				</table>
			
			
			</div>
				
      	</div>
      	
      	
   </main>
   	  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
   <script>
   
   </script>

</body>
</html>