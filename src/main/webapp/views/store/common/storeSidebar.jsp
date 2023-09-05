<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="store.main.model.vo.MainContent, java.util.ArrayList,member.model.vo.Member"%>
<%
	ArrayList<MainContent> plistf = (ArrayList<MainContent>) request.getAttribute("plistf");
	Member loginMember = (Member) session.getAttribute("loginMember");
	Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/malant/resources/store/css/storeSidebar.css" />
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>

</head>
<body>
	<div class="sidebar">
		<div class="sidebar-header">
			<span class="sidebar-title"> <span class="back-to-main"><a
					href="/malant/index.jsp"><img
						src="/malant/resources/store/images/gotomain.gif"></a></span> <a
				href="/malant/smplist"> <img
					src="/malant/resources/store/images/store_tilte.gif" alt="스토어메인" /></a></span>
		</div>
		<section>
			<ul id="new_categories">
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=식물';">
				<li><a>식&nbsp;&nbsp;&nbsp;물</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=화분';">
				<li><a>화&nbsp;&nbsp;&nbsp;분</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=자갈/모래/흙';">
				<li><a>자갈/모래/흙</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=영양제/비료';">
				<li><a>영양제/비료</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=식물조명';">
				<li><a>식물조명</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plistf?option1=기타';">
				<li><a>기&nbsp;&nbsp;&nbsp;타</a></li>
				</div>
			</ul>
		</section>
		<!-- 로그인 영역 -->
		<% if (loginMember == null) { // 로그인하지 않았을 때 %>
			<div class="login-section" onclick="javascript: location.href='/malant/login?loc=store'">
				로그인 하러 가기
			</div>
		<% } else if(isAdmin) { // 관리자인 경우 %>
			<div class="login-section">
				<div class="login-section-top">
					<%= loginMember.getNickname() %>님
				</div>
				<div class="login-section-bottom">
					<a href="/malant/moveminfo?userid=<%= loginMember.getUserId() %>">관리 페이지</a> &nbsp;&nbsp; 
					<a href="/malant/logout?loc=store">로그아웃</a>
				</div>
			</div>
		<% } else { // 회원인 경우 %>
			<div class="login-section">
				<div class="login-section-top">
					<%= loginMember.getNickname() %>님
				</div>
		        <div style="height:50px;">
		          <a href="/malant/sblist?userNo=<%= loginMember.getUserNo() %>">장바구닝닝</a>
		          <a href="/malant/olist?userNo=<%= loginMember.getUserNo() %>">주문리스틍</a>
		        </div>
				<div class="login-section-bottom">
					<a href="/malant/qlist">관리페이지</a> &nbsp;&nbsp; 
					<a href="/malant/logout?loc=store">로그아웃</a>
				</div>
			</div>
		<% } %>
	</div>
</body>
</html>
