<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, search.model.vo.Plant, common.Paging" %>
<%
	String keywd = (String) request.getAttribute("keyword");
	
	ArrayList<Plant> list = (ArrayList<Plant>) request.getAttribute("list");
	int nowPage = ((Integer) request.getAttribute("currentPage")).intValue();
	
	int listCount = ((Paging) request.getAttribute("paging")).getListCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= keywd %> 검색 결과</title>
<style>
.container {
	height: 100vh;
	display: flex;
	flex-wrap: wrap;
	align-content: center;
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

.search-area {
	width: 800px;
	height: 130px;
	border: 1px solid green;
	margin-top: 10px;
	margin-bottom: 10px;
	display: flex;
	flex-direction: column;
	align-content: center;
	justify-content: center;
}

.searchbar {
	width: 800px;
	height: 50px;
	border: 1px solid blue;
	padding-top: 10px;
	padding-bottom: 10px;
	display: flex;
	align-content: center;
	justify-content: center;
}

.searchbox {
	width: 700px;
	height: 50px;
	text-align: center;
}

.searchbtn {
	width: 50px;
	height: 50px;
}

.filters {
	width: 800px;
	height: 50px;
	border: 1px solid blue;
	display: flex;
	justify-content: center;
	align-content: center;
}

.filter {
	width: 100px;
	height: 40px;
	position: relative;
	margin: 5px;
	text-align: center; 
}

.plant-card {
	width: 150px;
	height: 200px;
	border: 1px solid red;
	margin: 20px;
}

.results {
	width: 800px;
	border: 1px solid green;
	display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	align-content: center;
	justify-content: center;
}

.result-guide {
	display: flex;
	justify-content: space-between;
	 
}

.result-cards {
	width: 800px;
	border: 1px solid blue;
	display: flex;
	flex-wrap: wrap;
	align-content: center;
	justify-content: center;
	margin-top: 10px;
	margin-bottom: 10px;
}

.card-image {
	width: 150px;
	height: 150px;
	display: flex;
	justify-content: center;
	align-items: center; 
}

.card-title {
	width: 150px;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.sort-items {
	width: 200px;
	border: 1px solid blue;
	display: flex;
	align-content: center;
	justify-content: center;
	flex-wrap: wrap;
}

.sort-item {
	width: 70px;
	height: 40px;
    border: 1px solid black;
    display: flex;
    justify-content: center;
    align-content: center;
    flex-wrap: wrap;
}

.result-view {
	display: flex;
	flex-direction: column;
}
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<%@ include file="../common/sidebar.jsp" %>
		</div>
		<div class="content">
			<%@ include file="searchbar.jsp" %>
			
			<div class="results">
				<div class="result-guide">
					<% if(list.size() == 0) { %>
						<h4><%= keywd %> 에 대한 검색 결과가 존재하지 않습니다.</h4>
					<% } else { %>
						<div class="result-message">
							<h4>'<%= keywd %>' 에 대한 검색 결과입니다.(<%= listCount %> 건)</h4>
						</div>
						<div class="sort-items">
							<!-- 관련도순 어떻게 검색해올지 고민
							<div class="sort-item"><a href="#">관련도순</a></div>
							 -->
							<div class="sort-item" id="sort-name"><a href="#">이름순</a></div>
							<div class="sort-item" id="sort-viewcount"><a href="#">인기순</a></div>
						</div>
					<% } %>
				</div>
				
				<% if(list.size() > 0) { %>
				<div class="result-view">
					<div class="result-cards">
						<% for (Plant plant : list) { %>
						<div class="plant-card" onclick="javascript: location.href='/malant/pldetail?pno='+<%= plant.getPlantNo() %>">
							<div class="card-image">
								<img src=<%= plant.getPlantImg() %> width="140" height="140">
							</div>
							<div class="card-title">
								<center><p4><%= plant.getPlantName() %></p4></center>
							</div>
						</div>
					<%	} // for %>
					</div>
					<div class="paging">
						<%@ include file="../common/pagingView.jsp" %>
					</div>
				</div>
				<% } else { %>
					<img src="/malant/resources/common/images/mandragora_character.jpg">
				<% } %>
				
			</div>
		</div>
	</div>
</body>
</html>