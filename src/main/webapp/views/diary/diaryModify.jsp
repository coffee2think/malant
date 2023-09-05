<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="diary.model.vo.Diary, java.util.ArrayList, diary.model.vo.MyDiaryPhotoes"%>
<%
Diary diary = (Diary) request.getAttribute("diary");
int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
ArrayList<MyDiaryPhotoes> list = (ArrayList<MyDiaryPhotoes>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		 const form = document.getElementById("diaryUpdate");
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
<link rel="stylesheet" href="/malant/resources/diary/css/diary.css"> 
</head>
<body>

	<div id="container">
		<%@include file="../../views/common/sidebar.jsp"%>
		<div id="main">

			<div class="menu">
				<a href="/malant/dlist?user_no=<%=loginMember.getUserNo()%>">다이어리</a>
			</div>
			<div class="menu">
				<a href="/malant/views/diary/calendar.jsp">캘린더</a>
			</div>
			<div class="menu">
				<a href="/malant/mplist?user_no=<%=loginMember.getUserNo()%>">반려식물</a>
			</div>

			<div id="contentbody">

				<form id="diaryUpdate" action="/malant/dupdate" method="post" enctype="multipart/form-data">
					<input type="hidden" name="diaryId"value="<%= diary.getDiaryId()%>"> 
					<input type="hidden" name="userNo" value="<%= diary.getUserNo()%>">
					<input type="hidden" neme="page" value="<%= currentPage %>">
					<table>
						<tr>
							<td><textarea name="diary_content"
									style="width: 300px; height: 100px;"
									><%= diary.getDiaryContent()%></textarea><br>
									<% if(list.size() == 0) {%>
									<input type="file" name="multifile" id="multifile" multiple><br>
								<div id="filenameView"></div>
								<br>
								<div id="photoesView"
									style="width: 500px; height: 220px; border: 1px solid black; padding: 10px; margin: 10px;">
								</div>
								<% } %>
								<% if(list.size() > 0) {%>
								<div id="photoesView"
									style="width: 500px; height: 220px; border: 1px solid black; padding: 10px; margin: 10px;">
									<% for (MyDiaryPhotoes p : list) { %>
									<img
										src="/malant/resources/diary/diary_upimages/<%=p.getFileName()%>"
										style="width: 150px; height: 150px;"> &nbsp;
									<% } %>
									<input type="checkbox" name="deleteFlag" value="yes"> 파일 모두 삭제
									<% } %>
									
								</div>
								<br> <input type="reset" class="close-btn" value="취소">
								&nbsp; <input type="submit" id="save" class="save-close-btn" value="수정"></td>
						</tr>
					</table>	
			</div>
			<!-- content body -->
		</div>
		<!-- main -->
	</div>
	<!-- container -->
</body>
</html>