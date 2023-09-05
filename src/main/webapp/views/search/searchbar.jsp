<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String searchKeyword = (String) request.getAttribute("keyword");
	if(searchKeyword == null) {
		searchKeyword = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<script>
	
</script>
</head>
<body>
<div class="search-area">
	<form action="/malant/plsearch" method="get">
		<div class="searchbar">
			<input type="search" class="searchbox" name="keyword" value="<%= searchKeyword %>" placeholder="검색어를 입력하세요.">
			<input type="submit" class="searchbtn" value="검색">
		</div>
		<div class="filters">
			<select class="filter" name="difficulty">
				<option value="all" selected>난이도</option>
				<option value="초보자">초보자</option>
				<option value="경험자">경험자</option>
				<option value="전문가">전문가</option>
			</select>
			<select class="filter" name="growth_rate">
				<option value="all" selected>성장속도</option>
				<option value="빠름">빠름</option>
				<option value="보통">보통</option>
				<option value="느림">느림</option>
			</select>
			<select class="filter" name="smell">
				<option value="all" selected>향</option>
				<option value="강함">강함</option>
				<option value="중간">중간</option>
				<option value="약함">약함</option>
				<option value="거의 없음">거의 없음</option>
			</select>
			<select class="filter" name="placement">
				<option value="all" selected>배치장소</option>
				<option value="거실">거실</option>
				<option value="발코니">발코니</option>
				<option value="어두운 곳">어두운 곳</option>
			</select>
			<div class="filter">
				<label><input type="checkbox" name="purification" value="purification">공기정화</label>
			</div>
		</div>
	</form>
</div>
</body>
</html>