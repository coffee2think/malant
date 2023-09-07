<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="search.model.vo.Plant"%>
<%
	Plant plant = (Plant) request.getAttribute("plant");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= plant.getPlantName ()%> 상세정보</title>
<style>
.container {
	height: 100vh;
	display: flex;
	flex-wrap: wrap;
}

.content {
	/* border: 1px solid red; */
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
	height: 300px;
	/* border: 1px solid green; */
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
	height: 100px;
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
	/* border: 1px solid green; */
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
	height: 200px;
	border: 1px solid blue;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.managing-info {
	width: 750px;
	height: 300px;
	border: 1px solid blue;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-wrap: wrap;
}

.managing-item {
	width: 750px;
	height: 300px;
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
					<div class="simple-item-wrapper">
						<table>
							<tr><th>이름</th><td><%= plant.getPlantName() %></td></tr>
							<tr><th>영명</th><td><%= plant.getEnglishName() %></td></tr>
							<tr><th>학명</th><td><%= plant.getScientificName() %></td></tr>
							<tr><th>과명</th><td><%= plant.getFamilyName() %></td></tr>
						</table>
					</div>
					<div class="main-feature-wrapper">
						<table class="main-feature-table">
							<tr><th colspan="2">주요 특징</th></tr>
							<% if(plant.getDifficulty() != null) { %>
								<tr><th>키움 난이도</th><td><%= plant.getDifficulty() %></td></tr>
							<% } %>
							<% if(plant.getTemperature() != null) { %>
								<tr><th>적정 온도</th><td><%= plant.getTemperature() %></td></tr>
							<% } %>
							<% if(plant.getHumidity() != null) { %>
								<tr><th>적정 습도</th><td><%= plant.getHumidity() %></td></tr>
							<% } %>
							<% if(plant.getLight() != null) { %>
								<tr><th>햇빛</th><td><%= plant.getLight() %></td></tr>
							<% } %>
							<% if(plant.getWateringSpring() != null) { %>
								<tr><th>물주기</th><td><%= plant.getWateringSpring() %></td></tr>
							<% } %>
							
						</table>
					</div>
				</div>
				<div class="plant-photo"><img src="<%= plant.getPlantImg() %>" width="230" height="280"></div>
			</div>
			<div class="detail-wrapper">
				<div class="tips-and-precautions">
					<% if(plant.getAdviceInfo() != null || plant.getUsefulInfo() != null || plant.getManagingTips() != null) { %>
					<div class="tips-title">추가적인 정보 및 주의사항 영역</div>
					<div class="tips">
						<% if(plant.getAdviceInfo() != null) { %>
							<%= plant.getAdviceInfo() %><br>
						<% } %>
						
						<% if(plant.getUsefulInfo() != null) { %>
							<%= plant.getUsefulInfo() %><br>
						<% } %>
					</div>
					<% } %>
				</div>
				<div class="managing-info">
					<div class="managing-item">
						<table width="750">
							<% if(plant.getSoil() != null) { %>
								<tr><th>토양</th><td><%= plant.getSoil() %></td></tr>
							<% } %>
							<% if(plant.getFertilizer() != null) { %>
								<tr><th>비료</th><td><%= plant.getFertilizer() %></td></tr>
							<% } %>
							<% if(plant.getManagingDiseasesPests() != null) { %>
								<tr><th>병충해관리</th><td><%= plant.getManagingDiseasesPests() %></td></tr>
							<% } %>
							<% if(plant.getSeasonBlooming() != null) { %>
								<tr><th>개화시기</th><td><%= plant.getSeasonBlooming() %></td></tr>
							<% } %>
							<% if(plant.getSeasonFruiting() != null) { %>
								<tr><th>결실시기</th><td><%= plant.getSeasonFruiting() %></td></tr>
							<% } %>
							<% if(plant.getSeasonPropagation() != null) { %>
								<tr><th>번식시기</th><td><%= plant.getSeasonPropagation() %></td></tr>
							<% } %>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>