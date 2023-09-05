<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="board.model.vo.Board, java.util.ArrayList, board.model.vo.Comment"%>
<!DOCTYPE html>
<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
Board board = (Board) request.getAttribute("board");
%>
<html>
<head>
<meta charset="UTF-8">
<title>MalantBoardMain</title>
<link rel="stylesheet" type="text/css"
	href="/malant/resources/board/css/boardcontents.css">
<style>
.board-all {
	margin: 0 auto; /* 가로 가운데 정렬 */
}

#toplist {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

/* #hashlist 내의 내용 가운데 정렬 */
#hashlist {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

.like-style, .board-item {
	margin-left: auto;
	margin-right: auto;
}

.board-date-image {
	width: 350px; /* 이미지의 너비를 조절 */
	height: 350px; /* 이미지의 높이를 조절 */
}

.bdlist {
	display: flex;
	flex-direction: column; /* 세로로 나타나도록 설정 */
	align-items: center; /* 요소를 가운데 정렬 */
	justify-content: center; /* 세로 가운데 정렬 */
}

.board-all {
	margin: 10px; /* 각 아이템 사이의 간격을 조절합니다. */
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 500px; /* 아이템의 폭을 조절합니다. */
}

.comment-area {
	margin-left: auto;
	margin-right: auto;
}

.board-wirte {
	margin-left: auto;
	margin-right: auto;
}
</style>
<script type="text/javascript"
	src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script>
$(function() {
    $.ajax({
        url: "/malant/btoplike",
        type: "get",
        dataType: "json",
        success: function(data) {
            var str = JSON.stringify(data);
            var json = JSON.parse(str);
            values = "<div class='board-like'>";
            for (var i in json.blist) {
                values += "<div class='board-item' id='bno-" + json.blist[i].bno + "'>"
                    + "<a onclick='checkLogin("+ json.blist[i].bno +");'>"
                    + "<img class='image-style' src=" + decodeURIComponent(json.blist[i].bphoto) + "></a>"
                    + "<div class='like-style' id='blike-" + json.blist[i].bno + "'>"
                    + json.blist[i].blike
                    + "</div><div>"
                    + "<button class='likeBtn-style' onclick='likeCount(" + json.blist[i].bno + ");'></button>"
                    + decodeURIComponent(json.blist[i].btitle)
                    + "<img class='title-style' src='" + decodeURIComponent(json.blist[i].bprofile) + "'>" 
                    + "</div>" 
                    + "</div>";
            }
            values += "</div>";
            $('#toplist').html(values);
        }
    });

    $.ajax({
        url : "/malant/btophash",
        type: "get",
        dataType: "json",
        success: function(data) {
            var str = JSON.stringify(data);
            var json = JSON.parse(str);
            var values = "";
            for (var i in json.hlist){
                values += "<div class='hash'>" + "#"+ decodeURIComponent(json.hlist[i].hashContent);
                values += "</div>";
            }
            $('#hashlist').html(values);
        }
    });

    $.ajax({
        url: "/malant/bdlist",
        type: "get",
        dataType: "json",
        success: function(data) {
            var str = JSON.stringify(data);
            var jsonData = JSON.parse(str);
            var values = "";
            values += "<div class='bdlist'>";
            var itemsPerColumn = Math.ceil(jsonData.dlist.length / 3); // 열당 이미지 수
            var columnIndex = 0; // 현재 열 인덱스
            for (var i in jsonData.dlist) {
                values += "<div class='board-all'>";
                values += "<div class='board-item'>";
                values += "<a onclick='checkLogin("+ jsonData.dlist[i].bno +");'>"
                values += "<img class='board-date-image' src='" + jsonData.dlist[i].bphoto + "'></a>";
                values += "</div>";
                values += "<div class='like-style' id='d-" + jsonData.dlist[i].bno + "'>";
                values += "<div>";
                values += "<button class='likeBtn-style' onclick='likeCountDate(" + jsonData.dlist[i].bno + ");'></button>";
                values += "<span id='dlike-" + jsonData.dlist[i].bno + "'>" + jsonData.dlist[i].blike + "</span>";
                values += "<img class='title-style' src='" + decodeURIComponent(jsonData.dlist[i].bprofile) + "'>";
                values += decodeURIComponent(jsonData.dlist[i].btitle);
                values += "</div>";
                values += "</div>";
                values += "<div class='comment-area'>";
                values += decodeURIComponent(jsonData.dlist[i].ccontent);
                values += "</div>";
                values += "</div>";
            }
            values += "</div>";
            $('#dlist').html(values);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
        }
    });
});

function likeCount (boardNo){  
    $.ajax({
         url: "/malant/bbtn",
         type: "get",
         dataType: "text",
         data : {
            'boardNo': boardNo
         },
         success  : function(data){
             $("#blike-" + boardNo).text(parseInt($("#blike-" + boardNo).text()) + 1);
         }
    });
}

function likeCountDate (boardNo){  
    $.ajax({
         url: "/malant/bbtn",
         type: "get",
         dataType: "text",
         data : {
            'boardNo': boardNo
         },
         success  : function(data){
             $("#dlike-" + boardNo).text(parseInt($("#dlike-" + boardNo).text()) + 1);
         }
    });
}
function readImage(input) {
    if (input.files && input.files[0]) {
       const reader = new FileReader();
       reader.onload = function(e) {
          const previewImage = document.getElementById("preview-image");
          previewImage.src = e.target.result;
       }
       reader.readAsDataURL(input.files[0]);
    }
 }

 const inputImage = document.getElementById("input-image");
 inputImage.addEventListener("change", function() {
    readImage(this);
 });

 function checkImageSelection(inputElement) {
     var previewImage = document.getElementById("preview-image");
     
     // 파일이 선택되었는지 확인
     if (inputElement.files.length === 0) {
         alert("파일을 선택하세요."); 
         previewImage.src = "/malant/resources/board/images/8.png"; 
     } else {

         var reader = new FileReader();
         reader.onload = function(e) {
             previewImage.src = e.target.result;
         };
         reader.readAsDataURL(inputElement.files[0]);
     }
 }

</script>
</head>
<body>
	<div>
		<div class="board-main">
			<div class="container">
				<%@ include file="../../views/common/sidebar.jsp"%>
			</div>
			<script type="text/javascript">
        var member = '<%=loginMember%>';
        function checkLogin(boardNo){
            if (member == 'null'){
                if (confirm("로그인 하시겠습니까?")) {
                   location.href = "/malant/login?loc=common";
                } 
            } else {
                location.href="/malant/bdetail?bno=" + boardNo;
            }
        }
        </script>
			<div class="board-wirte">
				<form action="/malant/myblist" method="post">
					<%
					if (loginMember != null) {
					%>
					<button id="myButton">내 게시글 목록</button>
					<input type="hidden" name="userno"
						value="<%=loginMember.getUserNo()%>">
					<%
					}
					%>
				</form>  
				<button id="write">게시글 쓰기</button>
				<form action="/malant/binsert" method="post"
					enctype="multipart/form-data">
					<%
					if (loginMember != null) {
					%>
					
					<input type="hidden" name="userno"
						value="<%=loginMember.getUserNo()%>">
						
						 <input type="file" id="input-image" name="input-image"  onchange="readImage(this);"> 
                       <img name="preview-image" id="preview-image"
                           src="/malant/resources/board/images/8.png"
                           style="width: 350px;">
						 <input type="text" name="title"> 
						 <input type="text" name="nickname" readonly value="<%= loginMember.getNickname() %>">
						 <input type="text" name="content">
						
					<input type="submit" value="쓰기">
					<%
					}
					%>
				</form>
			</div>
			<div id="toplist"></div>
		</div>
		<div id="hashlist"></div>
		<div id="dlist"></div>
		<div>
			<input type="submit" name="insertboard" value="게시글 쓰기">
		</div>
	</div>
</body>
</html>