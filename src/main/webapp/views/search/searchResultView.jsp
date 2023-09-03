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

.sort-items {
	width: 300px;
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
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<%@ include file="../common/sidebar.jsp" %>
		</div>
		<div class="content">
			<div class="search-area">
				<div class="searchbar">
					<form action="/malant/plsearch" method="get">
						<input type="search" class="searchbox" name="keyword" value="<%= keyword %>" placeholder="검색어를 입력하세요.">
						<input type="submit" class="searchbtn" value="검색">
					</form>
				</div>
				<div class="filters">
					<select class="filter">
						<option>난이도</option>
						<option>초보자</option>
						<option>경험자</option>
						<option>전문가</option>
					</select>
					<select class="filter">
						<option>성장속도</option>
						<option>빠름</option>
						<option>보통</option>
						<option>느림</option>
					</select>
					<select class="filter">
						<option>효능</option>
						<option>빠름</option>
						<option>보통</option>
						<option>느림</option>
					</select>
					<select class="filter">
						<option>크기</option>
						<option>소형</option>
						<option>중형</option>
						<option>대형</option>
					</select>
					<input type="button" class="filter" value="더보기">
				</div>
			</div>
			
			<div class="results">
				<div class="result-guide">
					<% if(list.size() == 0) { %>
						<h4><%= keyword %> 에 대한 검색 결과가 존재하지 않습니다.</h4>
					<% } else { %>
						<div class="result-message">
							<h4>'<%= keyword %>' 에 대한 검색 결과입니다.(<%= list.size() %> 건)</h4>
						</div>
						<div class="sort-items">
							<div class="sort-item"><a href="/">관련도순</a></div>
							<div class="sort-item"><a href="#">인기순</a></div>
							<div class="sort-item"><a href="#">이름순</a></div>
						</div>
					<% } %>
				</div>
				<div class="result-cards">
					<% if(list.size() == 0) { %>
						<%= keyword %> 에 대한 검색 결과가 존재하지 않습니다.
					<% } else {
						for (Plant plant : list) {
					%>
						<div class="plant-card" onclick="javascript: location.href = '/malant/pldetail?pno=' + <%= plant.getPlantNo() %>"><p4><%= plant.getPlantName() %></p4></div><br>
					<%	} %>
						
					<% } %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>