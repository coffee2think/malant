<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malant</title>
<link rel="stylesheet" href="/malant/resources/member/css/loginPage.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script>
	function login() {
		$('#submit-btn').click();
	}
</script>
</head>
<body>
	<div class="login-container">
		<div class="login-title">로고</div>
		<form action="/malant/login" class="login-form">
			<input type="submit" class="submit-btn" value="로그인" onsubmit="login();">
			<br>
			<div>
				<label class="radio-member" id="member-common" style="width: "><input type="radio" name="mtype" checked>개인회원</label>
				<label class="radio-member" id="member-seller"><input type="radio" name="mtype">판매회원</label>
			</div>
			<div><input type="text" class="login-box" name="userid" placeholder="아이디"></div>
			<div><input type="password" class="login-box" name="userpwd" placeholder="비밀번호"></div>
			<div class="login-btn" onclick="return login();">로그인</div>
		</form>
		<div class="login-links">
			<a href="/malant/views/member/enrollPage.jsp">회원가입</a> 
			<a href="" class="account-link" onclick="window.open('/malant/findAccount.jsp?find=id', '_blank', 'width=900, height=1000');">아이디찾기</a> 
			<a href="" class="account-link" onclick="window.open('/malant/findAccount.jsp?find=pwd', '_blank', 'width=900, height=1000');">비밀번호재설정</a>
		</div>
		<div><hr width="480"></div>
		<div class="sns-container">
			<div class="sns-box" onclick="location.href='/malant';">구글 로그인</div>
			<div class="sns-box" onclick="location.href='/malant';">카카오 로그인</div>
			<div class="sns-box" onclick="location.href='/malant';">네이버 로그인</div>
		</div>
	</div>
</body>
</html>