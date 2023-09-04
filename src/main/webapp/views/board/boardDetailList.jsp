<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="board.model.vo.Board,java.util.ArrayList, board.model.vo.Comment"%>
<%
Board board = (Board) request.getAttribute("board");
ArrayList<Comment> clist = (ArrayList<Comment>) request.getAttribute("clist");
ArrayList<String> cdate = (ArrayList<String>) request.getAttribute("cdate");
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
				<form action="/malant/cminsert">
					<input type="hidden" name="userno"
						value="<%=loginMember.getUserNo()%>"> <input
						type="hidden" name="bno" value="<%=board.getBoardNo()%>">
					<input type="hidden" name="profile"
						value="<%=loginMember.getProfileImg()%>"> <input
						type="hidden" name="nickname"
						value="<%=loginMember.getNickname()%>"> <input
						type="text" name="comment" placeholder="댓글을 입력하세요"> <input
						type="submit">
				</form>
			</div>

			<div
				style="border: 1px solid green; width: 1000px; height: 400px; overflow-y: scroll">
				<%
				for (int i = 0; i < clist.size(); i++) {
				%>
				<%=clist.get(i).getCommentContent()%>
				<%=clist.get(i).getNickname()%>
				<%=cdate.get(i)%>
				<%
				if (loginMember.getUserNo().equals(clist.get(i).getUserNo())) {
				%>
				<!-- loginMember 랑 그냥 비교하면 객체와 String 을 비교하는것
 					logimMember 의 어떤 값이랑 비교할지 확인했어야 했음!! -->
				<!-- 수정 -->
				<form action='/malant/cmupdate'>
					<input type="hidden" name="cno" value="<%= clist.get(i).getCommentNo() %>">
					<input type="hidden" name="bno" value="<%= board.getBoardNo() %>">
					<input type="text" name="content" value="<%= clist.get(i).getCommentContent() %>">
					<!-- <textarea name="updateComment" placeholder="댓글 수정 내용 입력"></textarea> -->
					<input type="submit" value="수정">
				</form>
				<!-- 삭제 -->
				<form action='/malant/cmdelete'>
					<input type="hidden" name="cno" value="<%= clist.get(i).getCommentNo() %>">
					<input type="hidden" name="bno" value="<%= board.getBoardNo() %>">
					<input type="submit" value="삭제">
				</form>
				<%
				}
				%>
				<br>
				<hr>
				<%
				}
				%>

			</div>

		</div>
	</div>
</body>
</html>