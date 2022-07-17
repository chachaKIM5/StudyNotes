<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
	#homeinfo {
		padding: 20px 30px;
		border: 1px solid #b7b7b7;
		margin-top: 30px;
		margin-bottom: 30px;
		font-size: 17px;
		color: #808080;
		border-radius: 20px;
		box-shadow: rgb(33 37 41/ 10%) 0px 4px 8px 0px;
	}

	.homelist {
		margin-top: 30px;
		margin-bottom: 150px;
		padding-right: 10px;
		float: left;
		height: 500px;
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
	
	.col-md-4>.thumbnail {
		width: 330px;
		height: 200px;
		border: none;
		border-radius: 20px;
	}
	
	.carinfo {
		border: 1px solid black;
		width: 1060px;
		height: 100px;
		margin-top: 30px;
	}
	
	.col-md-4 {
		height: 200px;
	}
	
	.homereview {
		/* border: 1px solid black; */
		padding: 20px;
		border-bottom: 1px solid #b7b7b7;
	}
	
	#reviewall {
		display: inline-block;
		margin-top: 5px;
		margin-bottom: 15px;
	}
	
	.reviewnumber {
		position: relative;
		top: 3px;
	}
	
	.reviewcontent {
		border: 1px solid #b7b7b7;
		padding: 15px;
		border-radius: 10px;
		text-align: justify;
	}
	
	.homereview:last-child {
		border-bottom: none;
	}
	
	#mainreview {
		border-bottom: 1px solid gray;
		padding-bottom: 20px;
		padding-top: 20px;
	}
	
	#reviewWrite {
		margin: 10px;
	}
	
	#reviewWrite > textarea {
		resize: none;
		padding: 10px;
		outline: none;
	}
	
	.write {
		position: relative;
		top: -40px;
		left: 25px;
	}
	
	#radiostar {
		margin-left: 15px;
	}
	
	#reviewstart {
		margin-top: 30px;
		margin-bottom: 20px;
	}
	
	.card.mb-3 {
		margin-bottom: 15px;
	}
	
	
	.homereview p {
		font-size: 25px;
		text-align: center;
		margin-top: 10px;
		
	}
	
	.master {
		background-color: #EEE;
	
	}
	
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp"%>
		<%@ include file="/WEB-INF/views/home/menubar.jsp"%>
		<section>

			<div id="homeinfo">
				<div>
					<span>숙소명</span> <span> ★ 4.7 (134) </span>
				</div>
				<div id="b_text1">
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
					<p class="card-text badge badge-light">
						<span>숙소 타입</span>
					</p>
				</div>
				<div>
					<i class="fa-solid fa-location-dot"></i> &nbsp; <span>위치 정보
						(서울특별시 강남구 역삼동)</span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i
						class="fa-solid fa-check"></i> &nbsp; <span>체크인 : PM 16:00
						~ 체크아웃 : AM 11:00</span>
				</div>
			</div>




			<div class="card mb-3">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="/tripnow/images/jeju.jpg" alt="..." class="thumbnail">
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
			
			<div class="card mb-3">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="/tripnow/images/jeju.jpg" alt="..." class="thumbnail">
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
			
			<div class="card mb-3">
				<div class="row no-gutters">
					<div class="col-md-4">
						<img src="/tripnow/images/jeju.jpg" alt="..." class="thumbnail">
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
			
			
				<h2 id="mainreview">숙소 리뷰</h2>
				
				
				<h3 id="reviewstart">리뷰 작성</h3>
				<div id="radiostar">
					<label><input type="radio" name="reviewstarcheck">&nbsp;<span class="star5"></span></label>
					<label><input type="radio" name="reviewstarcheck">&nbsp;<span class="star4"></span></label>
					<label><input type="radio" name="reviewstarcheck">&nbsp;<span class="star3"></span></label>
					<label><input type="radio" name="reviewstarcheck">&nbsp;<span class="star2"></span></label>
					<label><input type="radio" name="reviewstarcheck">&nbsp;<span class="star1"></span></label>
				</div>
				<div id="reviewWrite">
					<textarea rows="3" cols="110px">fdfd</textarea>
					<button class="btn btn-primary write">작성하기</button>
				</div>
				
			<div class="homereview">
				<div>
					<span>작성자 : jei****</span>
					<span>등록일 : 2022-07-17</span>
				</div>
				<div id="reviewall">
					<span class="star5"></span>
				</div>
				<span class="reviewnumber">5</span>
				<div class="reviewcontent">
					리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 
				</div>
				
				<p><i class="fa-solid fa-angle-down"></i></p>
				
				<div class="reviewcontent master">
					리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 
				</div>
			</div>
			<div class="homereview">
				<div>
					<span>작성자 : jei****</span>
					<span>등록일 : 2022-07-17</span>
				</div>
				<div id="reviewall">
					<span class="star4"></span>
				</div>
				<span class="reviewnumber">4</span>
				<div class="reviewcontent">
					리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 
				</div>
				<p><i class="fa-solid fa-angle-down"></i></p>
				
				<div class="reviewcontent master">
					리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 리뷰내용입니다. 
				</div>
			</div>


		</section>
	</main>
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	
	
	
<!-- weather widget start --><div id="m-booked-bl-simple-week-vertical-2136"> <div class="booked-wzs-160-275 weather-customize" style="background-color:#137AE9; width:160px;" id="width1 " > <div class="booked-wzs-160-275_in"> <div class="booked-wzs-160-275-data"> <div class="booked-wzs-160-275-left-img wrz-18"></div> <div class="booked-wzs-160-275-right"> <div class="booked-wzs-day-deck"> <div class="booked-wzs-day-val"> <div class="booked-wzs-day-number"><span class="plus">+</span>28</div> <div class="booked-wzs-day-dergee"> <div class="booked-wzs-day-dergee-val">&deg;</div> <div class="booked-wzs-day-dergee-name">C</div> </div> </div> <div class="booked-wzs-day"> <div class="booked-wzs-day-d"><span class="plus">+</span>29&deg;</div> <div class="booked-wzs-day-n"><span class="plus">+</span>23&deg;</div> </div> </div> <div class="booked-wzs-160-275-info"> <div class="booked-wzs-160-275-city">서울특별시</div> <div class="booked-wzs-160-275-date">일요일, 17</div> </div> </div> </div> <table cellpadding="0" cellspacing="0" class="booked-wzs-table-160"> <tr> <td class="week-day"> <span class="week-day-txt">월요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-18"></div></td> <td class="week-day-val"><span class="plus">+</span>32&deg;</td> <td class="week-day-val"><span class="plus">+</span>23&deg;</td> </tr> <tr> <td class="week-day"> <span class="week-day-txt">화요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-03"></div></td> <td class="week-day-val"><span class="plus">+</span>31&deg;</td> <td class="week-day-val"><span class="plus">+</span>24&deg;</td> </tr> <tr> <td class="week-day"> <span class="week-day-txt">수요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-18"></div></td> <td class="week-day-val"><span class="plus">+</span>30&deg;</td> <td class="week-day-val"><span class="plus">+</span>24&deg;</td> </tr> <tr> <td class="week-day"> <span class="week-day-txt">목요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-18"></div></td> <td class="week-day-val"><span class="plus">+</span>30&deg;</td> <td class="week-day-val"><span class="plus">+</span>23&deg;</td> </tr> <tr> <td class="week-day"> <span class="week-day-txt">금요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-18"></div></td> <td class="week-day-val"><span class="plus">+</span>30&deg;</td> <td class="week-day-val"><span class="plus">+</span>22&deg;</td> </tr> <tr> <td class="week-day"> <span class="week-day-txt">토요일</span></td> <td class="week-day-ico"><div class="wrz-sml wrzs-03"></div></td> <td class="week-day-val"><span class="plus">+</span>31&deg;</td> <td class="week-day-val"><span class="plus">+</span>23&deg;</td> </tr> </table> <div class="booked-wzs-center"> <span class="booked-wzs-bottom-l">7일 예보 보기</span> </div> </div> </div> </div><script type="text/javascript"> var css_file=document.createElement("link"); var widgetUrl = location.href; css_file.setAttribute("rel","stylesheet"); css_file.setAttribute("type","text/css"); css_file.setAttribute("href",'https://s.bookcdn.com/css/w/booked-wzs-widget-160x275.css?v=0.0.1'); document.getElementsByTagName("head")[0].appendChild(css_file); function setWidgetData_2136(data) { if(typeof(data) != 'undefined' && data.results.length > 0) { for(var i = 0; i < data.results.length; ++i) { var objMainBlock = document.getElementById('m-booked-bl-simple-week-vertical-2136'); if(objMainBlock !== null) { var copyBlock = document.getElementById('m-bookew-weather-copy-'+data.results[i].widget_type); objMainBlock.innerHTML = data.results[i].html_code; if(copyBlock !== null) objMainBlock.appendChild(copyBlock); } } } else { alert('data=undefined||data.results is empty'); } } var widgetSrc = "https://widgets.booked.net/weather/info?action=get_weather_info;ver=7;cityID=18406;type=4;scode=2;ltid=3458;domid=593;anc_id=22985;countday=undefined;cmetric=1;wlangID=24;color=137AE9;wwidth=160;header_color=ffffff;text_color=333333;link_color=08488D;border_form=1;footer_color=ffffff;footer_text_color=333333;transparent=0;v=0.0.1";widgetSrc += ';ref=' + widgetUrl;widgetSrc += ';rand_id=2136';var weatherBookedScript = document.createElement("script"); weatherBookedScript.setAttribute("type", "text/javascript"); weatherBookedScript.src = widgetSrc; document.body.appendChild(weatherBookedScript) </script><!-- weather widget end -->



	<script>
	
	</script>

</body>
</html>














