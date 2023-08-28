<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="board.model.vo.Board, java.util.ArrayList"%>
<!DOCTYPE html>
<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Malant</title>
<link rel="stylesheet" type="text/css"
	href="/malant/resources/board/css/boardcontents.css">
<script type="text/javascript"
	src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script>
	$(function() {
		$.ajax({
			url : "/malant/btoplike",
			type : "get",
			dataType : "json",
			success : function(data) {
				console.log("succes : "+data);
				var likeBoards = data.list;

				var likeBoard = $(".boardLike");
				likeBoard.empty();

				for (var i = 0; i < likeBoards.length; i++) {
					var boardlike3 = likeBoards[i];
					var boardLink = $("<a>").attr("href", boardlike3);
					var boardImage = $("<img>").addClass("board-image").attr(
							"src", boardlike3.btitle).attr("alt",
							"Board Image");

					boardLink.append(boardImage);
					likeBoard.append(boardLink);
				}
			}
		});
	});
</script>


</head>
<body>
	<div class="board-main">
		<div class="container">
			<%@ include file="../../views/common/sidebar.html"%>
		</div>

	</div>

</body>
</html>