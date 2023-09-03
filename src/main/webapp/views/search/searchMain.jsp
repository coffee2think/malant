<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>식물 검색</title>
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<style>
	.search-main {
		width: 800px;
		height: 500px;
		border:1px solid green;
		display: flex;
		flex-direction: column;
		align-items: center;
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
		display: flex;
		text-align: center;
		justify-items: center;
		align-items: center;
		flex-wrap: wrap;
	}
	
	.bestboards {
		width:800px;
		height:300px;
		border:1px solid red;
		margin: auto;
	}
</style>
</head>
<body>
	<div class="search-main">
		<div class="search-area">
			<div class="searchbar">
				<form action="/malant/plsearch" method="get">
					<input type="search" class="searchbox" name="keyword" placeholder="검색어를 입력하세요." required>
					<input type="submit" class="searchbtn" value="검색">
				</form>
			</div>
			<div class="filters">
				<select class="filter" name="difficulty">
					<option>난이도</option>
					<option>초보자</option>
					<option>경험자</option>
					<option>전문가</option>
				</select>
				<select class="filter" name="growth_rate">
					<option>성장속도</option>
					<option>빠름</option>
					<option>보통</option>
					<option>느림</option>
				</select>
				<select class="filter" name="usecase">
					<option>용도</option>
					<option>관상용</option>
					<option>식용</option>
					<option>조경용</option>
				</select>
				<select class="filter" name="size">
					<option>크기</option>
					<option>소형</option>
					<option>중형</option>
					<option>대형</option>
				</select>
				<div class="filter">
					<label><input type="checkbox">공기정화</label>
				</div>
				<div class="filter">
					<label><input type="checkbox">가습효과</label>
				</div>
				<input type="button" class="filter" value="더보기">
			</div>
		</div>
		
		<!-- 커뮤니티 인기글 목록 배너 -->
		<div class="bestboards">
			커뮤니티 인기글이 보여질 영역입니다.
		</div>
	</div>
</body>
</html>