<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String searchKeyword = (String) request.getAttribute("keyword");
	if(searchKeyword == null) {
		searchKeyword = "";
	}
	
	String difficulty = (String) request.getAttribute("difficulty");
	String growthRate = (String) request.getAttribute("growth_rate");
	String smell = (String) request.getAttribute("smell");
	String placement = (String) request.getAttribute("placement");
	String effectPurification = (String) request.getAttribute("effect_purification");
%>
<!DOCTYPE html>
<html>
<head>
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script>
	$(function() {
		var difficulty = <%= "\"" + difficulty + "\"" %>;
		var growthRate = <%= "\"" + growthRate + "\"" %>;
		var smell = <%= "\"" + smell + "\"" %>;
		var placement = <%= "\"" + placement + "\"" %>;
		var effectPurification = <%= "\"" + effectPurification + "\"" %>;
		
		console.log('difficulty : ' + difficulty);
		console.log('growthRate : ' + growthRate);
		console.log('smell : ' + smell);
		console.log('placement : ' + placement);
		console.log('effectPurification : ' + effectPurification);

		$('.filter').each(function() {
			$(this).find('option').each(function(){
				var value = $(this).attr('value')
				
				console.log('parent : ' + parent.val());
				
				if(value == difficulty) {
					$(this).attr('selected', true);
					console.log($(this).attr('selected', true));
				}
				/*
				switch (name) {
				case 'difficulty':
					parent.find('option').each(function(){
						$(this).attr('selected', '');
					})
					console.log('attr : ' + $(this).attr('value'));
					if(value == difficulty) {
						$(this).attr('selected', 'selected');
						//console.log('attr : ' + $(this).attr('selected', 'selected'));
					}
					break;

				default:
					break;
				}
				*/
			})
			
		});
		
		if('<%= effectPurification %>' == 'Y') {
			$('checkbox-purification').prop('selected', true);
		}
		
	});
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
			<label><input type="checkbox" class="checkbox-purification" name="effect_purification" value="Y">공기정화</label>
		</div>
	</form>
</div>
</body>
</html>