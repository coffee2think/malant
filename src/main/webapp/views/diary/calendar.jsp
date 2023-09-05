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
<link rel="stylesheet" href="/malant/resources/diary/css/calendar.css">

<script type="text/javascript"
	src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('div.day').each(function(index, item){
		console.log($(this).text());
	});
});
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
					<div id="header">
						
						<button id="backButton">Back</button>
						<div id="monthDisplay"></div>
						<button id="nextButton">Next</button>
						
					</div>
					<br>
					<!-- header -->
	
					<div id="weekdays">
						<div class="sun">Sunday</div>
						<div class="mon">Monday</div>
						<div class="tue">Tuesday</div>
						<div class="wed">Wednesday</div>
						<div class="thu">Thursday</div>
						<div class="fri">Friday</div>
						<div class="sat">Saturday</div>
					</div>
					<br>
	
					<div id="calendar">
						<div class="managing1"></div>
						<div class="managing2"></div>
						<div class="managing3"></div>
					
					</div>
				
				<div id="newEventModal">
					<!-- this div appear when active eventListner 'click'-->
					<h2>Memo</h2>
	
					<input id="eventTitleInput" placeholder="Memo" />
	
					<button id="saveButton">Save</button>
					<button id="cancelButton">Cancel</button>
				</div><!-- newEventModal -->
	
				<div id="deleteEventModal">
					<h2>Event</h2>
	
					<p id="eventText"></p>
	
					<button id="deleteButton">Delete</button>
					<button id="closeButton">Close</button>
				</div><!-- deleteEventModal -->
	
				<div id="modalBackDrop"></div>
			
			
			</div><!-- content body -->
		</div><!-- main -->
	</div><!-- container -->
	<script type="text/javascript" src="/malant/resources/diary/js/calendar.js"></script>
</body>
</html>