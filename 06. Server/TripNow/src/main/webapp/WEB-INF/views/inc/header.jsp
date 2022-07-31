<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<span id="logo"><a href="/tripnow/home/main.do">TripNow</a></span>
	<ul id="membermenu">
	
	
		<c:if test="${empty auth}">
			<li><a href="/tripnow/member/login.do">로그인</a></li>
			<li><a href="/tripnow/member/memberadd.do">회원가입</a></li>
		</c:if>

		<c:if test="${not empty auth}">
			<li><a href="/tripnow/member/logout.do">로그아웃</a></li>
		</c:if>
		
		<li>
		<c:if test="${empty auth}">
			<a href="/tripnow/member/login.do">
			마이페이지
			</a>
		</c:if>
		<c:if test="${not empty auth}">
			<a href="/tripnow/mypage/mypagemain.do">
			마이페이지
			</a>
		</c:if>
		</li>
		<li>쿠폰함</li>
		<c:if test="${not empty auth and grade == 1}">
			<li>[Admin Mode]</li>
		</c:if>
	</ul>
	<ul id="mainmenu">
		<li><a href="/tripnow/home/main.do">국내숙소</a></li>
		<li>액티비티</li>
		<li>렌터카</li>
		<li>커뮤니티</li>
		<li>이벤트</li>
		<c:if test="${not empty auth and grade == 2}">
			<li><a href="/tripnow/partner/partnermain.do">내 상품 확인</a></li>
		</c:if>
	</ul>
</header>