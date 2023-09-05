<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.ArrayList"%>
<%
ArrayList<Board> myblist = (ArrayList<Board>) request.getAttribute("myblist");
Board board = (Board) request.getAttribute("bno");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.myboard {
	display: flex;
	flex-wrap: wrap;
	justify-content: center; /* 가로 가운데 정렬 */
	margin-left: 300px; /* body의 기본 마진 제거 */
}

.myboard-content {
	display: flex;
	align-content: center;
	flex-wrap: wrap;
}
}
</style>
<script>
function updateBoard(boardNo) {
    location.href = "/malant/views/board/myboardUpdate.jsp";
}

function deleteBoard(boardNo) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        location.href = "bdelete?bno=" + boardNo;
    }
}
</script>

<meta charset="UTF-8">
<title>myBoard</title>
</head>
<body>
	<div class="notice-main">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<div class="myBoardList">
			
			<%
			for (int i = 0; i < myblist.size(); i++) {
			%>
			<div class="myboard">
				<div class="myboard-image">
					<img src="<%=myblist.get(i).getBoardPhoto()%>">
				</div>
				<div class="myboard-content">
					제목 : <%=myblist.get(i).getBoardTitle()%><br> 
					게시글 좋아요 수 : <%=myblist.get(i).getBoardLike()%><br> 
					게시글 날짜 : <%=myblist.get(i).getBoardDate()%><br>

					<button onclick="updateBoard(<%=myblist.get(i).getBoardNo()%>)">수정</button>
					<button onclick="deleteBoard(<%=myblist.get(i).getBoardNo()%>)">삭제</button>
				</div>

			</div>
			<%
			}
			%>
		</div>
		<div>
			<%@ include file="../common/pagingView.jsp"%>
		</div>
	</div>
</body>
</html>