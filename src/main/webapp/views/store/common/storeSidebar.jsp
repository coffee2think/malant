<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="store.product.model.vo.ProductDetail, java.util.ArrayList, member.model.vo.Member"%>
<%
	ArrayList<ProductDetail> pdetail = (ArrayList<ProductDetail>) request.getAttribute("list");
	Member loginMember = (Member) session.getAttribute("loginMember");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/malant/resources/store/css/storeSidebar.css" />
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>

<script>
  window.onload = function() {
    const sidebar = document.querySelector('.sidebar');

    window.addEventListener('scroll', function() {
    	const topOffset = 0;
        const scrollTop = window.scrollY;
        const contentTop = document.querySelector('.content').offsetTop;
        const sidebarHeight = sidebar.clientHeight;
        const contentHeight = document.querySelector('.content').clientHeight;
        const maxTop = contentTop + contentHeight - sidebarHeight;
        const newTop = Math.max(topOffset, Math.min(maxTop, scrollTop));
        sidebar.style.top = newTop + 'px';
    });
  };
</script>

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
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=plant';">
				<li><a>식&nbsp;&nbsp;&nbsp;물</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=pot';">
				<li><a>화&nbsp;&nbsp;&nbsp;분</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=soil';">
				<li><a>자갈/모래/흙</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=nutrients';">
				<li><a>영양제/비료</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=light';">
				<li><a>식물조명</a></li>
				</div>
				<div class = "menu-button" onclick="javascript:location.href='/malant/plist?categoryid=etc';">
				<li><a>기&nbsp;&nbsp;&nbsp;타</a></li>
				</div>
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
