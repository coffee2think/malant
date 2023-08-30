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
        url: "/malant/btoplike",
        type: "get",
        dataType: "json",
        success: function(data) {
            console.log("success: " + JSON.stringify(data));

            var likeBoards = data.list;

            // Clear existing content
            var likeBoard = $(".boardLike");
            likeBoard.empty();

            for (var i = 0; i < likeBoards.length; i++) {
                var board = likeBoards[i];
                var boardLink = $("a").attr("href", "#"); // Replace "#" with actual link
                var boardImage = $("img").addClass("board-image").attr("src", board.bphoto).attr("alt", "Board Image");
                
                var boardInfo = $("p").text(board.bnick + ", " + board.btitle + ", " + board.blike);
                
                boardLink.append(boardImage);
                likeBoard.append(boardLink);
                likeBoard.append(boardInfo);
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
		<div class="boardLike"></div>
	</div>
	<p id="p1"></p>
</body>
</html>


