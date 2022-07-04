<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=64e03f8eab3f22763f41f9cc8a75445d"></script>
<style>
	
	#map {
		width: 750px;
		height: 400px;
		margin: 0 auto;
	}

</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		 	
		 	<h2>카카오 맵</h2>
		 	<div id="map"></div>
		</section>
	</main>
	
	<script>
	
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.499321, 127.033220),
			level: 3
		};
		
		var map = new kakao.maps.Map(container, options);
		
		//map.setCenter(좌표);
		//map.panTo(좌표);
		
		let m = null;
		
		kakao.maps.event.addListener(map, 'click', function(event) {
			
			//event.latLng > new kakao.maps.LatLng(lat, lng)
			
			map.panTo(event.latLng);
			
			
			//이전 마커가 존재하면 삭제하기
			if (m != null) {
				//맵 연동 해제
				m.setMap(null);
			}
			
			m = new kakao.maps.Marker({
				position: event.latLng
			});
			
			
			m.setMap(map);
			
		});
	</script>	
	
</body>
</html>