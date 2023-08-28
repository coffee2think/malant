<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malant</title>
<style type="text/css">
	.input-container {
		width: 500px;
		height: 600px;
		border: 1px solid red;
		margin: 0 auto;
	}
	
	.inputform {
		width: 450px;
		height: 30px;
		margin: 5px auto;
	}
	
	.checkbox-container {
		width: 400px;
		height: 70px;
		margin: 0 auto;
		border: 1px solid red;
	}
	
	.submit-btn_show {
		width: 450px;
		height: 40px;
		margin: auto;
		border: 1px solid red;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	.submit-btn_hide {
		width: 450px;
		height: 40px;
		margin: auto;
		
	}
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<div class="form-title">판매회원 가입</div>
	<div class="input-container">
		<form action="/malant/menroll" method="post">
			<input type="hidden" name="signtype" value="seller">
			<div class="input-id">
				<input type="text" class="inputform" name="id" size="20" placeholder="아이디"><br>
				<div class="input-guide-id"></div>
			</div>
			<div class="input-pwd">
				<input type="password" class="inputform" name="pwd" placeholder="비밀번호(영문+숫자+특수문자)"><br>
				<div class="input-guide-pwd"></div>
			</div>
			<div class="input-pwd2">
				<input type="password" class="inputform" name="pwd2" placeholder="비밀번호 확인"><br>
				<div class="input-guide-pwd2"></div>
			</div>
			<div class="input-name">
				<input type="text" class="inputform" name="name" size="20" placeholder="이름"><br>
				<div class="input-guide-name"></div>
			</div>
			<div class="input-email">
				<input type="email" class="inputform" name="email" placeholder="이메일"><br>
				<div class="input-guide-email"></div>
			</div>
			<div class="input-phone">
				<input type="tel" class="inputform" name="phone" placeholder="핸드폰번호">
				<div>인증요청</div><br>
				<div class="input-pwd2-guide"></div>
			</div>
			<hr>
			<div style="position: relative; left: 25px;"><input type="checkbox">약관 모두 동의 체크박스</div>
			<div class="checkbox-container">
				<div><input type="checkbox">판매 이용약관</div>
				<div><input type="checkbox">전자금융거래이용약관</div>
				<div><input type="checkbox">판매자 개인정보 수집 및 이용 동의</div>
			</div>
			<div class="submit-btn_show">
				동의하고 가입하기
			</div>
			<input type="submit" class="submit-btn_hide" value="동의하고 가입하기">
		</form>
	</div>
</body>
</html>