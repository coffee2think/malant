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
	<div class="searchbar">
		<form action="/malant/plsearch" method="get">
			<input type="search" class="searchbox" name="keyword" value="<%= searchKeyword %>" placeholder="검색어를 입력하세요." required>
			<input type="submit" class="searchbtn" value="검색">
		</form>
	</div>
	<div class="filters">
		<select class="filter" name="difficulty">
			<option value="difficulty-all">난이도</option>
			<option value="difficulty-beginner">초보자</option>
			<option value="difficulty-experienced">경험자</option>
			<option value="difficulty-expert">전문가</option>
		</select>
		<select class="filter" name="growth_rate">
			<option value="glowthrate-all">성장속도</option>
			<option value="glowthrate-fast">빠름</option>
			<option value="glowthrate-normal">보통</option>
			<option value="glowthrate-slow">느림</option>
		</select>
		<select class="filter" name="usecase">
			<option value="usecase-all">용도</option>
			<option value="usecase-view">관상용</option>
			<option value="usecase-eat">식용</option>
			<option value="usecase-landscape">조경용</option>
		</select>
		<select class="filter" name="size">
			<option value="size-all">크기</option>
			<option value="size-small">소형</option>
			<option value="size-medium">중형</option>
			<option value="size-large">대형</option>
		</select>
		<div class="filter">
			<label><input type="checkbox" value="purification">공기정화</label>
		</div>
		<div class="filter">
			<label><input type="checkbox">가습효과</label>
		</div>
		<input type="button" class="filter" value="더보기">
	</div>
</div>
</body>
</html>