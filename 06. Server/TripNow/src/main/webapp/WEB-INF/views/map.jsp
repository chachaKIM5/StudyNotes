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
		
	#info{
		
/* 		background-color : cornflowerblue; */
		
		margin-bottom: 14px;
		margin-left: 24px;
		
		width: 80px;	
		
		border-bottom : 1px solid black;
	
	}
	
	#info > p {
		
		font-size: 25px;
		margin-top:4px;
		margin-left:10px;
	
	}	
	
	#map {
	
		margin: auto;
	}
	
	
		
</style>
</head>
<body>
   
   
   <div id="info">
   		<p>위치</p>	
   </div>
   
   <div id="map" style="width:500px;height:350px;"></div>




   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c48ad331128302078e60bceb1657db96&libraries=services"></script>
   
   <script>
   
	   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	   mapOption = {
	       center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	       level: 3 // 지도의 확대 레벨
	   };  
	
		//지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		//주소로 좌표를 검색합니다
		geocoder.addressSearch('${location}', function(result, status) {
		
	   // 정상적으로 검색이 완료됐으면 
	    if (status === kakao.maps.services.Status.OK) {

       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

       // 결과값으로 받은 위치를 마커로 표시합니다
       var marker = new kakao.maps.Marker({
           map: map,
           position: coords
       });



       // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
       map.setCenter(coords);
	   } 
	});    
   
   </script>

</body>
</html>