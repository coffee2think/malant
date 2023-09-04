<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="search.model.vo.Plant" %>
<%
	Plant plant = (Plant) request.getAttribute("plant");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= plant.getPlantName() %> 상세정보</title>
<style>
.container {
	height: 100vh;
	display: flex;
	flex-wrap: wrap;
}

.content {
	border: 1px solid red;
	width: 800px;
	height: auto;
	display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	align-items : center;
	justify-content: center;
	margin: auto;
}

.simple-wrapper {
	width: 800px;
	height: 350px;
	border: 1px solid green;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.simple-info {
	width: 400px;
	height: 300px;
	border: 1px solid blue;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-content: center;
}

.plant-photo {
	width: 250px;
	height: 300px;
	border: 1px solid blue;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.simple-item {
	width: 380px;
	height: 80px;
	border: 1px solid orange;
	margin: 10px;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.detail-wrapper {
	width: 800px;
	/* height: 1200px; */
	border: 1px solid green;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.detail-title {
	width: 750px;
	height: 50px;
	border: 1px solid blue;
	display: flex;
	justify-content: flex-start;
	align-content: center;
	flex-wrap: wrap;
}

.detail-feature {
	width: 750px;
	height: 400px;
	border: 1px solid blue;
	display: flex;
	justify-content: flex-start;
	align-content: center;
	flex-wrap: wrap;
}

.tips-and-precautions {
	width: 750px;
	height: 300px;
	border: 1px solid blue;
	display: flex;
	justify-content: flex-start;
	align-content: center;
	flex-wrap: wrap;
}

.managing-info {
	width: 750px;
	height: 400px;
	border: 1px solid blue;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.managing-item {
	width: 180px;
	height: 400px;
	border: 1px solid blue;
	display: flex;
	justify-content: flex-start;
	align-content: center;
	flex-wrap: wrap;
}
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<%@ include file="../common/sidebar.jsp" %>
		</div>
		<div class="content">
			<div class="simple-wrapper">
				<div class="simple-info">
					<div class="simple-item">식물 이름</div> <!-- class="plantname" -->
					<div class="simple-item">간단한 소개</div> <!-- class="simple-introduce" -->
					<div class="simple-item">주요 특징</div> <!-- class="main-feature" -->
				</div>
				<div class="plant-photo">식물 사진</div>
			</div>
			<div class="detail-wrapper">
				<div class="detail-title">식물 상세 정보</div>
				<div class="detail-feature">세부 특징 영역(표가 나올 영역)</div>
				<div class="tips-and-precautions">추가적인 정보 및 주의사항 영역(조언 정보가 나올 영역)</div>
				<div class="managing-info">
					<div class="managing-item">토양/비료</div>
					<div class="managing-item">관수주기/병충해관리</div>
					<div class="managing-item">개화시기/결실시기</div>
					<div class="managing-item">번식시기</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>