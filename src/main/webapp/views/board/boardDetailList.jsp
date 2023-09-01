<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="board.model.vo.Board,java.util.ArrayList, board.model.vo.Comment"%>
<%
Board board = (Board) request.getAttribute("board");
ArrayList<Comment> clist = (ArrayList<Comment>) request.getAttribute("comment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>malantBoardDetail</title>

<script type="text/javascript">
	function loginOk() {
		if (confirm("로그인 하시겠습니까?")) {
			window.location.href = "/malant/views/board/boardDetailList.jsp";
		} else {
			window.location.href = "/malant/views/index.jsp";
		}
	}
	function likeCount(boardNo) {
		$.ajax({
			url : "/malant/bbtn",
			type : "get",
			dataType : "text",
			data : {
				'boardNo' : boardNo
			},
			success : function(data) {
				$("#blike-" + boardNo).text(
						parseInt($("#blike-" + boardNo).text()) + 1);
			}
		});
	}

	function goComment() {
	var modal = document.getElementById("insertModal");
	modal.style.display = "block";
	}
	
	function closeModal() {
		var modal = document.getElementById("insertModal");
		modal.style.display = "none";
	}
</script>


<style type="text/css">
.board-detail {
	display: flex;
	margin-top: 100px;
}

.board-photo {
	margin-left: 400px;
	width: 500px;
	height: 500px;
}

.board-title {
	margin-left: 100px;
}
</style>
</head>
<body>

	<div class='board-detail'>
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>

		<div>
			<img class='board-photo' src="<%=board.getBoardPhoto()%>">
		</div>
		<div class='board-title'>
			<h1> 제목 : <%=board.getBoardTitle()%> </h1>
			<br>
			<div>
				<button onclick="goComment();">댓글 달기</button>
			
			</div>
				<div style="board: 1px solid green; whidth 300px; height: 400px; overflow-y: scroll">
					<%=board.getBoardContent()%>
					<hr>
				</div>
		</div>
	</div>
	<!-- 모달창 &times; 는 모달창에서 주로 이용하는 X 버튼!! -->
	<div id="insertModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal();">&times;</span>
			<h2>댓글 작성</h2>
			<form action="/malant/cminsert" method="post">
				<label for="commentContent">댓글 내용 : </label><br>
				<textarea name="commentContent" rows="4" cols="50"></textarea>
				<input type="submit" value="댓글 작성">
			</form>
		</div>
	</div>
</body>
</html>