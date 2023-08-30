<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malant</title>
<style type="text/css">
	table th { background-color: lightgreen; }
	table#outer { border: 2px solid navy; }
	.profile {
		visibility: hidden;
	}
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	function uploadProfile() {
		$('.profile').click();
	}
</script>
</head>
<body>
	<h1>개인회원 가입 페이지</h1>
	<br>
	<form action="/malant/menroll" method="post">
		<input type="file" name="profile" class="profile" accept="image/*">
		<input type="hidden" name="signtype" value="common">
		<table id="outer" align="center" width="600" cellspacing="5" cellpadding="0">
			<tr><th colspan="3">회원가입 (* 필수항목)</th></tr>
			<tr>
				<th width="150">아이디*</th>
				<td>
					<input type="text" name="userid" id="userid" placeholder="아이디" required> 
					<input type="button" value="중복체크" onclick="return dupIdCheck();"> <br>
				</td>
				<!-- 업로드한 프로필 사진이 보여질 영역 -->
				<td rowspan="4" width="150" height="200" bgcolor="lightgreen" class="profile-area">프로필 사진 영역</td>
			</tr>
			<tr>
				<th>비밀번호*</th>
				<td><input type="password" name="userpwd" id="userpwd" placeholder="비밀번호" required></td>
			</tr>
			<tr>
				<th>비밀번호확인*</th>
				<td><input type="password" id="userpwd2" placeholder="비밀번호 확인" required></td>
			</tr>
			<tr>
				<th>닉네임*</th>
				<td><input type="text" name="nickname" placeholder="닉네임" required></td>
			</tr>
			<tr>
				<th>이메일*</th>
				<td>
					<input type="email" id="email" name="email" placeholder="이메일" required> 
					<input type="button" value="인증 요청" onclick="return checkEmail();">
				</td>
				<!-- 프로필 사진 첨부 버튼 -->
				<td><input type="button" value="사진 추가" onclick="return uploadProfile();"></td>
			</tr>
			<tr>
				<th>이메일 인증*</th>
				<td>
					<input type="number" class="econfirm" name="inputtoken" placeholder="인증번호" disabled> 
					<input type="button" class="econfirm" value="인증" disabled>
				</td>
			</tr>
			<tr>
				<th>이메일 수신 여부</th>
				<td colspan="2">
					<input type="checkbox" name="alarm"> 식물 관리 알림<br>
					<input type="checkbox" name="notice"> 이벤트 및 마케팅 정보
				</td>
			</tr>
			<tr>
				<th colspan="3">
					<input type="submit" value="가입하기"> &nbsp;
					<input type="button" value="이전페이지로" onclick="javascript: history.go(-1);"> &nbsp;
					<input type="button" value="메인페이지로" onclick="javascript: location.href='/malant/index.jsp';">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>