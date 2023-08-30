<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String findType = request.getParameter("find");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보 찾기</title>
</head>
<body>
	<div class="choice">
		<input type="radio" name="choice" value="findid"> 아이디 찾기 
		<input type="radio" name="choice" value="findpwd"> 비밀번호 재설정
	</div>
	<div class="view-choice">
		<% if(findType.equals("id") { %>
		<div>
			<form action="/malant/find">
				<input type="email" placeholer="이메일을 입력하세요." required>
				<input type="submit" onsubmit="return ">
			</form>
		</div>
		<% } else if(findType.equals("pwd")) { %>
		<div>
		
		</div>
		<% } %>
	</div>
</body>
</html>