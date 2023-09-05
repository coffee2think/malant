<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*, diary.model.vo.Diary, java.sql.Date, diary.model.vo.MyDiaryPhotoes" %>   
<%
   ArrayList<Diary> list = (ArrayList<Diary>)request.getAttribute("list");   

   int nowpage = 1;
   if(request.getAttribute("currentPage") != null){
      nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
   }
   
   HashMap<Integer, ArrayList<MyDiaryPhotoes>> photoes = (HashMap<Integer, ArrayList<MyDiaryPhotoes>>)request.getAttribute("photoes");
   Set<Integer> keyset = photoes.keySet();
   Iterator<Integer> keyiter = keyset.iterator();
   
%>      
   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>malant</title>

<link rel="stylesheet" href="/malant/resources/common/css/scrolling.css" />
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
<link rel="stylesheet" href="/malant/resources/diary/css/diary.css"> 
<!-- <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"> -->


<script type="text/javascript"
   src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/malant/resources/diary/js/diary.js"></script>
<script type="text/javascript">
window.onload = function(){
	//선택한 사진파일 이미지 미리보기 처리
	var photofiles = document.getElementById("multifile");
	photofiles.addEventListener('change', function(event){		
		const files = event.currentTarget.files;	   
	    const previewView = document.getElementById("photoesView");	  	    
	    
	    for(var i = 0; i < files.length; i++){
	    	let file = files[i];
		    const reader = new FileReader();
	        reader.onload = (e) => {   
	        	var img = document.createElement("img");
	        	img.setAttribute('src', e.target.result);
	        	img.setAttribute('data-file', file.name);
	        	img.setAttribute('width', 100);
	        	img.setAttribute('height', 100);
	        	
	        	previewView.appendChild(img);
	        	previewView.innerHTML += "&nbsp;";
	        };
	        reader.readAsDataURL(file);  
	    }  //이미지 미리보기 출력
	    
	    addHidden();  //파일명들 hidden 태그로 추가
	}); //change event
}	
	 function addHidden(){
		 const form = document.getElementById("newDiaryBoxForm");
		 const multiFile = document.getElementById("multifile");
		 const nameView = document.getElementById("filenameView");
		 
		 for(var i = 0; i < multiFile.files.length; i++){
			 console.log(multiFile.files[i].name);
			 var fname = multiFile.files[i].name;
			 nameView.innerHTML += "<span>" + fname + "</span><br>";
			 
			 var inputTag = document.createElement("input");
			 inputTag.setAttribute("type", "hidden");
			 inputTag.setAttribute("name", "filenames");
			 inputTag.setAttribute("value", fname);
			 
			 form.appendChild(inputTag);
		 }
		 
		console.log(form.elements.length);
	 }	
</script>

</head>

<body>

<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
   <div id="main">

      <div class="menu"><a href="/malant/dlist?user_no=<%= loginMember.getUserNo() %>">다이어리</a></div> 
      <div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
      <div class="menu"><a href="/malant/mplist?user_no=<%= loginMember.getUserNo() %>">반려식물</a></div>   

    <div id="contentbody">
       <header>
          <div id="newDiaryGo" class="newDiaryGo"> 일기 등록하기</div> 
       </header>
      
   		 <div id="newDiaryBox" class="newDiaryBox" style="padding:10px;background:#92BEA9;">	
   			 <form action="/malant/dnew" id="newDiaryBoxForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="user_no" value="<%= loginMember.getUserNo() %>">
					<table>
						<tr>
							<td><textarea name="diary_content" style="width:300px;height:100px;" placeholder="오늘은 어떤 일이 있었나요?"></textarea><br>
							<input type="file" name="multifile" id="multifile" multiple><br>
								<div id="filenameView"></div><br>
								<div id="photoesView" style="width:500px;height:220px;border:1px solid black;padding:10px;margin:10px;">
								
								</div><br>
								
							
								<input type="reset" class="close-btn" value="취소"> &nbsp;
								<input type="submit" id="save" class="save-close-btn" value="저장">
							</td>
						</tr>
					</table>
				</form>
			</div> 

	<div class="diaryBox">
    <table border="1">

     <% for(Diary d : list) {%>
	     <tr>
	     
	        <td><div class="diaryContent"><%= d.getDiaryContent() %></div><br>
	        
	        <% while(keyiter.hasNext()) {
	        	int diary_id = (Integer)keyiter.next();
	        	ArrayList<MyDiaryPhotoes> photoList = photoes.get(diary_id);
	        	
	        	for(MyDiaryPhotoes p : photoList){
	        	%>
	        <img src="/malant/resources/diary/diary_upimages/<%= p.getFileName() %>" style="width:150px;height:150px;"> &nbsp;
	        
	        <%} }%>
	       
	        <br>
	        <%= d.getDiaryWritingDate() %><br>
	        <input type="submit" value="수정" onclick="requestUpdate(<%= d.getDiaryId() %>); return false;">
	        <input type="button" value="삭제" onclick="requestDelete(<%= d.getDiaryId() %>,'<%= d.getUserNo() %>'); return false;">
	        
	        </td>
	     </tr>
     <% } %>
    </table>
    
    </div> <!-- diaryBox -->
    <script type="text/javascript">
    
	function requestUpdate(diaryId){
		location.href="/malant/dupdate?diaryId" + diaryId;
	}
	function requestDelete(diaryId, userNo) {
		location.href = "/malant/ddelete?diaryId=" + diaryId + "&userNo=" + userNo; 
	}
	
	</script>
	
   <div>
      <%@ include file="../diary/diaryPagingView.jsp" %>
   
   
   
   </div>
   
   
     </div><!-- content body -->
   </div> <!-- main -->
   </div> <!-- container --> 
   
   
<script type="text/javascript" src="/malant/resources/diary/js/diary.js"></script>
</html>