<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="search.model.vo.Plant"%>
<%
	Plant plant = (Plant) request.getAttribute("plant");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=plant.getPlantName()%> 상세정보</title>
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
	align-items: center;
	justify-content: center;
	margin: auto;
}

.simple-wrapper {
	width: 800px;
	height: 350px;
	border: 1px solid green;
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
}

.simple-info {
	width: 500px;
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

.simple-item-wrapper {
	width: 480px;
	height: 80px;
	border: 1px solid orange;
	margin: 10px;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.main-feature-wrapper {
	width: 480px;
	height: 220px;
	border: 1px solid orange;
	margin: 10px;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.name-title {
	width: 380px;
	height: 30px;
	border: 1px solid orange;
}

.name-content {
	width: 380px;
	height: 50px;
	border: 1px solid orange;
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
			<%@ include file="../common/sidebar.jsp"%>
		</div>
		<div class="content">
			<div class="simple-wrapper">
				<div class="simple-info">
					<div class="simple-item-wrapper">
						<table>
							<tr><th>이름</th><td><%= plant.getPlantName() %></td></tr>
							<tr><th>영명</th><td><%= plant.getEnglishName() %></td></tr>
							<tr><th>학명</th><td><%= plant.getScientificName() %></td></tr>
						</table>
					</div>
					<div class="main-feature-wrapper">
						<div class="main-feature-title">주요 특징</div>
						<div class="main-feature-content">
							<table class="main-feature-table">
								<% if(plant.getDifficulty() != null) { %>
									<tr><th>키움 난이도</th><td><%= plant.getDifficulty() %></td></tr>
								<% } %>
								<% if(plant.getTemperature() != null) { %>
									<tr><th>적정 온도</th><td><%= plant.getTemperature() %></td></tr>
								<% } %>
								<% if(plant.getHumidity() != null) { %>
									<tr><th>적정 습도</th><td><%= plant.getHumidity() %></td></tr>
								<% } %>
							</table>
						</div>
					</div>
				</div>
				<div class="plant-photo"><img src="<%= plant.getPlantImg() %>" width="230" height="280"></div>
			</div>
			<div class="detail-wrapper">
				<div class="detail-title">식물 상세 정보</div>
				<div class="detail-feature">세부 특징 영역(표가 나올 영역)</div>
				<div class="tips-and-precautions">추가적인 정보 및 주의사항 영역(조언 정보가 나올 영역)
					<div>
						<div>배치 정보</div>
						<div><%= plant.getPlacement() %></div>
					</div>
				</div>
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