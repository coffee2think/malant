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
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<%@ include file="../common/sidebar.jsp" %>
		</div>
		<div class="content">
			<div class="">
			</div>
		</div>
	</div>
</body>
</html>