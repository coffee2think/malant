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
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	function loginOk() {
		if (confirm("로그인 하시겠습니까?")) {
			window.location.href = "/malant/views/board/boardDetailList.jsp";
		} else {
			window.location.href = "/malant/views/index.jsp";
		}
	}
	function goComment (){
		$.ajax({
			url : "/malant/cminsert",
			type:"post",
			data: {}
		});
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

	function likeCountDetail(boardNo) {
		$.ajax({
			url : "/malant/bbtn",
			type : "get",
			dataType : "text",
			data : {
				
				'boardNo' : boardNo
			},
			success : function(data) {
				console.log("값이 들어왔다" + data);
				$("#blike-" + boardNo).text(
						parseInt($("#blike-" + boardNo).text()) + 1);
			}
		});
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

.like-button {
	background-color: #3498db; /* 버튼 배경색 */
	color: #fff; /* 버튼 텍스트 색상 */
	border: none; /* 테두리 없음 */
	padding: 10px 20px; /* 내부 여백 설정 */
	cursor: pointer; /* 마우스 커서를 포인터로 변경하여 클릭 가능한 상태 표시 */
	border-radius: 5px; /* 둥근 모서리 설정 */
	font-size: 16px; /* 텍스트 크기 */
	transition: background-color 0.3s; /* 배경색 변경에 트랜지션 효과 추가 */
}

/* 좋아요 버튼 호버 상태의 스타일 (마우스를 버튼 위로 올릴 때) */
.like-button:hover {
	background-color: #2980b9; /* 호버 상태의 배경색 변경 */
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
			<h1>
				제목 :
				<%=board.getBoardTitle()%>
			</h1>
			<h3>
				닉네임 :
				<%=board.getNickname()%>
			</h3>
			<h3>
				좋아요 수 :
				<%=board.getBoardLike()%>
			</h3>
			<button class="like-button"
				onclick='likeCountDetail(<%=board.getBoardNo()%>);'></button>
			<h3>
				게시글 날짜 :
				<%=board.getBoardDate()%>
			</h3>
			<br>
			<div>
				<input type="text" placeholder="댓글을 입력하세요">
				<input type="submit">
			</div>
			<div
				style="board: 1px solid green; whidth 300px; height: 400px; overflow-y: scroll">
				<%=board.getBoardContent()%>
				<hr>
			</div>
		</div>
	</div>
	<div class="modal-content">
		<span class="close" onclick="closeCommentModal();">&times;</span>
		<h2>댓글 작성</h2>
	</div>

</body>
</html>