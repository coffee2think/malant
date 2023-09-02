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
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.content-all{
    display: inline-grid;
    justify-content: start;
}


.tree-title {
    padding: 10px;
    box-sizing: border-box;
    text-align: center;
    margin: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
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
</style>
</head>

<body>
	<div class="outer-container">
		<div><%@ include file="../common/sidebar.jsp"%></div>
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
						<%= arboretum.getWith_pet_yn() %><br>
						<br>안내견 동반 :
						<%= arboretum.getWith_guidedog_yn() %>
					</div>
				</div>
				<div class="tree-card">
					<h2 id="education">교육프로그램</h2>
					<div class="info-content">
					<% if(arboretum.getEdu_program_yn().equals("Y")) { %>
						<br>교육프로그램명 :
						<%= arboretum.getEdu_program_name() %><br>
						<br>교육프로그램 예약 여/부 :
						<%= arboretum.getEdu_pro_reservation() %>
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