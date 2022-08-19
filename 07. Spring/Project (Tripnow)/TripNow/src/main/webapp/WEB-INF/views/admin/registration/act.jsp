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

	.actname > input {
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
	
	
</style>
</head>
<body>
	<!--  -->
   <main class="main">
    	<h3><i class="fa-solid fa-pen-to-square"></i>상품 수정</h3>
     	
     	<table id="table" class="table table-bordered">
	     	<tr>
	     		<th>액티비티명</th>
	     		<td><div class="actname"><input type="text" name="actname" value="${actoption.name}" readonly></div></td>
	     	</tr>
	     	<tr>
	   			<th>주소</th>
	   			<td>
                	<div style="display: flex;">
                		<input class="form-control" value="${actoption.location}"style="width: 300px;" type="text" name="location" id="sample5_address" placeholder="주소" readonly required="required">&nbsp;
            		</div>
            		<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>             
                </td>
	   		</tr>
	   		<tr class="price">
	     		<th>가격</th>
	     		<td>
		     		₩<input type="text" id="price" name="price" value="${actoption.price}" readonly>
	     		</td>
     		</tr>
     		<tr class="period">
	     		<th>마감 날짜</th>
	     		<td>
		     		<input type="date" id="period" name="period" value="${actoption.period}" readonly>
	     		</td>
	     	</tr>
	     	<tr class="content">
	     		<th>내용</th>
	     		<td>
	     			<textarea name="content" id="content" readonly>${actoption.content}</textarea>
	     		</td>
	     	</tr>
	     	<tr class="mainpath">
	     		<th>썸네일 사진</th>
	     		<td>
					<div style="margin: 7px 12px 3px 12px;">
						파일명: <input id="path" name="path" value="${actoption.path}" readonly/>
					</div>
				</td>
	     	</tr> 
	     	<tr class="mainpath">
	     		<th>세부 사진</th>
				<td>
					<div style="margin: 7px 12px 3px 12px;">
						<div>
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
			<form method="POST" action="/tripnow/admin/actrefusal">
	     	<input type="submit" value="거절하기" class="btn btn-danger"/>
	     	<input type="hidden" name="seq" value="${actoption.seq}">
		    </form>
     		<form method="POST" action="/tripnow/admin/actcheck">
	     	<input type="submit" value="등록하기" class="btn btn-primary"/>
	     	<input type="hidden" name="seq" value="${actoption.seq}">
		    </form>
     	</div>
     	
     	
      
      
      
    </main>
   	    
   	    
    <script>
    	
    
    </script>



</body>
</html>













































