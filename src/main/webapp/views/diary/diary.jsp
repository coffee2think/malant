<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
	<div id="main">

		<div class="menu"><a href="/malant/views/diary/diary.jsp">다이어리</a></div> 
		<div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
		<div class="menu"><a href="/malant/views/diary/myplant.jsp">반려식물</a></div>	

    <div id="contentbody">
    
		    <div class="popup-box">
		      <div class="popup">
		        <div class="content">
		          <header>
		            <p>내용</p>
		            <img src="#">
		          </header>
		          <form action="#">
		            <div class="row title">
		              <label>Title</label>
		              <input type="text" spellcheck="false">
		            </div>
		            <div class="row description">
		              <label>Description</label>
		              <textarea spellcheck="false"></textarea>
		            </div>
		            <button></button>
		          </form>
		        </div>
		      </div>
		    </div> <!-- popup-box -->
		    <div class="wrapper">
		      <div class="add-box">
		        <div class="icon"><img src="/malant/resources/diary/images/newDiary.png"></div>
		        <p>Add New Diary</p>
		      </div>
		    </div>

     </div><!-- content body -->
	</div> <!-- main -->
   </div> <!-- container -->
<script type="text/javascript" src="/malant/resources/diary/js/diary.js"></script>
</html>