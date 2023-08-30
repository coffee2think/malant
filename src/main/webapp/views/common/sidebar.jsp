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
<script type="text/javascript">
	// 로그인 유효성 검사
	/* function validate() {
		var loginid = $('#loginid').val();
		var loginpwd = $('#loginpwd').val();
		var checkRegex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣| ]/;
		
		// 유효성 검사
		if(checkRegex.test(loginid) || checkRegex.test(loginpwd) || !(loginid.length >= 6 && loginpwd <= 12)) {
			// 잘못 입력함을 알리는 메시지창 출력
			alert("아이디 또는 비밀번호를 확인해주세요.");
			console.log('유효성 검사 오류');
			return false;
		}
		
		return true;
	} */
</script>
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
				<li><a href="">다이어리</a></li>
				<li><a href="">전국 식물원</a></li>
				<li><a href="">스토어</a></li>
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
				<a href="/malant/views/member/enrollPage.jsp" class="account-link">회원가입</a><span class="login-divide">|</span>
				<!-- 아이디/비밀번호 찾기는 새창을 띄워 진행 -->
				<a href="#" class="account-link" onclick="window.open('/malant/findAccount.jsp?find=id', '_blank', 'width=900, height=1000');">아이디찾기</a><span class="login-divide">|</span>
				<a href="#"	class="account-link" onclick="window.open('/malant/findAccount.jsp?find=pwd', '_blank', 'width=900, height=1000');">비밀번호재설정</a>
			</div>
		<% } else { %>
			<div class="profile">
				<%= loginMember.getNickname() %>님 환영합니다.<br>
				<a href="/malant/minfo?userid=<%= loginMember.getUserId() %>">마이페이지</a> &nbsp; 
				<a href="/malant/logout">로그아웃</a>
			</div>
		<% } %>
	</div>
</body>
</html>
