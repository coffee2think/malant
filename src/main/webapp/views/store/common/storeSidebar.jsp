<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="store.main.model.vo.MainContent, java.util.ArrayList, member.model.vo.Member"%>
<%
	ArrayList<MainContent> plistf = (ArrayList<MainContent>) request.getAttribute("plistf");
	Member loginMember = (Member) session.getAttribute("loginMember");
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
		<% if (loginMember == null ) { // 로그인하지 않았을 때 %>
			<div>
				<div class="login-section">
					<div class="login-section-top">로그인하러 가기</div>
					<div class="login-section-bottom">
						<div class="login-section-left" id="member-common" onclick="location.href='/malant/login?mtype=common&loc=store';">
							일반회원
						</div>
						<div class="login-section-right" onclick="location.href='/malant/login?mtype=seller&loc=store';">
							판매회원
						</div>
					</div>
				</div>
			</div>
		<% } else { %>
			<div class="login-section">
				<%= loginMember.getNickname() %>님 환영합니다.<br>
				<div class=>
					<a href="/malant/views/member/confirmMemberBeforeInfo.jsp?userid=<%= loginMember.getUserId() %>">마이페이지</a> &nbsp;
				</div>
				<div> 
					<a href="/malant/logout">로그아웃</a>
				</div>
			</div>
		<% } %>
	</div>
</body>
</html>
