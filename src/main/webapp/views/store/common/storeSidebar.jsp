<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="store.product.model.vo.ProductDetail, java.util.ArrayList"%>
<%
	ArrayList<ProductDetail> pdetail = (ArrayList<ProductDetail>) request.getAttribute("list");
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
				href="/malant/views/store/storeMain.jsp"> <img
					src="/malant/resources/store/images/store_tilte.gif" alt="스토어메인" /></a></span>
		</div>
		<section>
			<ul id="new_categories">
				<div id = "plant-button" onclick="javascript:location.href='/malant/plist?categoryid=plant';">
				<li><a>식&nbsp;&nbsp;&nbsp;물</a></li>
				</div>
				<li><a>화&nbsp;&nbsp;&nbsp;분</a></li>
				<li><a>자갈/모래/흙</a></li>
				<li><a>영양제/비료</a></li>
				<li><a>식물조명</a></li>
				<li><a>기&nbsp;&nbsp;&nbsp;타</a></li>
			</ul>
		</section>
		<!-- 로그인 영역 -->
		<div class="login-section">
			<hr solid color="#ddd" />
			<span id="logintext"><h4>로그인</h4></span> <input type="text"
				placeholder="아이디" /> <input type="password" placeholder="비밀번호" /><br />
			<button class="login-button">로그인</button>
		</div>
		<!-- 회원가입/아이디/비밀번호 찾기 영역 -->
		<div class="account-section">
			<a href="#" class="account-link">회원가입</a><span class="login-divide">|</span><br />
			<a href="#" class="account-link">아이디찾기</a><span class="login-divide">|</span><br />
			<a href="#" class="account-link">비밀번호찾기</a><br />
		</div>
	</div>
</body>
</html>
