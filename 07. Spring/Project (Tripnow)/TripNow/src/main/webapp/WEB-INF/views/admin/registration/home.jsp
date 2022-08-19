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

	.homename > input, .roomname > input {
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
	
	.period input {
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
	
	#path, #apath {
		border : none;
		width : 100%;
	}
	
	th {
		width : 125px;
	}
	
	#content {
		width : 100%;
		height : 300px;
		resize: none;
		margin-top : 0;
	}
	
     /*       이미지 컨테이너 */
      
     #image_container {
         display: flex;
         overflow-x: auto;
     }
     
     #image_container > img {
        width: 200px;
        height: 200px;
         margin: 0 15px;
     }
     #filelist > div{
        display : flex;
     }
	
	.options input[type=number] {
		width : 50px;
      	margin-left : 7px;
      	
     }
     
     .options input[type=checkbox]:first-child{
     	margin-left : 0px;
     }
     
     .options input[type=checkbox], .bath {
     	margin-left : 7px;
     }
     
     .bath {
     	width : 45px;
     }
	
	
</style>
</head>
<body>
	<!--  -->
   <main class="main">
    	<h2><i class="fa-solid fa-pen-to-square"></i>상품 수정</h2>
     	
		<table id="table" class="table table-bordered">
	     	<tr>
	     		<th>숙소명</th>
	     		<td><div class="homename"><input type="text" name="homename" value="${homeoption.hname}" readonly></div></td>
	     	</tr>
	     	<tr>
	     		<th>방 이름</th>
	     		<td><div class="roomname"><input type="text" name="roomname" value="${homeoption.rname}" readonly></div></td>
	     	</tr>
	     	<tr>
	   			<th>주소</th>
	   			<td>
                	<div style="display: flex;">
                		<input class="form-control" value="${homeoption.location}"style="width: 300px;" type="text" name="location" id="sample5_address" placeholder="주소" readonly required="required">&nbsp;
            		</div>
                </td>
	   		</tr>
	   		<tr class="price">
	     		<th>가격</th>
	     		<td>
		     		₩<input type="text" id="price" name="price" value="${homeoption.price}" readonly>
	     		</td>
     		</tr>
     		<tr class="enterhome">
	     		<th>체크인 시간</th>
	     		<td>
		     		<input type="time" id="enterhome" name="enterhome" value="${homeoption.enterhome}" readonly>
	     		</td>
	     	</tr>
	     	<tr class="outerhome">
	     		<th>체크아웃 시간</th>
	     		<td>
		     		<input type="time" id="outerhome" name="outerhome" value="${homeoption.outerhome}" readonly>
	     		</td>
	     	</tr>
	     	<tr class="options">
	     		<th>옵션</th>
	     		<td>
					<input type="checkbox" name="bath" id="bath" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.bath == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>욕조
					<input type="checkbox" name="pet" id="pet" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.pet == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>반려동물
					<input type="number" min="2" name="maxpeople" id="maxpeople" value="${homeoption.maxpeople}" readonly/>최대인원
					<input type="checkbox" name="smoke" id="smoke" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.smoke == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>흡연
					<input type="checkbox" name="pool" id="pool" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.pool == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>수영장
					<input type="checkbox" name="parking" id="parking" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.parking == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>주차
					<input type="checkbox" name="cook" id="cook" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.cook == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>취사
					<input type="checkbox" name="wifi" id="wifi" onclick="return false;"
						<c:choose>
							<c:when test="${homeoption.wifi == 'y'}">value="y" checked</c:when>
							<c:otherwise>value="n"</c:otherwise>
						</c:choose>/>와이파이 
					<input type="text" value="${homeoption.value}" class="bath">
					베드옵션
	     		</td>
	     	</tr>
	     	<tr class="mainpath">
	     		<th>썸네일 사진</th>
	     		<td>
					<div style="margin: 7px 12px 3px 12px;">
						썸네일 파일명: <input id="path" name="path" value="${homeoption.path}" readonly/>
					</div>
				</td>
	     	</tr> 
	     	<tr class="mainpath">
	     		<th>세부 사진</th>
				<td>
					<div style="margin: 7px 12px 3px 12px;">
						<div>
						세부 파일명 : 
						<c:forEach items="${apath}" var="dto">
						<input id="apath" name="apath" value="${dto}" readonly/>
						</c:forEach>
						
						</div>
					</div>
	            </td>     
	     	</tr> 
     	</table> 
     	
     	<div class="btns">
			<a href="/tripnow/admin/registration" class="btn btn-secondary">돌아가기</a>
			<form method="POST" action="/tripnow/admin/homerefusal">
	     	<input type="submit" value="거절하기" class="btn btn-danger"/>
	     	<input type="hidden" name="seq" value="${homeoption.seq}">
		    </form>
     		<form method="POST" action="/tripnow/admin/homecheck">
	     	<input type="submit" value="등록하기" class="btn btn-primary"/>
	     	<input type="hidden" name="seq" value="${homeoption.seq}">
		    </form>
     	</div>
     	
     	
     	
     	
      
      
      
    </main>
   	    
   	    
    <script>
    	
    
    </script>



</body>
</html>













































