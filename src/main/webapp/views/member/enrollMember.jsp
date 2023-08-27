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
	
	.row-econfirm {
		visibility: hidden;
	}
	
	
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.row-econfirm').hide();
	});
	
	// 유효성 검사
	function validate(){
		//암호와 암호확인이 일치하지 않는지 확인
		//var pwdValue = document.getElementById("userpwd").value;
		//var pwdValue2 = document.getElementById("userpwd2").value;
		//jQuery 선택자 사용으로 바꾼다면
		var pwdValue = $('#userpwd').val();
		var pwdValue2 = $('#userpwd2').val();
		
		if(pwdValue !== pwdValue2){
			alert("암호와 암호확인이 일치하지 않습니다. 다시 입력하세요.");
			document.getElementById("userpwd2").value = "";
			document.getElementById("userpwd").select();
			return false;  //전송 취소함
		}
		
		//아이디의 값 형식이 요구한 대로 작성되었는지 검사
		//암호의 값 형식이 요구한 대로 작성되었는지 검사
		//정규표현식(Regular Expression) 사용함
		
		return true;
	}
	
	// 아이디 중복 검사
	function dupIdCheck(){
		$.ajax({
			url: "/malant/checkdupid",
			type: "post",
			data: { userid: $('#userid').val() },
			success: function(data) {
				if(data == "ok") {
					alert("사용 가능한 아이디입니다.");
				} else {
					alert("이미 사용중인 아이디입니다.");
					$('#userid').select();
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
		
		return false;
	}
	
	function checkEmail() {
		$.ajax({
			url: "/malant/econfirm",
			type: "post",
			data: { email: $('#email').val() },
			success: function(data) {
				if(data == "ok") {
					alert("사용 가능한 이메일입니다.");
					$('.econfirm').disabled = false;
				} else {
					alert("이미 사용중인 이메일입니다.");
					$('#email').select();
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
		
		return false;
	}
	
	function uploadProfile() {
		$('.profile').click();
	}
</script>
</head>
<body>
	<h1>일반회원 가입페이지</h1>
	<br>
	<form action="/malant/menroll" method="post" onsubmit="return validate();">
		<input type="file" name="profile" class="profile" accept="image/*">
		<input type="hidden" name="signtype" value="common">
		<table id="outer" align="center" width="600" cellspacing="5" cellpadding="0">
			<tr><th colspan="3">회원 정보를 입력해 주세요. (* 표시는 필수입력 항목입니다.)</th></tr>
			<tr>
				<th width="150">아이디*</th>
				<td>
					<input type="text" name="userid" id="userid" placeholder="아이디" required> 
					<input type="button" value="중복체크" onclick="return dupIdCheck();"> <br>
				</td>
				<!-- 업로드한 프로필 사진이 보여질 영역 -->
				<td rowspan="4" width="150" height="200" bgcolor="red" class="profile-area">프로필 사진 영역</td>
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
				<td>
					<input type="button" value="사진 추가" onclick="return uploadProfile();">
				</td>
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