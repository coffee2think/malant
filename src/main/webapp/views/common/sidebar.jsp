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
<script>
	$(function() {
		$('#gologin').click(function() {
			e.preventDefault();
			$.post("/malant/moveminfo", { data: ""})
		});
	});
</script>
</head>
<body>
	<div class="sidebar">
		<div class="sidebar-header">
			<span class="sidebar-title"><a href="/malant">
				<img src="/malant/resources/common/images/main_tilte.gif" alt="식물 검색" />
			</a></span>
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
				<li><a href="/malant/arbriefinfo">전국 식물원</a></li>
				<li><a href="/malant/smplist">스토어</a></li>
				<li><a href="/malant/ntitlelist">공지/이벤트</a></li>
			</ul>
		</section>
		<!-- 로그인 영역 -->
		<% if (loginMember == null) { // 로그인하지 않았을 때 %>
			<div class="login-section" id="gologin">
				로그인 하러 가기
			</div>
		<% } else { %>
			<div class="login-section">
				<div class="login-section-top">
					<%= loginMember.getNickname() %>님
				</div>
				<div class="login-section-bottom">
					<a href="/malant/moveminfo?userid=<%= loginMember.getUserId() %>">마이페이지</a> &nbsp;&nbsp; 
					<a href="/malant/logout">로그아웃</a>
				</div>
			</div>
		<% } %>
	</div>
</body>
</html>
