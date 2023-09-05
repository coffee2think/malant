<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="diary.model.vo.Diary" %>
<%
	Diary diary = (Diary)request.getAttribute("diary");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
   <div id="main">

      <div class="menu"><a href="/malant/dlist?user_no=<%= loginMember.getUserNo() %>">다이어리</a></div> 
      <div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
      <div class="menu"><a href="/malant/mplist?user_no=<%= loginMember.getUserNo() %>">반려식물</a></div>   

    <div id="contentbody">
    
    
	<form action="/malant/dupdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="diaryId" value="<%= diary.getDiaryId() %>">
	<input type="hidden" name="page" value="<%= currentPage %>">
	<input type="hidden" name="upfile" value="<%= diary.getDiaryImage1URL() %>">
	<input type="hidden" name="upfile" value="<%= diary.getDiaryImage2URL() %>">
	<input type="hidden" name="upfile" value="<%= diary.getDiaryImage3URL() %>">
	<input type="hidden" name="upfile" value="<%= diary.getDiaryImage4URL() %>">


	<table>
		<tr>
        <td><input type="text" value="<%= diary.getDiaryContent() %>"></td>
        <td>
           <%= diary.getDiaryImage1URL() %>
           <%= diary.getDiaryImage2URL() %>
           <%= diary.getDiaryImage3URL() %>
           <%= diary.getDiaryImage4URL() %>
        </td>
        <td>
           <%= diary.getDiaryManaging1() %>
           <%= diary.getDiaryManaging2() %>
           <%= diary.getDiaryManaging3() %>
           <%= diary.getDiaryManaging4() %>
        </td>
        <td><%= diary.getDiaryWritingDate() %></td>
        <td>
        	<button>취소</button>	
        	<button>저장</button>
        	<button>목록</button>
        </td>
     </tr>
	</table>
	</form>

     </div><!-- content body -->
   </div> <!-- main -->
   </div> <!-- container --> 
</body>
</html>