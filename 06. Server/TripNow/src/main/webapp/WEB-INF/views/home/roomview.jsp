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
   
   .menubarcount, #searchbar > #homecategory {
      display : none;
   }
   
   main > main #searchbar {
      height : 80px;
   }
   
   .money {
		float: right;
		font-size: 20px;
		font-weight: bold;
	}

	.btn.btn-primary.booking {
		float: right;
		clear: both;
		margin-bottom: 10px;
	}

	.money, .btn.btn-primary.booking {
		margin-right: 30px;
	}
	
	.mb-3 {
		border: 1px solid #fbceb1;
		width: 1060px;
		box-shadow: rgb(33 37 41/ 10%) 0px 4px 8px 0px;
		border-radius: 20px;
	}
	.mb-3.main {
		border-bottom-right-radius: 0px;
		border-bottom-left-radius: 0px;
	}
	
	.col-md-4>.thumbnail {
		width: 330px;
		height: 200px;
		border: none;
		border-radius: 20px;
	}
	
	.col-md-4 {
		height: 200px;
	}
	
	.card.mb-3 {
		margin-bottom: 0px;
	}
	
	section > h5 {
		margin: 40px 0 20px 10px;
	}
   
   	#contbox {
 		width: 1060px;
   		height: 500px;
   		padding: 0px;
   		box-shadow: rgb(33 37 41 / 30%) 0px 4px 8px 0px;
   	}
   	
   	.item, .item img {
   		width: 1060px;
   		height: 500px;
   		object-fit: cover;
   	}
   	
   	.sub {
   		margin-top: 30px;
   		padding: 25px;
   		height: 215px;
   	}
   	
   	.sub ul {
   		float: left;
   		margin-right: 120px;
   		font-size: 16px;
   	}
   	
   	.sub ul:last-child {
   		margin-right: 0px;
   	}
   	

   
</style>

</head>
<body>
   <main>
      <%@ include file="/WEB-INF/views/inc/header.jsp" %>
      <%@ include file="/WEB-INF/views/home/menubar.jsp"%>
      <section>
      		
      		<h5>숙소명 > 방이름</h5>
      		<div class="card mb-3 main">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="/tripnow/images/hotel3.jpg" alt="..." class="thumbnail">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h3 class="card-title">객실명</h3>
							<ul>
								<li>베드옵션정보</li>
								<li>최대수용인원 정보</li>
							</ul>
							<p class="card-text money">￦ 66,666원</p>
							<button class="btn btn-primary booking" >객실 상세보기</button>
						</div>
					</div>
				</div>
			</div> 
			
			
		<div id="contbox" class="container">

		  <div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>
		
		    <!-- Wrapper for slides -->
		    <div class="carousel-inner">
		      <div class="item active">
		        <img src="/tripnow/images/hotel1.jpg" alt="사진1">
		      </div>
		
		      <div class="item">
		        <img src="/tripnow/images/hotel2.jpg" alt="사진2">
		      </div>
		    
		      <div class="item">
		        <img src="/tripnow/images/hotel3.jpg" alt="사진3">
		      </div>
		    </div>
		
		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right"></span>
		      <span class="sr-only">Next</span>
		    </a>
		  </div>
		</div>

		
		
		<div class="card mb-3 sub">
				
				<h2>전체 옵션 정보</h2>
				<ul>
					<li>O 욕조</li>
					<li>X 반려견/묘 동반</li>
					<li>X 흡연</li>					
				</ul>
				<ul>
					<li>O 수영장</li>
					<li>O 주차</li>
					<li>O 취사</li>					
					<li>O 와이파이</li>					
				</ul>
				<ul>
					<li>베드옵션</li>
					<li>최대수용인원 N명</li>
				</ul>
				<ul>
					<li>체크인: PM 16:00</li>
					<li>체크아웃: AM 11:00</li>
				</ul>
			</div> 
      </section>
   </main>
      <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
   
   <script>
   
   </script>

</body>
</html>