<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Malant - 회원가입 페이지</title>
<link rel="stylesheet" href="/malant/resources/common/css/sidebar.css" />
<style>
	.select-type {
		width: 500px;
		min-height: 600px;
		border: 1px solid green;
		margin: 0 auto;
	}
	
<<<<<<< HEAD
	.select-btn {
		width: 200px;
		height: 50px;
		border: 1px solid red;
		margin: 10px auto;
		display: flex;
		align-items: center;
		justify-content : center;
=======
	.radio-section {
		display: flex;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
	}
</style>

<script type="text/javascript" src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	function selectMember(obj) {
		var name = obj.name;
		$("input[name='" + nm + "']").attr("checked", false);
		$("#" + obj.id).attr("checked", true);
	}
</script>
</head>
<body>
	<center><h1>회원 유형 선택</h1></center>
	<div class="select-type">
<<<<<<< HEAD
		<div class="select-btn">
			<a href="/malant/views/member/enrollMember.jsp">개인 회원가입</a>
		</div> 
		<div class="select-btn">
			<a href="/malant/views/member/enrollSeller.jsp">판매자 회원가입</a>
		</div>
=======
		<div class="radio-section">
			<div class="personal">
				<a href="/malant/views/member/enrollMember.jsp">개인 회원가입</a> &nbsp; 
			</div>
			<div class="personal">
				<a href="/malant/views/member/enrollSeller.jsp">판매자 회원가입</a>
			</div><br>
		</div>
		
		<input type="button" value="다음" onclick="return selectType();"></button>
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
	</div>
</body>
</html>