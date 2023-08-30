<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
<style>
	container {
		display: flex;
	}
	
	.info-container {
		border: 1px solid red;
		width: 500px;
		height: 600px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar-container">
			<!-- 사이드바 -->
			<%@ include file="../../views/common/sidebar.jsp" %>
		</div>
		
		<!-- 회원 정보 페이지 -->
		<div class="info-container">
			<table class="info-table">
				<tr><th>아이디</th><td colspan="2"><%= loginMember.getUserId() %></td></tr>
				<tr><th>닉네임</th><td><%= loginMember.getNickname() %></td><td><input type="button" class="nickname-change" value="변경"></td></tr>
				<tr><th>이메일</th><td><%= loginMember.getEmail() %></td><td><input type="button" class="email-change" value="변경"></td></tr>
				<tr><th>현재 비밀번호</th><td colspan="2"><input type="password"></td></tr>
				<tr><th>새 비밀번호</th><td colspan="2"><input type="password"></td></tr>
				<tr><th>비밀번호 확인</th><td colspan="2"><input type="password"></td></tr>
				<tr><th rowspan="2">수신 설정</th><td><label><input type="checkbox">관리 알림 메일</label></td></tr>
				<tr><td><label><input type="checkbox">이벤트 소식</label></td></tr>
			</table>
		</div>
	</div>
</body>
</html>