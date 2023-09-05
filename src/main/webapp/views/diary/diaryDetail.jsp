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
	
	<table>
		<tr>
        <td><%= diary.getDiaryContent() %></td>
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
        	<button>수정</button>	
        	<button>삭제</button>
        	<button>목록</button>
        </td>
     </tr>
	</table>


     </div><!-- content body -->
   </div> <!-- main -->
   </div> <!-- container --> 
</body>
</html>