<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, map.model.vo.Arboretum" %>
<%
	ArrayList<Arboretum> list = (ArrayList<Arboretum>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container > div {
	float : left;
}
</style>
    <meta charset="utf-8">
    <title>수목원 맵</title>
    
</head>
<body>
<div class="container">
<div>
<%@ include file="../common/sidebar.jsp" %></div>
<hr>
<div id="map" style="width:80%;height:100vh;"></div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ebd5781688fcaeab7febed1207bcf8f3&libraries&libraries=clusterer"></script>
<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level: 13 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var imageSrc = '/malant/resources/map/images/namu.png', // 마커이미지의 주소입니다    
imageSize = new kakao.maps.Size(45, 45), // 마커이미지의 크기입니다
imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커가 표시될 위치입니다 
<% for(Arboretum a : list) { %>
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		markerPosition = new kakao.maps.LatLng(<%= a.getArboretum_latitude() %>, <%= a.getArboretum_longitude() %>)
	var marker = new kakao.maps.Marker({
	    position: markerPosition,
	    image: markerImage
	});
	
	marker.setMap(map);
	

	var infowindow = new kakao.maps.InfoWindow({
		content : '<div class="info">' + 
					'<div class="title"><%= a.getArboretum_name() %>&nbsp;&nbsp;&nbsp;&nbsp;</div>' + 
					'<div class="page" style="text-align:center;"><a href="/malant/ardetailinfo">상세정보</div>' +
				 '</div>',
		removable : true
	});
	
	(function(marker, infowindow) {
        kakao.maps.event.addListener(marker, 'click', function() {
            // 마커 위에 인포윈도우를 표시합니다
            infowindow.open(map, marker);  
        });
        
        kakao.maps.event.addListener(map, 'click', function() {
            infowindow.close();
        });

    })(marker, infowindow);
	
<% } %>

</script>
</body>
</html>