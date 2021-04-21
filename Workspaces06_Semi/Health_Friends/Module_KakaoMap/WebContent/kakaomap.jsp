<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div style="font-size: 36px; color: #00008B"><b>오시는 길</b></div>
		<br>
		<br>
		<%-- 지도 크기 설정 : 넓이는 자동으로 맞추고 높이는 500px으로 설정 --%>
		<div id="map" style="width: auto; height: 500px;"></div>
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6920574193fbd921283dd9d416ec4e77"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.49898969280782, 127.03286905513882), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(37.49898969280782, 127.03286905513882);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({position : markerPosition});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null);
	</script>

</body>
</html>