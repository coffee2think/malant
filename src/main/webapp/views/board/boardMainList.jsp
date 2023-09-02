<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="board.model.vo.Board, java.util.ArrayList, board.model.vo.Comment"%>
<!DOCTYPE html>
<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");

%>
<html>
<head>
<meta charset="UTF-8">
<title>MalantBoardMain</title>
<link rel="stylesheet" type="text/css"
	href="/malant/resources/board/css/boardcontents.css">
<style>
.like-style{
	margin-left: 100px;
}
.board-item {
	margin-left: 100px;
}
.board-date-image {
    width: 250x; /* 이미지의 너비를 조절 */
    height:350px; /* 이미지의 높이를 조절 */
}
.bdlist {
	display: flex;
	width : 400px;
	height: 200px;
	margin-left: 450px;
}
.board-like {
	margin-left: 300px; 
}
div#hashlist{
	margin-left: 550px;
	display: flex;
	padding: 10px 15px;
	gap: 200px; /* 요소 간격을 설정 */
	font-size: 50px; /* 글자 크기를 크게 조정 */
	
}
.hash {
	color: #ff5733; /* 원하는 색상으로 변경 */
	
}
a{
text-decoration-line: none;
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
                    + "</div>" ; 
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
            console.log("success : " + jsonData);
            console.log(jsonData);
          
            values += "<div class='bdlist'>";
            var itemsPerColumn = Math.ceil(jsonData.dlist.length / 3); // 열당 이미지 수
            var columnIndex = 0; // 현재 열 인덱스

            for (var i in jsonData.dlist) {
             
			
              	values += "<div class='board-all'>";
                values += "<div class='board-item'>";
                values += "<a onclick='checkLogin("+ jsonData.dlist[i].bno +");'>"
                values += "<img class='board-date-image' src='" + jsonData.dlist[i].bphoto + "'></a></div>";
                values += "<div class='like-style' id='d-" + jsonData.dlist[i].bno + "'>";
                values += "<div>";
                values += "<button class='likeBtn-style' onclick='likeCountDate(" + jsonData.dlist[i].bno + ");'></button>";
                values += "<span id='dlike-" + jsonData.dlist[i].bno + "'>" + jsonData.dlist[i].blike + "</span>";
                values += "<img class='title-style' src='" + decodeURIComponent(jsonData.dlist[i].bprofile) + "'>";
                values += decodeURIComponent(jsonData.dlist[i].btitle);
                values += "</div>";
                values += "</div>"; 
                   
                values += "<div id='comment-area-"+ jsonData.dlist[i].bno +"'>";
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

</script>


</head>
<body>
	<div>
	<div class="board-main">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<script type="text/javascript">
		var member = '<%= loginMember %>';
		function checkLogin(boardNo){
			if (member == 'null'){ <%-- '<%= loginMember %>';를 ''안에 넣어서 문자열로 확인 --%>
				if (confirm("로그인 하시겠습니까?")) {
					window.location.href = "/malant/views/member/loginPage.jsp";
				} 
			}else{
				location.href="/malant/bdetail?bno=" + boardNo;
			}
		}
		</script>
		<div id="toplist"></div>
	</div>
   		 <div id="hashlist"></div>
   		 <div id="dlist"></div>
   		
    </div>
</body>
</html>


