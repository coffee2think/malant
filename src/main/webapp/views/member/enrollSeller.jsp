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
<<<<<<< HEAD
		height: 630px;
		border: 1px solid red;
		margin: 0 auto;
		display: flex;
		justify-content: center;
=======
		height: 600px;
		border: 1px solid red;
		margin: 0 auto;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
	}
	
	.inputform {
		width: 450px;
		height: 30px;
		margin: 5px auto;
	}
	
<<<<<<< HEAD
	.inputform-phone {
		width: 375px;
		height: 30px;
		margin: 5px auto;
	}
	
=======
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
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
<<<<<<< HEAD
		display: none;
	}
	
	.form-title {
		border: 1px solid red;
		width: 450px;
		height: 40px;
		text-align: center;
		margin: auto;
		margin-top: 15px;
	}
	
	.cert-request-btn {
		display: inline;
		border: 1px solid red;
=======
		
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
	}
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<<<<<<< HEAD
<script>
	function clickSubmitBtn() {
		$('.submit-btn_hide').click();
	}
</script>
</head>
<body>
	
	<div class="input-container">
		
		<form action="/malant/senroll" method="post">
			<input type="hidden" name="signtype" value="seller">
			<div class="form-title">판매회원 가입</div><br>
			<div class="input-name">
				<input type="text" class="inputform" name="businessno" size="20" placeholder="사업자번호"><br>
				<div class="input-guide-name"></div>
			</div>
			
			<!-- 사업자번호 확인 API 추가 요망 -->
			<div><input type="button" value="사업자번호 인증 요청"></div>
			<div class="input-name">
				<input type="text" class="inputform" name="storename" size="20" placeholder="상호명"><br>
				<div class="input-guide-name"></div>
			</div>
			
			<!-- 주소검색 API 추가 요망 -->
			<div class="input-name">
				<input type="text" class="inputform" name="address" size="20" placeholder="사업자 주소"><br>
				<div class="input-guide-address"></div>
			</div>
			
			<div class="input-id">
				<input type="text" class="inputform" name="userid" size="20" placeholder="아이디"><br>
				<div class="input-guide-id"></div>
			</div>
			<div><input type="button" value="아이디 중복 검사"></div>
			<div class="input-pwd">
				<input type="password" class="inputform" name="userpwd" placeholder="비밀번호(영문+숫자+특수문자)"><br>
				<div class="input-guide-pwd"></div>
			</div>
			<div class="input-pwd2">
				<input type="password" class="inputform" name="userpwd2" placeholder="비밀번호 확인"><br>
				<div class="input-guide-pwd2"></div>
			</div>
=======
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
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
			<div class="input-email">
				<input type="email" class="inputform" name="email" placeholder="이메일"><br>
				<div class="input-guide-email"></div>
			</div>
<<<<<<< HEAD
			<div class="input-contact">
				<input type="tel" class="inputform" name="contact" placeholder="휴대폰 번호"><br>
				<div class="input-guide-contact"></div>
=======
			<div class="input-phone">
				<input type="tel" class="inputform" name="phone" placeholder="핸드폰번호">
				<div>인증요청</div><br>
				<div class="input-pwd2-guide"></div>
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
			</div>
			<hr>
			<div style="position: relative; left: 25px;"><input type="checkbox">약관 모두 동의 체크박스</div>
			<div class="checkbox-container">
<<<<<<< HEAD
				<!-- 필수 이용약관에 모두 동의해야 가입 진행되도록 유효성 검사 -->
				<div><input type="checkbox" name="terms_sell">판매 이용약관</div>
				<div><input type="checkbox" name="terms_financial_transaction">전자금융거래이용약관</div>
				<div><input type="checkbox" name="agree_personal_info">판매자 개인정보 수집 및 이용 동의</div>
			</div>
			<div class="submit-btn_show" onclick="clickSubmitBtn();">동의하고 가입하기</div>
=======
				<div><input type="checkbox">판매 이용약관</div>
				<div><input type="checkbox">전자금융거래이용약관</div>
				<div><input type="checkbox">판매자 개인정보 수집 및 이용 동의</div>
			</div>
			<div class="submit-btn_show">
				동의하고 가입하기
			</div>
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
			<input type="submit" class="submit-btn_hide" value="동의하고 가입하기">
		</form>
	</div>
</body>
</html>