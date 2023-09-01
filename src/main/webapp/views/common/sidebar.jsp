<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="/malant/resources/common/css/sidebar.css" />
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
</head>
<body>
	<div class="sidebar">
		<div class="sidebar-header">
			<span class="sidebar-title"><a href="/malant"> <img
					src="/malant/resources/common/images/main_tilte.gif" alt="식물 검색" /></a></span>
		</div>
		<section>
			<ul id="new_categories">
				<li><a href="/malant">식물 검색</a></li>
				<li><a href="/malant/views/board/boardMainList.jsp">커뮤니티</a></li>
				<li><a 
				<% if(loginMember == null) { %>
					href="/malant/views/member/loginPage.jsp"
				<% }else { %>
					href="/malant/mplist?user_no=<%= loginMember.getUserNo() %>"
				<% } %>>다이어리</a></li>
				<li><a href="/malant/views/map/mapMain.jsp">전국 식물원</a></li>
				<li><a href="/malant/smplist">스토어</a></li>
				<li><a href="/malant/views/notice/noticeMainList.jsp">공지/이벤트</a></li>
			</ul>
		</section>
		<!-- 로그인 영역 -->
		<% if (loginMember == null) { // 로그인하지 않았을 때 %>
			<div class="login-section">
				<hr solid color="#ddd" />
				<div class="login-box" onclick="location.href='/malant/views/member/loginPage.jsp;'">
					로그인하러 가기
				</div>
			</div>
			
			<!-- 회원가입/아이디/비밀번호 찾기 영역 -->
			<div class="account-section">
				<a href="/malant/views/member/enrollMember.jsp" class="account-link">회원가입</a><span class="login-divide">|</span>
				<!-- 아이디/비밀번호 찾기는 새창을 띄워 진행 -->
				<a href="#" class="account-link" onclick="window.open('/malant/findAccount.jsp?find=id', '_blank', 'width=900, height=1000');">아이디찾기</a><span class="login-divide">|</span>
				<a href="#"	class="account-link" onclick="window.open('/malant/findAccount.jsp?find=pwd', '_blank', 'width=900, height=1000');">비밀번호재설정</a>
			</div>
		<% } else { %>
			<div class="login-section">
				<%= loginMember.getNickname() %>님 환영합니다.<br>
				
				<a href="/malant/views/member/confirmMemberBeforeInfo.jsp?userid=<%= loginMember.getUserId() %>">마이페이지</a> &nbsp; 
				<a href="/malant/logout">로그아웃</a>
			</div>
		<% } %>
	</div>
</body>
</html>
