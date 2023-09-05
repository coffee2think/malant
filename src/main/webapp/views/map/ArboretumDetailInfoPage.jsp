<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="map.model.vo.Arboretum"%>
<% 
	Arboretum arboretum = (Arboretum)request.getAttribute("arboretum"); 
%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수목원 정보</title>
<style type="text/css">
body {
	 font-family: Arial, sans-serif;
	 background-color: #BFBFBF;
	 margin: 0;
	 display: flex;
	 flex-direction: column;
	 align-items: center;
	 justify-content: center;
	 height: 100vh;
}

.content-all{
  display: inline-grid;
  justify-content: start;
  margin-left: 250px; /* 사이드바 너비만큼 여백 추가 */
  padding: 20px;
  box-sizing: border-box; /* 여백을 포함한 전체 너비 설정 */
}


.tree-title {
  padding: 10px;
  box-sizing: border-box;
  text-align: center;
  margin: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative; /* 중앙에 배치하기 위해 상대 위치 설정 */
}

#title-box{
    width: 250px;
    height: 50px;
    background-color: #f5f5f5;
    margin-top: 7px;
    border: 1px solid #ccc;
}

#title{
margin-top: 7px;
}

.info-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

.tree-card {
	width: calc(50% - 20px);
	max-width: 400px; /* 최대 너비 설정 */
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f5f5f5;
	box-sizing: border-box;
	text-align: center;
	margin: 10px;
}

.info-content {
	margin-top: 5px;
	text-align: left;
	max-width: 100%; /* 내용의 최대 너비 설정 */
}

.outer-container {
	display: flex;
}
/* 각 섹션의 제목 스타일 */
.tree-card h2 {
  font-size: 18px; /* 제목 폰트 크기 조정 */
  color: #333; /* 제목 글자 색상 설정 */
  margin-bottom: 10px; /* 아래 여백 추가 */
  text-transform: uppercase; /* 제목 텍스트 대문자로 변환 */
  position: relative; /* 제목 내에 도형을 배치하기 위해 상대 위치 설정 */
}

/* 제목 앞에 도형 추가 */
.tree-card h2::before {
  content: "◈"; /* 원하는 도형으로 변경 가능 */
  display: inline-block;
  font-size: 20px; /* 도형 크기 설정 */
  margin-right: 10px; /* 도형과 텍스트 사이 여백 설정 */
  color: #f6a623; /* 도형 색상 설정 */
}

/* 각 섹션의 내용 스타일 */
.tree-card .content {
  font-size: 16px; /* 내용 폰트 크기 조정 */
  color: #666; /* 내용 글자 색상 설정 */
  margin-top: 5px; /* 위 여백 추가 */
  line-height: 1.5; /* 줄 간격 설정 */
}

/* 각 섹션의 배경색 변경 */
.tree-card:nth-child(odd) {
  background-color: #f9f9f9; /* 홀수 번째 섹션 배경색 설정 */
}
</style>
</head>

<body>
	<div class="outer-container">
		<div style="position:absolute;top:0;left:0;"><%@ include file="../common/sidebar.jsp"%></div>
		<hr>
		<div class="content-all">
			<div class="tree-title">
				<div id=title-box>
					<h2 id="title"><%= arboretum.getArboretum_name() %></h2>
				</div>
			</div>
			<div class="info-container">
				<div class="tree-card">
					<h2 id="address">주소</h2>
					<br>
					<div class="content"><%= arboretum.getArboretum_address() %></div>
				</div>
				<div class="tree-card">
					<h2 id="website">홈페이지</h2>
					<div class="content">
						<br>
						<% if(arboretum.getArboretum_homepage() == null) { %>
							홈페이지 개설안함
						<% }else{ %>
							<a href="https://<%= arboretum.getArboretum_homepage() %>"><%= arboretum.getArboretum_homepage() %></a>
						<% } %>
					</div>
				</div>
				<div class="tree-card">
					<h2 id="openClose">Open/Close</h2>
					<div class="info-content">
						<br>개관 :
						<%= arboretum.getOpen_days() %><br>
						<br>휴관 :
						<%= arboretum.getClosed_days() %>
					</div>
				</div>
				<div class="tree-card">
					<h2 id="entranceFee">입장료</h2>
					<div class="info-content">
						<% if(arboretum.getEntrance_fee_yn().equals("Y")) { %>
							<br>성인 :
							<%= arboretum.getFee_adult() %>
							<br>청소년 :
							<%= arboretum.getFee_teenage() %>
							<br>어린이입장료 :
							<%= arboretum.getFee_child() %>
							<br>장애인 :
							<%= arboretum.getFee_disabled() %>
							<br>기타 :
							<%= arboretum.getFee_etc() %>
						<% }else{ %>
							<br><br>
							<div align="center">
								무료
							</div>
						<% } %>
					</div>
				</div>
				<div class="tree-card">
					<h2 id="phone">전화번호</h2>
					<br>
					<% if(arboretum.getArboretum_tel() != null) { %>
						<div class="content"><%= arboretum.getArboretum_tel() %></div>
					<% }else{ %>
						등록된 번호가 없습니다.
					<% } %>
				</div>
				<div class="tree-card">
					<h2 id="companion">동반 입장</h2>
					<div class="info-content">
						<br>반려동물 동반 : 
						<% if(arboretum.getWith_pet_yn().equals("Y")) { %>
							가능<br>
						<% }else{ %>
							불가<br>
						<% } %>
						<br>안내견 동반 : 
						<% if(arboretum.getWith_guidedog_yn().equals("Y")) { %>
							가능<br>
						<% }else{ %>
							불가<br>
						<% } %>
					</div>
				</div>
				<div class="tree-card">
					<h2 id="education">교육프로그램</h2>
					<div class="info-content">
					<% if(arboretum.getEdu_program_yn().equals("Y")) { %>
						<br>교육프로그램명 :
						<%= arboretum.getEdu_program_name() %><br>
						<br>교육프로그램 예약 여부 : 가능 
					<% }else{ %>
						<br>
						<div align="center">
							교육프로그램을 운영하지 않습니다.
						</div>
						
					<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>