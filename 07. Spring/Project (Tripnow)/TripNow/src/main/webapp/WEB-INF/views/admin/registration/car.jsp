<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripNow(트립나우)</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c48ad331128302078e60bceb1657db96&libraries=services"></script>
<script src="https://kit.fontawesome.com/e4f03f4c6c.js" crossorigin="anonymous"></script>
<style>

	.main{
		height : 600px;
		width : 830px;
		float: left;
	}
	
	h2 {
		text-align: center;
		
	}
	
	.fa-solid {
		margin-right : 10px;
	}

	.carname > input {
		height : 30px;
		width : 120px;
		border : none;
	}
	
	.mileage input{
		border : none;
		width : 50px;
		
	}
	
	.price input {
		border : none;
		width : 100px;
	}
	
	.rentstart input, .rentend input {
		border : none;
	}
	
	form {
		font-size: 18px;
	}
	
	.btns {
		float: right;
		display: flex;
	}
	
	
	label {
		margin-right : 20px;
	}
	
	label > input[type=radio] {
		margin-right : 5px;
	}
	
	#path {
		border : none;
		width : 92%;
	}
	
	
	
</style>
</head>
<body>
	<!--  -->
   <main class="main">
    
    	<h3><i class="fa-solid fa-pen-to-square"></i>상품 수정</h3>
     	
     	<table id="table" class="table table-bordered">
	     	<tr>
	     		<th>차량명</th>
	     		<td><div class="carname"><input type="text" name="carname" value="${caroption.carname}" readonly></div></td>
	     	</tr>
	     	
	     	<tr class="feul">
	     		<th>연료</th>
	     		<td>
			     	<label><input type="radio" name="fseq" value="1" disabled="disabled"
			     		<c:if test="${caroption.fseq == 1}">checked</c:if>/>가솔린</label>
			     	<label><input type="radio" name="fseq" value="2" disabled="disabled"
			     		<c:if test="${caroption.fseq == 2}">checked</c:if>/>디젤</label>
			     	<label><input type="radio" name="fseq" value="3" disabled="disabled"
			     		<c:if test="${caroption.fseq == 3}">checked</c:if>/>LPG</label>
			     	<label><input type="radio" name="fseq" value="4" disabled="disabled"
			     		<c:if test="${caroption.fseq == 4}">checked</c:if>/>전기</label>
	     		</td>
	     	</tr>
	     	
	     	<tr class="humancount">
	     		<th>탑승 인원</th>
	     		<td>
			     	<label><input type="radio" name="hseq" value="1" disabled="disabled"
			     		<c:if test="${caroption.hseq == 1}">checked</c:if>/>2인승</label>
			     	<label><input type="radio" name="hseq" value="2" disabled="disabled"
			     		<c:if test="${caroption.hseq == 2}">checked</c:if>/>4인승</label>
			     	<label><input type="radio" name="hseq" value="3" disabled="disabled"
			     		<c:if test="${caroption.hseq == 3}">checked</c:if>/>6인승</label>
			     	<label><input type="radio" name="hseq" value="4" disabled="disabled"
			     		<c:if test="${caroption.hseq == 4}">checked</c:if>/>8인승</label>
		     		<label><input type="radio" name="hseq" value="5" disabled="disabled"
			     		<c:if test="${caroption.hseq == 5}">checked</c:if>/>10인승</label>
		     		<label><input type="radio" name="hseq" value="6" disabled="disabled"
			     		<c:if test="${caroption.hseq == 6}">checked</c:if>/>12인승</label>
	     		</td>
	     	</tr>
	     	
	     	<tr class="cartype">
	     		<th>차종</th>
	     		<td>
			     	<label><input type="radio" name="ctseq" value="1" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 1}">checked</c:if>/>경차</label>
			     	<label><input type="radio" name="ctseq" value="2" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 2}">checked</c:if>/>소형</label>
			     	<label><input type="radio" name="ctseq" value="3" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 3}">checked</c:if>/>준중형</label>
			     	<label><input type="radio" name="ctseq" value="4" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 4}">checked</c:if>/>중형</label>
		     		<label><input type="radio" name="ctseq" value="5" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 5}">checked</c:if>/>고급</label>
		     		<label><input type="radio" name="ctseq" value="6" disabled="disabled"
			     		<c:if test="${caroption.ctseq == 6}">checked</c:if>/>승합</label>
	     		</td>
	     	</tr>
	     	
	     	
	     	<tr class="mileage">
	     		<th>연비</th>
	     		<td>
	     			<input type="number" name="mileage" value="${caroption.mileage}" readonly>Km/L
	     		</td>
	     	</tr>
	     	<tr class="cartype">
	     		<th>변속 종류</th>
	     		<td>
			     	<label><input type="radio" name="geartype" value="y" disabled="disabled"
			     		<c:if test="${caroption.geartype == 'y'}">checked</c:if>/>자동</label>
	   	  			<label><input type="radio" name="geartype" value="n" disabled="disabled"
		     			<c:if test="${caroption.geartype == 'n'}">checked</c:if>/>수동</label>
	     		</td>
	   		</tr>
	   		<tr>
	   			<th>주소</th>
	   			<td>
                	<div style="display: flex;">
                		<input class="form-control" value="${caroption.location}"style="width: 300px;" type="text" name="location" id="sample5_address" placeholder="주소" readonly required="required">&nbsp;
            		</div>
            		<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>             
                </td>
	   		</tr>
	     	<tr class="price">
	     		<th>가격</th>
	     		<td>
		     		₩<input type="text" id="price" name="price" value="${caroption.price}" readonly>
	     		</td>
     		</tr>
	     	<tr class="rentstart">
	     		<th>대여 시간</th>
	     		<td>
		     		<input type="time" id="rentstart" name="rentstart" value="${caroption.rentstart}" readonly>
	     		</td>
	     	</tr>
	     	<tr class="rentend">
	     		<th>반납 시간</th>
	     		<td>
		     		<input type="time" id="rentend" name="rentend" value="${caroption.rentend}" readonly>
	     		</td>
	     	</tr>
	     	<tr class="path">
	     		<th>사진</th>
	     		<td>
					<div style="margin: 7px 12px 3px 12px;">
						파일명: <input id="path" name="path" value="${caroption.path}" readonly/>
					</div>
				</td>
	     	</tr>
	     	
     	
     	</table>
     	
     	<div class="btns">
     		<a href="/tripnow/admin/registration" class="btn btn-secondary">돌아가기</a>
     		<form method="POST" action="/tripnow/admin/carrefusal">
	     	<input type="submit" value="거절하기" class="btn btn-danger"/>
	     	<input type="hidden" name="seq" value="${caroption.seq}">
		    </form>
     		<form method="POST" action="/tripnow/admin/carcheck">
	     	<input type="submit" value="등록하기" class="btn btn-primary"/>
	     	<input type="hidden" name="seq" value="${caroption.seq}">
		    </form>
     	</div>
     	
     	
      
      
      
    </main>
   	    
   	    
    <script>
    	
    
	    
    
    </script>


</body>
</html>














































