<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<style>
	#title {
		width: 220px;
		height: 50px;
		margin: 0px auto;
		display: flex;
	}
	
	#icon {
		background-image: url("/tripnow/images/qna.png");
		margin-top: 5px;
		width: 40px;
		height: 40px;
		background-size: contain;
		background-repeat: no-repeat;
	}
	
	#top {
		width: 840px;
		margin: 10px auto;
		margin-top: 60px;
		padding-left: 8px;
	}
	
	#top p {
		float: left;
	}
	
	#top span {
		float: right;
	}
	
	.table {
		width: 840px;
		margin: 15px auto;
		margin-bottom: 30px;
		text-align: center;
	}
	
	
	
	.table tr:nth-child(1) th {
		text-align: center;
		vertical-align: middle;
		height: 80px;
		font-size: 25px;
	}
	
	#table.table > thead > tr > th {
		border-top: 2px solid #DDD;
		border-bottom: none;
	}
	
	#table tr:nth-child(2) th:nth-child(1) { width: 280px; }
	#table tr:nth-child(2) th:nth-child(2) { width: 280px; text-align: center;}
	#table tr:nth-child(2) th:nth-child(3) { width: 280px; text-align: right; }
	
	#table tr:nth-child(3) {
		height: 100px;
		border-bottom: 1px solid #CCC;
	}
	
	#table tr:nth-child(3) td {
		text-align: left;
		font-size: 16px;
		padding: 40px 20px 40px 20px;
	}
	
	#top .btn-info {
		background-color: #5bc0de;
	}

	#top .btn-danger {
		background-color: #d9534f;
	}
	
	
	#answer {
		width: 840px;
		height: ;
		margin: 30px auto;
	}
	
	#arrow {
		text-align: center;
	}
	 
	#answer i {
		text-align: center;
		font-size: 40px;
	}
	
	.answerbox {
		width: 840px;
		height: auto;
		padding: 25px 40px 20px 40px;
		margin: 20px 0px 20px 0px;
		border: 1px solid #CCC;
		border-radius: 15px;
	}
	
	.answerbox .answertitle {	
		font-size: 20px;
		font-weight: bold;
		color: cornflowerblue;
	}
	.answerbox .maintext {
		font-size: 16px;
	}
	
	.answerbox .subtext {
		color: #888;
	    text-align: right;
	}
	
	#button {
		width: 840px;
		margin: 0 auto;
		display: flex;
		justify-content: flex-end;
	}
	
	#button input[type=button] {
		margin-left: 5px;
	}

	#addanswer {
		width: 840px;
		height: 200px;
		margin-bottom: 20px;
	}
	
	#acontent {
		width: 100%;
		padding: 7px;
		height: 150px;
		border: 1px solid #CCC;
		resize: none;
	}
	
	#write {
	 	position:relative;
	 	display: inline-block;
	 	height: 150px;
	 	width: 840px;
	 }

	#acontent {
		width: 100%;
		padding: 7px;
		height: 150px;
		border: 1px solid #CCC;
		resize: none;
	}
	 
	#write .count {
		position:absolute;
		right:20px;
		bottom:20px;
		color:#666;
		font-size:15px;
	}
	
	.btns {
		float: right;
	}
	
	.hidden {
		display: none;
	}
	
	
	
</style>
</head>
<body>
	<div id="content">
	  <section>
		<div id="title"><div id="icon"></div><h1>&nbsp;고객 센터</h1></div>
	  	
	  	<div id="top">
	  	<p><a href="/tripnow/admin/main">관리자 모드</a> > <a href="/tripnow/admin/qna/list?page=${nowPage}">고객 센터</a> > ${dto.category}</p>
	  		<c:if test="${dto.state == '답변완료'}">
	  			<span class="badge btn-info">${dto.state}</span>
	  		</c:if>
	  		
	  		<c:if test="${dto.state == '처리중'}">
	  			<span class="badge btn-danger">${dto.state}</span>
	  		</c:if>
	  	</div>
	  	
	  	<table class="table" id="table">
	  		<thead>
	  			<tr>
	  				<th colspan="3" class="center">${dto.qsubject}</th>
	  			</tr>
	  			
	  			<tr>
	  				<th>글번호: ${dto.qseq}</th>
	  				<th>작성자: ${dto.id}</th>
	  				<th>등록일: ${dto.qregdate}</th>
	  			</tr>
	  			
	  			<tr>
	  				<td colspan="3">${dto.qcontent}</td>
	  			</tr>
	  		</thead>
	  		<tbody>
	  		</tbody>
	  	</table>
	  	
	  	<div id="addanswer" class="hidden">
		  	<div id="write">
		  		<textarea id="acontent" name="acontent" placeholder="100자 이내로 작성하실 수 있습니다."></textarea>
	  			<div class="count"><span>0/100</span></div>
	  		</div>
			
			<div class="btns">
	 				<input type="button" class="btn btn-info" value="등록" onclick="addanswer()">
		  	</div>
	  	</div>
  	
	  	<div id="answer">
	  	
	  		<c:if test="${dto.aseq != null}">
	  			<div id="arrow"><i class="fa-solid fa-angle-down"></i></div>
	  			<div class="answerbox">
	  				<p class="answertitle">안녕하세요, 트립나우입니다.</p>
	  				<p class="maintext">${dto.acontent}</p>
	  				<p class="subtext">답변일: ${dto.aregdate}</p>
	  			</div>
	  		
	  		</c:if>
	  	</div>
	  	
	  	<div id="button">
	  		<input type="button" class="btn btn-info" value="목록" onclick="location.href='/tripnow/admin/qna/list?page=${nowPage}'">
	  		
	  		<c:if test="${isNotice == 'n' && dto.aseq == null}">
	  		<input type="button" class="btn btn-warning" value="답변 작성" onclick="writer()">
	  		</c:if>
	  		
	  		<c:if test="${isNotice == 'n' && dto.aseq != null}">
	  		<input type="button" class="btn btn-danger" value="답변 삭제" onclick="delanswer()">
	  		</c:if>
	  	</div>
	 
	  		
	  
	  
	  </section>
		
	</div>
   <script>
   
   
   		function writer() {
   			
   			if ($('#button .btn-warning').val() == '답변 작성') {
   				$('#button .btn-warning').val('취소');
   				$('#addanswer').removeClass('hidden');
   				
   			} else {
   				$('#button .btn-warning').val('답변 작성');
   				$('#addanswer').addClass('hidden');
   			}
   		}
   
   		
	   $('#acontent').keyup(function(){
		   
		   var content = $(this).val();
		   
		   $('#write .count span').html(content.length + '/100');
		   if (content.length > 100){
		     alert("최대 100자까지 입력 가능합니다.");
		     $(this).val(content.substring(0, 100));
		     $('#write .count span').html('100/100');
		   }
		});
	   
	   
	   function addanswer() {
		   
		   
		   $('#addanswer').addClass('hidden');
		   $('#button .btn-warning').remove();
		   
		   

   			$.ajax({
				
				type: 'POST',
				url: '/tripnow/admin/qna/answer',
				data: 'qseq=' + ${dto.qseq} + '&acontent=' + $('#acontent').val(),
				dataType: 'json',
				success: function(result) {

					let temp = `
				  			<div id="arrow"><i class="fa-solid fa-angle-down"></i></div>
				  			<div class="answerbox">
				  				<p class="answertitle">안녕하세요, 트립나우입니다.</p>
				  				<p class="maintext">` + result.acontent + `</p>
				  				<p class="subtext">답변일:` + result.aregdate + `</p>
				  			</div>`;
					
					$('#answer').prepend(temp);
					
					$('#acontent').val('');
					
					let temp2 = `<input type="button" class="btn btn-danger" value="답변 삭제" onclick="delanswer()">`;
					$('#button .btn-info').after(temp2);
					$('#top span.badge').removeClass('btn-danger').addClass('btn-info');
					$('#top span.badge').text('답변 완료');
				},
				error: function(a,b,c) {
					alert('답변 등록 실패');
				}
				
			});
	   };
	   
	   
	   function delanswer() {
		    
		   $('#answer').empty();
		   $('#button .btn-danger').remove();
		   

   			$.ajax({
				
				type: 'POST',
				url: '/tripnow/admin/qna/delanswer',
				data: 'qseq=' + ${dto.qseq},
				dataType: 'text',
				success: function(result) {

					if (result == '1') {
						alert('삭제되었습니다.');
						
						let temp = `<input type="button" class="btn btn-warning" value="답변 작성" onclick="writer()">`;
						$('#button .btn-info').after(temp);
						$('#top span.badge').removeClass('btn-info').addClass('btn-danger');
						$('#top span.badge').text('처리중');
						
					} else {
						alert('삭제 실패');
					}
				},
				error: function(a,b,c) {
					alert('삭제 오류');
				}
				
			});
		   
	   };
	   
   </script>

</body>
</html>