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
    <title>마커</title>
    
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
    
var clusterer = new kakao.maps.MarkerClusterer({
    map: map,
    averageCenter: true,
    minLevel: 10,
    disableClickZoom: false
});

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
<% for(Arboretum a : list) { %>
	var marker = new kakao.maps.Marker({
	    position: new kakao.maps.LatLng(<%= a.getArboretum_latitude() %>, <%= a.getArboretum_longitude() %>)
	}); 	
	
	marker.setMap(map);
<% } %>

//마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
marker.setClickable(true);
	
var infowindow = new kakao.maps.InfoWindow({
	content : '<div style="padding:5px;">' + <%  %> + '</div>',
	removable : true
});

//마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
    // 마커 위에 인포윈도우를 표시합니다
    infowindow.open(map, marker);
});


</script>
</body>
</html>