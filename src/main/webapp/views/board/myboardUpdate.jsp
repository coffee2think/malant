<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="community.model.vo.Board, java.util.ArrayList"%>
<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
Board board = (Board) request.getAttribute("bno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate</title>
</head>
<body>
	<div class="myboard-update">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<div>
			<form action="/malant/binsert" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
				<input type="hidden" name="bphoto" value="<%=board.getBoardPhoto()%>">
			<div>
				제목 : <input type="text" name="title" size="50" value="<%= board.getBoardTitle() %>">
			</div>
			<div>
				작성자 : <input type="text" name="writer" readonly value="<%= board.getNickname() %>">
			</div>
			<div>
				내용 : <input type="text" name="content"  value="<%= board.getBoardContent() %>">
			</div>
			<div>
			 해쉬태그 :
		    <% if (list != null && !list.isEmpty()) {
		        for (int i = 0; i < list.size(); i++) { %>
		            <input type="text" name="hashtag" value="<%= (board != null) ? board.getHashtagContent() : "" %>">
		    <% } } %>
			</div>
			<div>
				<% if(board.getBoardPhoto() != null){ %>
					<%= board.getBoardPhoto() %>
					<input type="checkbox" name="deleteFlag" value="yes"> 파일삭제 <br>
					변경 : <input type="file" name="upfile">
				<% }else{ %>
					첨부된 파일 없음 <br>
					추가 : <input type="file" name="upfile">
				<% } %>
			</div>
			</form>
		</div>
	</div>
</body>
</html>