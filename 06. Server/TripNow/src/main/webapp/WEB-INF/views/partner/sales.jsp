<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script src="https://kit.fontawesome.com/404d069474.js" crossorigin="anonymous"></script>
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
		height: auto;
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
	
	#btns ul {
		padding: 0px;
		margin-bottom: 30px;
	}
	
	#btns li {
		display: inline;
		font-size: 18px;
		border-right: 3.5px solid #666;
		padding-right: 20px;
		margin-right: 15px;
	}
	
	#btns li:last-child {
		border: none;
	}
	
	table td:nth-child(2) {
		width: 270px;
	}
	
	table td:last-child {
		width: 150px;
		text-align: right;
	}
	
/* 	table tr:last-child {
		border-bottom: 1px solid #ddd;
	} */
	
	i {
		margin-right: 10px;
	}
	
	.table > tbody > tr > td {
		height: 50px;
		vertical-align: middle;
	}
	
	.selected {
		font-weight: bold;
		color: cornflowerblue;
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
			
			
			<!-- 세자리 쉼표 찍기 -->
			<!-- <fmt:formatNumber type="number" maxFractionDigits="3" value="${price}" /> -->
			
			<div id="main">
				
				<div id="btns">
					<ul>
						<li id="all" class="selected">전체</li>
						<li id="room">숙소</li>
						<li id="car">렌터카</li>
						<li id="act">액티비티</li>
					</ul>
				</div>
				
				<h4><i class="fa-solid fa-angle-right"></i>숙소</h4>
				<table class="table" id="roomlist">
					<tr>
						<td>숙소 정보: 신라호텔 301호</td>
						<td>예약일자: 2022-07-12 ~ 2022-07-13</td>
						<td>가격: 200000원</td>
					</tr>
					<tr>
						<td>숙소 정보: 신라호텔 301호</td>
						<td>예약일자: 2022-07-12 ~ 2022-07-13</td>
						<td>가격: 200000원</td>
					</tr>
					<tr>
						<td>숙소 정보: 신라호텔 301호</td>
						<td>예약일자: 2022-07-12 ~ 2022-07-13</td>
						<td>가격: 200000원</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>합계: 600000원</td>
					</tr>
				</table>
				
				<h4><i class="fa-solid fa-angle-right"></i>렌터카</h4>
				<table class="table" id="carlist">
					<tr>
						<td>차량 정보: 아반떼(가솔린)</td>
						<td>예약일자: 2022-07-12 ~ 2022-07-13</td>
						<td>가격: 250000원</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>합계: 250000원</td>
					</tr>
					
				</table>
				
				<h4><i class="fa-solid fa-angle-right"></i>액티비티</h4>
				<table class="table" id="actlist">
					<tr>
						<td>액티비티 정보: 신나는 가평 수상레저
						<td>예약일자: 2022-07-12</td>
						<td>가격: 25000원</td>
					</tr>
					
					<tr>
						<td></td>
						<td></td>
						<td>합계: 25000원</td>
					</tr>
				</table>
			
			
			<h4 style="text-align: right; font-weight: bold;">총 합계: 1150000원</h4>
			</div>
				
      	</div>
      	
      	
   </main>
   	  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
   <script>
   
   </script>

</body>
</html>