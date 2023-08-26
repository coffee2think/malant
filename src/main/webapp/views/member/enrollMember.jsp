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
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
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
</script>
</head>
<body>
	<h1>일반회원 가입페이지</h1>
	<br>
	<form action="/malant/menroll" method="post" onsubmit="return validate():">
		<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
			<tr><th colspan="3">회원 정보를 입력해 주세요. (* 표시는 필수입력 항목입니다.)</th></tr>
			<tr>
				<th width="120">아이디*</th>
				<td>
					<input type="text" name="userid" id="userid" required> &nbsp;
					<input type="button" value="중복체크" onclick="return dupIdCheck();">
				</td>
				<td rowspan="3" width="100">프로필 사진 영역</td>
			</tr>
			<tr><th>*암호</th>
			<td><input type="password" name="userpwd" id="userpwd" required></td></tr>
			<tr><th>*암호확인</th>
			<td><input type="password" id="userpwd2" required></td></tr>
			<tr><th>*이름</th>
			<td><input type="text" name="username" required></td></tr>
			<tr><th>*성별</th>
			<td>
				<input type="radio" name="gender" value="M"> 남자 &nbsp;
				<input type="radio" name="gender" value="F"> 여자
			</td></tr>
			<tr><th>*나이</th>
			<td><input type="number" name="age" min="19" value="20" required></td></tr>
			<tr><th>*전화번호</th>
			<td><input type="tel" name="phone" required></td></tr>
			<tr><th>*이메일</th>
			<td><input type="email" name="email" required></td></tr>
			<tr><th>취미(연습용)</th>
			<td colspan="2">
				<table width="350">
				<tr>
					<td><input type="checkbox" name="hobby" value="game"> 게임</td>
					<td><input type="checkbox" name="hobby" value="reading"> 독서</td>
					<td><input type="checkbox" name="hobby" value="climb"> 등산</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="hobby" value="sport"> 운동</td>
					<td><input type="checkbox" name="hobby" value="music"> 음악</td>
					<td><input type="checkbox" name="hobby" value="movie"> 영화</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="hobby" value="travel"> 여행</td>
					<td><input type="checkbox" name="hobby" value="gook"> 요리</td>
					<td><input type="checkbox" name="hobby" value="etc" checked> 기타</td>
				</tr>
				</table>
			</td></tr>
			<tr><th>기타 정보(연습용)</th>
			<td colspan="2"><textarea name="etc" rows="3" cols="50"></textarea></td></tr>
			<tr><th colspan="3">
				<input type="submit" value="가입하기"> &nbsp;
				<input type="reset" value="작성취소"> &nbsp;
				<a href="/first/index.jsp">시작페이지로 이동</a>
			</th></tr>
		</table>
	</form>
	
	
</body>
</html>