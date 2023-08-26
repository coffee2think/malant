<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malant</title>
<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	function selectType() {
		mtype = $('.mtype:checked').val();
		
		if(mtype == "member") {
			location.href = "/malant/views/member/enrollMember.jsp";
		} else if(mtype == "seller") {
			location.href = "/malant/views/member/enrollSeller.jsp";
		}
	}
</script>
</head>
<body>
	<h1>회원 가입 - 타입 선택</h1>
	
	<div id="mtype">
		<input type="radio" class="mtype" name="mtype" value="member" checked> 일반회원 &nbsp; 
		<input type="radio" class="mtype" name="mtype" value="seller"> 판매회원<br>
		<input type="button" value="다음" onclick="return selectType();"></button>
	</div>
</body>
</html>