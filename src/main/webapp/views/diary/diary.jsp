<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, diary.model.vo.Diary, java.sql.Date" %>   
<%
	ArrayList<Diary> list = (ArrayList<Diary>)request.getAttribute("list");	

    Diary diary = new Diary(); 
    
	int nowpage = 1;
	if(request.getAttribute("currentPage") != null){
		nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
	}
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

</head>

<body>
<%-- 
<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
	<div id="main">

		<div class="menu"><a href="/malant/dlist?user_no=<%= loginMember.getUserNo() %>">다이어리</a></div> 
		<div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
		<div class="menu"><a href="/malant/mplist?user_no=<%= loginMember.getUserNo() %>">반려식물</a></div>	

    <div id="contentbody">
    	<header>
    	    <div id="newDiaryGo" class="newDiaryGo">
		        <div class="icon"><img class="flower" src="/malant/resources/diary/images/newDiary.png"></div>
		        <p>Add New Diary</p>
	       </div><!-- newDiary -->
    	</header>
    
    <% if (list.size() > 0 ) { %>
    
	      <% for (Diary d : list) { %>	      
	      
	      <div id="diaryList">
	      	<div class="diaryContent" >
	      			일기내용
	      			<%= diary.getDiaryContent() %>
	      		<img class="image1" <%= diary.getDiaryImage1URL() %>> 사진1
	      		<img class="image2" <%= diary.getDiaryImage2URL() %>> 사진1
	      		<img class="image3" <%= diary.getDiaryImage3URL() %>> 사진1
	      		<img class="image4" <%= diary.getDiaryImage4URL() %>> 사진1
	      		<img class="managing1" <%= diary.getDiaryManaging1() %>> 관리1
	      		<img class="managing2" <%= diary.getDiaryManaging2() %>> 관리1
	      		<img class="managing3" <%= diary.getDiaryManaging3() %>> 관리1
	      		<img class="managing4" <%= diary.getDiaryManaging4() %>> 관리1	
	      		<p>작성날짜 <%= diary.getDiaryWritingDate() %></p>
	      		
	      		<input type="button" id="modify" class="modify" value="수정">
				<input type="button" onclick="" value="삭제">
				<input type="button" class="close-btn" value="확인">
	      	</div><!-- diaryContent -->
	      </div>
	      	      
	      <% } %>
	      
	<% }else if (list.size() == 0 ) { %>  
	    
	    <div> 아직 등록된 일기가 없습니다</div>
	    
	 <% } %>
	      
	      <div id=newDiaryBox>
	      <form action="/malant/dnew?user_no=<%= loginMember.getUserNo() %>" method="post" enctype="multipart/form-data"> 
	      	<textarea class="diaryContent" rows="5" cols="50" name="diary_content">
	      			일기내용
	      	</textarea> <br><!-- diaryContent -->
	      		<input type="file" class="image1" name="diary_image1_url">사진첨부1 <br>
	      		<input type="file" class="image2" name="diary_image2_url">사진첨부2 <br>
	      		<input type="file" class="image3" name="diary_image3_url">사진첨부3 <br>
	      		<input type="file" class="image4" name="diary_image4_url">사진첨부4 <br>
	      		<img class="managing1" name="diary_managing1"> 관리1
	      		<img class="managing2" name="diary_managing2"> 관리1
	      		<img class="managing3" name="diary_managing3"> 관리1
	      		<img class="managing4" name="diary_managing4"> 관리1	
	      		
	      		<input type="reset" class="close-btn" value="취소">
				<input type="submit" id="save" class="save-close-btn" value="저장">
	      </form>
	      </div>
	     
	      
	      <div id=ㅡmodifyDiaryBox>
	      <form action="/malant/dupdate?user_no=<%= loginMember.getUserNo() %>" method="post" enctype="multipart/form-data"> 
	      <textarea class="diaryContent" rows="5" cols="50" name="diary_content">
	      			일기내용
	      	</textarea> <br><!-- diaryContent -->
				<input type="file" class="image1" name="diary_image1_url">사진첨부1 <br>
	      		<input type="file" class="image2" name="diary_image2_url">사진첨부2 <br>
	      		<input type="file" class="image3" name="diary_image3_url">사진첨부3 <br>
	      		<input type="file" class="image4" name="diary_image4_url">사진첨부4 <br>
	      		<img class="managing1" name="diary_managing1"> 관리1
	      		<img class="managing2" name="diary_managing2"> 관리1
	      		<img class="managing3" name="diary_managing3"> 관리1
	      		<img class="managing4" name="diary_managing4"> 관리1	
	      		
	      		<input type="reset" class="close-btn" value="취소">
				<input type="submit" id="save" class="save-close-btn" value="저장">

    	  </form>
	      </div><!-- ㅡmodifyDiaryBox -->
	   
	   
		

     </div><!-- content body -->
	</div> <!-- main -->
   </div> <!-- container --> --%>
<script type="text/javascript" src="/malant/resources/diary/js/diary.js"></script>
</html>