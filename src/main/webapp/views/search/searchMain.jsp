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
		width: 550px;
		height: 500px;
		border:1px solid green;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin: auto;
	}
	
	.searchbar {
		width: 500px;
		height: 50px;
		border:1px solid red;
		margin: auto;
	}

	.searchbox {
		width: 450px;
		height: 45px;
	}

	.searchbtn {
		width: 40px;
		height: 45px;
	}
	
	.bestboards {
		width:500px;
		height:300px;
		border:1px solid red;
		margin: auto;
	}
</style>
</head>
<body>
	<div class="search-main">
		<!-- 검색 버튼 -->
		<div class="searchbar">
			<form action="/malant/plsearch" method="get">
				<input type="search" class="searchbox" name="keyword" placeholder="검색어를 입력하세요.">
				<input type="submit" class="searchbtn" value="검색">
			</form>
		</div>
		
		<!-- 커뮤니티 인기글 목록 배너 -->
		<div class="bestboards">
			커뮤니티 인기글이 보여질 영역입니다.
		</div>
	</div>
</body>
</html>