<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container > div {
	float : left;
}
</style>
    <meta charset="utf-8">
    <title>마커 클러스터러에 클릭이벤트 추가하기</title>
    
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

    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 13// 지도의 확대 레벨
    });

    var clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        averageCenter: true,
        minLevel: 10,
        disableClickZoom: false
    });

    $.get("/malant/resources/map/js/ArboretumLocation.json", function(data) {
        var markers = $(data.positions).map(function(i, position) {
            var marker = new kakao.maps.Marker({
                position: new kakao.maps.LatLng(position.lat, position.lng)
                
            });
			
            // 마커 클릭 이벤트 등록
            kakao.maps.event.addListener(marker, 'click', function() {
            	console.log(name);
                // 인포윈도우 생성 및 옵션 설정
                var infowindow = new kakao.maps.InfoWindow({
                    content:
		                    '<div class="info">' + 
		                    '   <div class="title" id="arname">' + position.name + '&nbsp;&nbsp;&nbsp;&nbsp;</div>' +
		                    '   <div class="address">주소 : ' +  + '</div>' +
		                    '   <div class="page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="함수()">상세페이지</a></div>' +	
		                    '</div>',
                    removable: true
                });
                
                
                $.ajax({
                	url:"/malant/arbriefinfo",
                	type: "get",
                	data: {lat : position.lat, lng : position.lng},
                	dataType: "json",
                	success: function(data){
                		
                	},
                	error : function(jqXHR, textStatus, errorThrown){
            			console.log(jqXHR + ", " + textStatus + ", " + errorThrown);
            		}
                	}); 
                
                // 클릭된 마커의 위치에 인포윈도우 표시
                infowindow.open(map, marker);
                
                
                  kakao.maps.event.addListener(map, 'click', function() {
                	  
                    infowindow.close();
                });  
                   
            	 // 클릭된 마커 이외의 다른 마커의 인포윈도우 닫기
               /*  markers.each(function(index, otherMarker) {
                    if (otherMarker !== marker) {
                        infowindow.close();
                    }
                });  */
            });

            return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
        
       /* function(){
        	document.getElementById("값").text
        } */
    });
</script>


</body>
</html>