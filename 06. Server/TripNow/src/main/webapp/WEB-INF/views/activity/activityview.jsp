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
   
   
/* 	//////////////////////////////////////////   	 */

	.ALbar{
		position:relative;
		top:14px;
		
		
	}	
	
	.Acontainer{
		
		margin-top:23px ;
		width: 1060px;
		height:2000px;
/*  		background-color : cornflowerblue;  */
	}
	
		/* 	썸네일 */
	
	.AthumbnailContainer{
		display :flex;
		width: 1030px;
		margin:auto;
		height:360px;
 		background-color: #EEE; 
		padding: 7px;
		border-radius: 10px;
		
		margin-bottom: 17px;
		
		box-shadow: rgb(33 37 41 / 30%) 0px 4px 8px 0px;
		
		
	}
	.Athumbnail{
		width: 520px;
		height: 340px;
/* 		background-color : black; */
		margin-left: 7px;
	}
	
	.Athumbnail > img{
		
		border-radius: 2px;
		width: 520px;
		height: 340px;	
		object-fit: cover;
		border-radius: 6px;
	}
	
	
	
	
	.AvName{
		
		margin-left:24px;
		margin-top:2px; 
		
		width: 459px;
		height: 340px;
		
 		background-color : white;
 		
 		border-radius: 6px;
 		 

	}
	
	.AvName > div{
		word-break:break-all;
		margin-left:20px;
		margin-top:4px;
	}
	
	
	.AvName > div:nth-child(1){
	
/* 		background-color : cornflowerblue;   */
		height: 60px;
		padding-top: 14px;
		
	
	}
	
	.AvName > div:nth-child(1) > p {
		font-size: 23px;
		font-weigth: 600;
	}
	
	
	.AvName > div:nth-child(2){
		
/*   		background-color : yellowgreen;   */
		height: 30px;
		margin-left:10px;
		margin-top:-10px;
		
		
		
		
	}
	
	.AvName > div:nth-child(3) > .star5{
	    display: inline-block;
	    margin-right: 10px;
	    width: 140px;
	    height: 33px;
	    background-image: url(/tripnow/images/star.png);
	    background-position: 0px -134px;
	    background-size: 340%;
	    vertical-align: top;
	    
	    background-color : white; 
	
	}
	
	.AvName > div:nth-child(3) > .star4{
	    display: inline-block;
	    margin-right: 10px;
	    width: 140px;
	    height: 33px;
	    background-image: url(/tripnow/images/star.png);
	    background-position: 0px -100px;
	    background-size: 340%;
	    vertical-align: top;
	    
	    background-color : white; 
	
	}
	.AvName > div:nth-child(3) > .star3{
	    display: inline-block;
	    margin-right: 10px;
	    width: 140px;
	    height: 33px;
	    background-image: url(/tripnow/images/star.png);
	    background-position: 0px -66px;
	    background-size: 340%;
	    vertical-align: top;
	    
	    background-color : white; 
	
	}
	
	.AvName > div:nth-child(3) > .star2{
	    display: inline-block;
	    margin-right: 10px;
	    width: 140px;
	    height: 33px;
	    background-image: url(/tripnow/images/star.png);
	    background-position: 0px -31px;
	    background-size: 340%;
	    vertical-align: top;
	    
	    background-color : white; 
	
	}
	
	.AvName > div:nth-child(3) > .star1{
	    display: inline-block;
	    margin-right: 10px;
	    width: 140px;
	    height: 33px;
	    background-image: url(/tripnow/images/star.png);
	    background-position: 0px 3px;
	    background-size: 340%;
	    vertical-align: top;
	    background-color : white; 
	
	}
	
	
	

	.AvName > div:nth-child(4){
		
		margin-right:20px;
		margin-top : 10px;
		height: 150px;
		font-size: 15px;
/* 		background-color: #eee; */
		
	}
	
	.AvName > div:nth-child(5){
		
		font-size:19px;
		
		margin-top:13px;	
/* 		background-color: #ccc; */
		
	}
	

	
	
	.Actbook > .btn.actbuy{
		position:relative;
		top:-24px;
		left:-9px;
		
		float: right;
		margin-right:9px;
		margin-top:-5px;
	}
	
	.Actbook > .actCount{
	
		width: 45px;
	    height: 34px;
	    position: relative;
	    
	    top: -29px;
	    left: 312px;
	    font-size: 20px;
	    text-align: center;
	}
	
	
		/* 	포토 */
	
	.Actphoto{
		
/* 		background-color : beige; */
		
		width: 1030px;
		height: 585px;
		
		margin: auto;
		
		
	}	
	
	
	
	.Actphoto > div:nth-child(1){
		border-bottom: 1px solid gray;
		height: 40px;
		width: 95px;
		
	}
	
	.Actphoto > div:nth-child(1) > p{
		font-size:22px; 
		font-weight: 500;
	}
	
	.Actphoto > div:nth-child(2){
		
		margin-top: 15px;
		
	}
	
	
	
	
	

	.Actphoto > #contbox {
 		width: 1030px;
   		height: 500px;
   		padding: 0px;
   		box-shadow: rgb(33 37 41 / 30%) 0px 4px 8px 0px;
   	}
   	
	.item, .item img {
   		width: 1030px;
   		height: 500px;
   		object-fit: cover;
   		border-radius: 2px;
   	}
   	
		/*   리뷰 */
		
	.AcReview{
		
/* 		background-color: #999; */
		
		height: 1030px;
	
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
	
	#reviewWrite > button{
		margin-left:-14px;
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
	
	AreviewWrite > div:nth-child(1){
		height:1030px;
	}
	
	#reviewstart {
		margin-top: 30px;
		margin-bottom: 20px;
		border-bottom: 1px solid gray;
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
	
	.AreviewWrite{
		margin-left: 18px;
	}
		
		
	.spanright {
		float: right;
	}
	
	.spanright > span:nth-child(1) > a {
		color: red;
	}
	
	.spanright > span:nth-child(2) > a {
		color: blue;
	}
	
	.spanright > span > a:hover {
		color: cornflowerblue;
	}
	
	
	#editRow {
		margin: 10px;
	}
	
	.tblEditComment textarea {
		resize: none;
		width: 829px;
		margin: 10px;
		height: 70px;
	}
	
	.popupMap{
		cursor:pointer;
	}
	
	.AvName > div:nth-child(5) > span{
		font-size:17px;
	}
	
	.AvName > div:nth-child(3) > span:nth-child(1){
		font-size: 19px;
    	font-weight: 500;
   		color: cornflowerblue;
	}
	
	   
</style>

</head>
<body>
   <main>
      <%@ include file="/WEB-INF/views/inc/header.jsp" %>
      
      <div class="ALbar">
      	<%@ include file="/WEB-INF/views/activity/menubar.jsp"%>
      </div>	
      
      <div class="Acontainer">
	      <div class="AthumbnailContainer">
	      		<div class="Athumbnail">
	      			<img src="${dto.path} " />
	      		</div>
	      		<div class="AvName">
		      		<div>
		      			<p>${dto.name}</p>				      		
		      		</div> 
		      		<div>
		      			<span class="popupMap">
		      				<i  class="fa-solid fa-location-dot">${dto.location}</i>
		      				<input id="location" type="hidden" value="${dto.location}" />
		      			</span>
		      		</div>
		      		<div>
		      			<c:if test="${dto.avgstar == 0}">
		      				<span>별점: 평가전</span>
		      			</c:if>
		      			<span class="star${dto.avgstar}"></span> 
	      			</div>
	      			<div>
	      				<p>${dto.content} </p>   				
	      			</div>
	      			<div>
	      				가격:&nbsp;${dto.price}&nbsp;원/<span>1인</span>
	      			</div>
	      			<form method="GET" action="/tripnow/activity/activitypayment.do" >
		      			<div class="Actbook">
		      				<input type="hidden" name="id" value="${id}" />
		      				<input type="hidden" name="seq" value="${seq}" />
		      				<input type="number" name="count" value="${count}" class="actCount" />
		      				<button class="btn btn-primary actbuy" id="book" onclick="login_check();" >구매하기</button>
		      			</div>
	      			</form>
	      		</div>
	      	</div>  
	      	
	      	
	      <div class="Actphoto">
	      	
	      	  	<div>
	      	  		<p>상세사진</p>
	      	  	</div>
	      	  	
      	  		<div id="contbox" class="container">
			      	<div id="myCarousel" class="carousel slide" data-ride="carousel">
				          <!-- Indicators -->
				          <ol class="carousel-indicators">
				          <c:forEach var="a" begin="0" end="${dto.imagecount - 1}">
				            <li data-target="#myCarousel" data-slide-to="${a}"></li>
				          </c:forEach>
				          </ol>
				      
				          <!-- Wrapper for slides -->
				          <div class="carousel-inner">
				          
  				      		<c:forEach items = "${imagedto}" var="image">  				          	
				          		          
				            <div class="item">
				              <img src="${image.path}" alt="사진1">
				            </div>
 
 				            </c:forEach>  
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
	      </div>
	      
	      
	      <div class="AcReview">
	      
	           
		      	<div class="AreviewWrite">
		      	   <div>
		      		<h3 id="reviewstart">리뷰 </h3>
		      	   </div>
		      	   
		      	   <c:if test="${rdto.bookid == id and id != null}">
		 			<form id="addActReviewForm">
						<div id="radiostar">
							<label><input type="radio" name="star" value="5" required>&nbsp;<span class="star5"></span></label>
							<label><input type="radio" name="star" value="4">&nbsp;<span class="star4"></span></label>
							<label><input type="radio" name="star" value="3">&nbsp;<span class="star3"></span></label>
							<label><input type="radio" name="star" value="2">&nbsp;<span class="star2"></span></label>
							<label><input type="radio" name="star" value="1">&nbsp;<span class="star1"></span></label>
						</div>
						
						<div id="reviewWrite">
							<textarea rows="3" cols="110px" name="content">리뷰를 작성하세요.</textarea>
							<!-- 글번호 -->
 							<input type="hidden" name="seq" value="${seq}" />   
 							<input type="hidden" name="rseq" value="${rdto.rseq}" />   
							<button type="button" class="btn btn-primary write" onclick="addActReview();" >작성하기</button>
						</div>
					</form>
					</c:if>
					
				</div>
		  <div id="reviewbox"> 
			
			<c:forEach items="${review}" var="dto">
				<div class="homereview">
					<div>
						<span>작성자 : ${dto.id}</span>
						<span style="float: right">등록일 : ${dto.regdate}</span>
					</div>
					<div id="reviewall">
						<span class="star${dto.star}"></span>
					</div>
					<span class="reviewnumber">${dto.star}</span>
					<div class="reviewcontent">
						<span>${dto.content}</span>
						<c:if test="${dto.id == id}">
						<span class="spanright">
							<span class="btnspan"><a href="#!" onclick="delcomment(${dto.seq});">[삭제]</a></span>
							<span class="btnspan"><a href="#!" onclick="editcomment(${dto.seq});">[수정]</a></span>
						</span>
						</c:if>
					</div>
					<c:if test="${not empty dto.acontent}">
					<p><i class="fa-solid fa-angle-down"></i></p>
						<div class="reviewcontent master">
							 ${dto.acontent} 
						</div>
					</c:if>
				</div>
	        </c:forEach>

			</div>
	      </div>
	      
      	  
      </div>
      

		
   </main>
      <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
   
   <script>
   
  
   
   
   // 사진 추가
     
   window.onload=function() {
       
       $('.carousel-indicators li:first-child').addClass("active");
       $('.carousel-inner div:first-child').addClass("active");
       $('#reviewall > span').add
       
      
       
    }
      
   
   function login_check(){ 
        var id = '<%=(String)session.getAttribute("auth")%>';

         if(id=="null"){ 
        	 
        	 if (confirm('로그인을 하시겠습니까?')) {
					location.href='/tripnow/member/login.do';
				}
        	 
        	 event.preventDefault();
         };
        
   };   
   
   function addActReview(){ 
          
	   $.ajax({
			type: 'POST',
			url: '/tripnow/activity/activityreviewok.do',
			data: $('#addActReviewForm').serialize(),
			dataType: 'json',
			success: function(result) {
			if (result.result == "1") {
				
				
					
					let temp= `<div class="homereview">
						<div>
							<span>작성자 : \${$('[name=id]').val()}</span>
							<span style="float: right">등록일 : \${result.regdate}</span>
						</div>
						<div id="reviewall">
							<span class="star\${result.star}"></span>
						</div>
						<span class="reviewnumber">\${result.star}</span>
						<div class="reviewcontent">
						<span>\${$('[name=content]').val()}</span>
							<span class="spanright">
								<span class="btnspan"><a href="#!" onclick="delcomment(\${result.seq});">[삭제]</a></span>
								<span class="btnspan"><a href="#!" onclick="editcomment(\${result.seq});">[수정]</a></span>
							</span>
						</div>
					</div>`;
					
					
					
					$('#reviewbox').prepend(temp);
					
					$('#addActReviewForm').remove();
				}
			}, error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
		}	
    
   		function delcomment(seq) {
		
		let tr = $(event.target).parent().parent().parent().parent();
		
		if (confirm('정말 삭제하시겠습니까?')) {
			
			$.ajax({
				type: 'POST',
				url: '/tripnow/activity/actdelreviewtok.do',
				data: 'seq=' + seq,
				dataType: 'json',
				success: function(result) {
					
					if (result.result == "1") {
						tr.remove();
					} else {
						alert('댓글 삭제 오류!!');
					}
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		}
		
	}
   		
   		
   		let isEdit = false; 
		
		function editcomment(seq) {
			
			if (!isEdit) {
				
				const tempStr = $(event.target).parent().parent().parent().children(":first").text();
				
				console.log($(event.target).parent().parent().parent().children(":first").text());
				
				$(event.target).parent().parent().parent().after(temp);
				
				isEdit = true;
				
				$(event.target).parent().parent().parent().next().find('textarea').val(tempStr);
				$(event.target).parent().parent().parent().next().find('input[name=seq]').val(seq);
			}
			
		}
		
    
		const temp = `<tr id='editRow' style="background-color: #CDCDCD;">
			<td>
				<form id="editCommentForm">
				<table class="tblEditComment">
					<tr>
						<td>
							<textarea class="form-control" name="content" required id="txtcontent"></textarea>
						</td>
						<td>
							<button class="btn btn-secondary" type="button"
								onclick="cancelForm();">
								취소하기
							</button>
							<button class="btn btn-primary" type="button"
									onclick="editComment();">
								<i class="fas fa-pen"></i>
								수정하기
							</button>
						</td>
					</tr>
				</table>
				
				<input type="hidden" name="seq">
				</form>
			</td>
		</tr>`;
		
		function cancelForm() {
		$('#editRow').remove();
		isEdit = false;
		};
 
		function editComment() {
			
			$.ajax({
				
				type: 'POST',
				url: '/tripnow/activity/acteditreviewtok.do',
				data: $('#editCommentForm').serialize(),
				dataType: 'json',
				success: function(result) {
					
					if (result.result == "1") {
						
						$('#editRow').prev().children().eq(0).text($('#txtcontent').val());
						$('#editRow').remove();
						
					} else {
						alert('failed');
					}
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
		}
		
		
		 //지도 팝업
		   $('.popupMap').on("click",function(){
					var location = $('#location').val();
					window.open("/tripnow/tripnow/map.do?location="+location,"Map","width=390,height=315").focus();
					
				});
		   
   
   
   </script>

</body>
</html>





























