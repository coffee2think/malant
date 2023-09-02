<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, search.model.vo.Plant" %>
<%
	String keyword = (String) request.getAttribute("keyword");
	ArrayList<Plant> list = (ArrayList<Plant>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= keyword %> 검색 결과</title>
<style>
.container {
	display: flex;
}

.content {
	border: 1px solid red;
	width: 500px;
	height: auto;
	display: flex;
	flex-wrap: wrap;
	align-items : center;
	justify-content: center;
	margin: auto;
}

.plant-card {
	width: 150px;
	height: 200px;
	border: 1px solid red;
}

</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<%@ include file="../common/sidebar.jsp" %>
		</div>
		<div class="content">
			<% if(list.size() == 0) { %>
				<%= keyword %> 에 대한 검색 결과가 존재하지 않습니다.
			<% } else {
				for (Plant plant : list) {
			%>
				<div class="plant-card"><p4><%= plant.getPlantName() %></p4></div><br>
			<%	} %>
				
			<% } %>
		</div>
	</div>
</body>
</html>