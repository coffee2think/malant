<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	String preReferer = (String) request.getAttribute("referer");
	String mtype = (String) request.getAttribute("mtype");
	String loc = (String) request.getAttribute("loc");
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Malant</title>
	<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
	<style>
		@import url("https://fonts.googleapis.com/css?family=Open+Sans:300,400|Lora");

		body {
			background: #CBC0D3;
		}

		/* div box styling */
		.container {
			margin: auto;
			width: 650px;
			height: 550px;
			position: relative;
		}

		.welcome {
			background: #f6f6f6;
			width: 650px;
			height: 415px;
			position: absolute;
			top: 25%;
			border-radius: 5px;
			box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1);
		}

		.pinkbox {
			position: absolute;
			top: -10%;
			left: 5%;
			background: #EAC7CC;
			width: 320px;
			height: 500px;
			border-radius: 5px;
			box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
			transition: all 0.5s ease-in-out;
			z-index: 2;
			display: flex;
			justify-content: center;
			align-items: center;
		}

		.nodisplay {
			display: none;
			transition: all 0.5s ease;
		}

		.leftbox,
		.rightbox {
			position: absolute;
			width: 50%;
			transition: 1s all ease;
		}

		.leftbox {
			left: -2%;
		}

		.rightbox {
			right: -2%;
		}

		/* font & button styling */
		h1 {
			font-family: "Open Sans", sans-serif;
			text-align: center;
			margin-top: 95px;
			text-transform: uppercase;
			color: #f6f6f6;
			font-size: 2em;
			letter-spacing: 8px;
		}

		h1#signup-box {
			font-family: "Open Sans", sans-serif;
			text-align: center;
			margin-top: 60px;
			text-transform: uppercase;
			color: #f6f6f6;
			font-size: 2em;
			letter-spacing: 8px;
		}

		.title {
			font-family: "Lora", serif;
			color: #8E9AAF;
			font-size: 1.8em;
			line-height: 1.1em;
			letter-spacing: 3px;
			text-align: center;
			font-weight: 300;
			margin-top: 20%;
		}

		.desc {
			margin-top: -8px;
		}

		.account {
			margin-top: 45%;
			font-size: 10px;
		}

		p {
			font-family: "Open Sans", sans-serif;
			font-size: 0.7em;
			letter-spacing: 2px;
			color: #8E9AAF;
			text-align: center;
		}

		span {
			color: #EAC7CC;
		}

		.flower {
			position: absolute;
			width: 120px;
			height: 120px;
			top: 46%;
			left: 29%;
			opacity: 0.7;
		}

		.smaller {
			width: 90px;
			height: 100px;
			top: 48%;
			left: 38%;
			opacity: 0.9;
		}

		button {
			padding: 12px;
			font-family: "Open Sans", sans-serif;
			text-transform: uppercase;
			letter-spacing: 3px;
			font-size: 11px;
			border-radius: 10px;
			margin: auto;
			outline: none;
			display: block;
		}

		button:hover {
			background: #EAC7CC;
			color: #f6f6f6;
			transition: background-color 1s ease-out;
		}

		.button {
			margin-top: 3%;
			background: #f6f6f6;
			color: #ce7d88;
			border: solid 1px #EAC7CC;
		}

		/* form styling */
		form {
			display: flex;
			align-items: center;
			flex-direction: column;
			padding-top: 7px;
		}

		.more-padding {
			padding-top: 35px;
		}

		.more-padding input {
			padding: 12px;
		}

		.more-padding .submit {
			margin-top: 45px;
		}

		.submit {
			margin-top: 25px;
			padding: 12px;
			border-color: #ce7d88;
		}

		.submit:hover {
			background: #CBC0D3;
			border-color: #bfb1c9;
		}

		input {
			background: #EAC7CC;
			width: 65%;
			color: #ce7d88;
			border: none;
			border-bottom: 1px solid rgba(246, 246, 246, 0.5);
			padding: 9px;
			margin: 7px;
		}

		input::placeholder {
			color: #f6f6f6;
			letter-spacing: 2px;
			font-size: 1.3em;
			font-weight: 100;
		}

		input:focus {
			color: #ce7d88;
			outline: none;
			border-bottom: 1.2px solid rgba(206, 125, 136, 0.7);
			font-size: 1em;
			transition: 0.8s all ease;
		}

		input:focus::placeholder {
			opacity: 0;
		}

		label {
			font-family: "Open Sans", sans-serif;
			color: #ce7d88;
			font-size: 0.8em;
			letter-spacing: 1px;
		}

		.checkbox {
			display: inline;
			white-space: nowrap;
			position: relative;
			left: -62px;
			top: 5px;
		}

		input[type=checkbox] {
			width: 7px;
			background: #ce7d88;
		}

		.checkbox input[type=checkbox]:checked+label {
			color: #ce7d88;
			transition: 0.5s all ease;
		}

		/*# sourceMappingURL=loginPage.css.map */
		
		.all-container {
			display: flex;
			
		}
	</style>
	<script>
		/* 유효성 검사 */
		function validate() {
			var id = $('#userid');
			var pwd = $('#pwd');
			var pwd2 = $('#pwd2');
			var email = $('#email');
			var nickname = $('#nickname');
			
			var id_rgx = /^[A-Za-z]{1}[A-Za-z0-9]{5,11}$/;
			var pwd_rgx = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$/;

			/* 아이디 유효성 검사 */
			var id_len = id.val().length;
			if(id_len < 6 || id_len > 12) {
				alert("아이디는 6글자 이상이여야합니다.");
				id.select();
				return false;
			}
			if(!id_rgx.test(id.val())) {
				alert("아이디는 영문과 숫자만을 포함해야합니다.");
				id.select();
				return false;
			}

			/* 닉네임 유효성 검사 */
			var name_len = nickname.val().length;
			if(name_len < 2 || name_len > 8) {
				alert("닉네임은 2글자 이상이여야 합니다.");
				nickname.select();
				return false;
			}

			/* 비밀번호 유효성 검사 */
			var pwd_len = pwd.val().length;

			console.log("pwd : " + pwd.val() + ", pwd2 : " + pwd2.val());
			console.log("pwd_len : " + pwd.val().length + ", pwd2_len : " + pwd2.val().length);
			if(pwd.val() != pwd2.val()) {
				alert("비밀번호가 일치하지 않습니다.");
				pwd2.select();
				return false;
			} else if(!pwd_rgx.test(pwd.val())) {
				alert("비밀번호는 영문/숫자/특수문자를 모두 포함하고, 8글자 이상이여야 합니다.");
				pwd.select();
				return false;
			}

			if(!dupCheck()) {
				return false;
			}

			return true;
		}

		function dupCheck() {
			$.ajax({
				url: '/malant/checkdup',
				type: 'post',
				data: {
					userid: $('#userid').val(),
					email: $('#email').val()
				},
				dataType: "json",
				success: function(data) {
					console.log("date : " + data + ", datatype : " + typeof(data));
					if(data.dupid != "ok") {
						alert("이미 사용중인 아이디입니다.");
						return false;
					} else if(data.dupemail != "ok") {
						alert("이미 사용중인 이메일입니다.");
						return false;
					}
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
				}
			});

			return true;
		}
	</script>
</head>

<body>
<div class="all-container">
	<div class="sidebar">
		<% if(loc.equals("common")) { %>
			<%@ include file="../common/sidebar.jsp" %>
		<% } else { %>
			<%@ include file="../store/common/storeSidebar.jsp" %>
		<% } %>
	</div>
	<div class="container">
		<div class="welcome">
			<div class="pinkbox">
				<div class="signup nodisplay">
					<h1 id="signup-box">회원가입</h1>
					<form action="/malant/menroll" method="post" autocomplete="off" onsubmit="return validate();">
						<input type="hidden" name="signtype" value="common">
						<input type="text" id="userid" name="userid" maxlength="12" placeholder="아이디" required>
						<input type="email" id="email" name="email" placeholder="이메일" required>
						<input type="text" id="nickname" name="nickname" maxlength="8" placeholder="닉네임" required>
						<input type="password" id="pwd" name="userpwd" maxlength="25" placeholder="비밀번호" required>
						<input type="password" id="pwd2" maxlength="25" placeholder="비밀번호 확인" required>
						<button class="button submit">가입하기</button>
					</form>
				</div>
				<div class="signin">
					<h1>Malant</h1>
					<form action="/malant/logincheck" method="post" class="more-padding" autocomplete="off">
						<input type="hidden" name="preReferer" value="<%= preReferer %>">
						<input type="text" name="userid" placeholder="아이디" required>
						<input type="password" name="userpwd" placeholder="패스워드" required>
						<button class="button submit">로그인</button>
					</form>
				</div>
			</div>
			<div class="leftbox">
				<h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
				<p class="desc">pick your perfect <span>bouquet</span></p>
				<img class="flower smaller" src="https://image.ibb.co/d5X6pn/1357d638624297b.jpg"
					alt="1357d638624297b" border="0">
				<p class="account">have an account?</p>
				<button class="button" id="signin">로그인</button>
			</div>
			<div class="rightbox">
				<h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
				<p class="desc"> pick your perfect <span>bouquet</span></p>
				<img class="flower" src="https://preview.ibb.co/jvu2Un/0057c1c1bab51a0.jpg" />
				<p class="account">don't have an account?</p>
				<% if(mtype.equals("common")) { %>
				<button class="button" id="signup">회원가입</button>
				<% } else { %>
				<button class="button" id="signup" onclick="javascript: location.href='/malant/views/member/enrollSeller.jsp'">회원가입</button>
				<% } %>
			</div>
		</div>
	</div>
	<script>
		$('#signup').click(function () {
			$('.pinkbox').css('transform', 'translateX(80%)');
			$('.signin').addClass('nodisplay');
			$('.signup').removeClass('nodisplay');
		});

		$('#signin').click(function () {
			$('.pinkbox').css('transform', 'translateX(0%)');
			$('.signup').addClass('nodisplay');
			$('.signin').removeClass('nodisplay');
		});
	</script>
</div>
</body>

</html>