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

		<%@include file="../../views/common/sidebar.jsp"%>

		<div id="main">
		
		<div id="menu">
			<div class="menu1"><a href="/malant/views/diary/diary.jsp">다이어리</a></div>
			<div class="menu2"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div>
			<div class="menu3"><a>식물추가</a></div>	
    </div><!-- menu -->
    
    
    <div class="popup-box">
    	<div class="popup">
    		<div class="content">
    			<header>
    				<p>Add a new Diary</p>
    				<i class="uil uil-time"></i>
    			</header>
    			<form action="#">
    				<div class="row title">
    					<label>Title</label>
    					<input type="text">
    				</div>
    				<div class="row description">
    					<label>Description</label>
    					<input type="text">
    				</div>
    				<button>Add Diary</button>
    			</form>
    			
    		</div>
    	</div>
    </div>
    
    <div class="wrapper">
   		<li class="add-box">
   			<div class="icon"><i class="uil uil-plus"></i></div>
   			<p>Add new note</p>
   		</li>
   		<li class="note">
	   		<div class="detail">
	   			<p>This is a Title</p>
	   			<span>content</span>
	   		</div>
	   		<div>
	   			<span>April 3, 2022</span>
	   			<div class="setting">
	   				<i class="uil uil-ellipsis-h"></i>
	   				<ul class="menu">
	   					<li><i class="uil uil-pen"></i>Edit</li>
	   					<li><i class="uil uil-trash"></i>Delete</li>
	   				</ul>
	   			</div>
	   		</div>
   		</li>
   		<li class="note">
	   		<div class="detail">
	   			<p>This is a Title</p>
	   			<span>content</span>
	   		</div>
	   		<div>
	   			<span>April 3, 2022</span>
	   			<div class="setting">
	   				<i class="uil uil-ellipsis-h"></i>
	   			</div>
	   		</div>
   		</li>
   		<li class="note">
	   		<div class="detail">
	   			<p>This is a Title</p>
	   			<span>content</span>
	   		</div>
	   		<div>
	   			<span>April 3, 2022</span>
	   			<div class="setting">
	   				<i class="uil uil-ellipsis-h"></i>
	   			</div>
	   		</div>
   		</li>
   		<li class="note">
	   		<div class="detail">
	   			<p>This is a Title</p>
	   			<span>content</span>
	   		</div>
	   		<div>
	   			<span>April 3, 2022</span>
	   			<div class="setting">
	   				<i class="uil uil-ellipsis-h"></i>
	   			</div>
	   		</div>
   		</li>
   		<li class="note">
	   		<div class="detail">
	   			<p>This is a Title</p>
	   			<span>content</span>
	   		</div>
	   		<div>
	   			<span>April 3, 2022</span>
	   			<div class="setting">
	   				<i class="uil uil-ellipsis-h"></i>
	   			</div>
	   		</div>
   		</li>
    </div>
    
  
</body>
</html>