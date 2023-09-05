<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, store.main.model.vo.MainContent"%>
<%
ArrayList<MainContent> mlist = (ArrayList<MainContent>) request.getAttribute("mlist");
ArrayList<MainContent> plist = (ArrayList<MainContent>) request.getAttribute("plist");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Malant Store</title>
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
<link rel="stylesheet" href="/malant/resources/store/css/storeMain.css" />

<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<style>
.body {
	font-family: "NanumGothicEB";
}
</style>

<script>
	$(document)
			.ready(
					function() {
<%-- 이미지 URL을 문자열로 구성 --%>
	
<%StringBuilder imageUrls = new StringBuilder();
for (MainContent m : mlist) {
	imageUrls.append("\"").append(m.getBannerImage()).append("\",");
}
if (imageUrls.length() > 0) {
	imageUrls.deleteCharAt(imageUrls.length() - 1); // 마지막 쉼표 제거
}%>
	// 이미지 슬라이더 설정
						var currentIndex = 0;
						var images = [ <%=imageUrls.toString()%>];
						var slider = $(".image-slider img");

						function showImage(index) {
							slider.hide();
							slider.eq(index).fadeIn(1000);
						}

						function nextSlide() {
							currentIndex = (currentIndex + 1) % images.length;
							showImage(currentIndex);
						}

						// 슬라이더 초기화
						showImage(currentIndex);

						// 자동 슬라이딩 시작
						var slideInterval = setInterval(nextSlide, 5000);
					});
</script>

</head>
<body>
	<div class="container">
		<!-- 사이드바 -->
		<%@ include file="common/storeSidebar.jsp"%>

		<div class="content">
			<!-- 이미지 슬라이더 -->
			<div class="image-slider">
				<%
				for (MainContent m : mlist) {
				%>
				<a href="<%=m.getBannerLink()%>"> <img class="banner-image"
					src="<%=m.getBannerImage()%>"></a>
				<%
				}
				%>
			</div>
			<br> <br>
			<h2>전체 상품</h2>
			<hr color="#9CB4D4">
			<br>
			<!--  컨텐츠 영역 -->
			<div class="productcontainer">
				<%
				for (MainContent p : plist) {
				%>
				<div class="product-card" onclick="javascript:location.href='/malant/pdetail?productid=<%= p.getProductId() %>';">
					<img class="product-image" src="<%=p.getProductThumbnail()%>">
					<div class="product-name"><%=p.getProductName()%></div>
					<div class="product-price"><%=p.getPrice() + "원"%></div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>