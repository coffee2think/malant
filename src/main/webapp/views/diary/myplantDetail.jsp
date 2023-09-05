<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, myplant.model.vo.Myplant, java.sql.Date" %>   
<%
	Myplant myplant = (Myplant)request.getAttribute("myplant");
	
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>malant</title>
<link rel="stylesheet" href="/malant/resources/common/css/scrolling.css" >
<link rel="stylesheet" href="/malant/resources/common/css/font.css" >
<link rel="stylesheet" href="/malant/resources/diary/css/myplant.css">
<style type="text/css">

</style>
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/malant/resources/diary/js/myplant.js"></script> 
<script type="text/javascript">
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
		
				<div id="myplantDetail" class="myplantDetail"> 디테일화면

					<input type="hidden" name="MYPLANT_ID" value="<%= myplant.getMyplantId() %>">
					<input type="hidden" name="MYPLANT_IMAGE_URL" value="<%= myplant.getMyplantImageURL() %>">
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<div class="ID">ID : <%= myplant.getMyplantId() %></div>
					<div class="">애칭: <%= myplant.getMyplantName() %></div>
					<div class="">품종: <%= myplant.getMyplantVariety() %></div>
					<div class="">사진 
							<% if(myplant.getMyplantImageURL() != null) { %>
								<img class="image" src="/malant/resources/diary/myplant_upimages/<%= myplant.getMyplantImageURL() %>">
							<% }else { %>
							    <img class="image" src="/malant/resources/diary/myplant_upimages/myplant_null_photo.png">
							<% } %></div>
					<div class="">키우기 시작한 날: <%= myplant.getMyplantStartDate() %></div>
					<div class="">메모: <%= myplant.getMyplantMemo() %></div>

					<div>
						<input type="button" onclick="moveUpdate(); return false;" value="수정">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<script type="text/javascript">
						function moveUpdate(){
							location.href="/malant/mpmovemodify?userNo=<%= loginMember.getUserNo() %>&myplantId=<%= myplant.getMyplantId() %>";
						}
						function requestDelete() {
							location.href = "/malant/mpdelete?userNo=<%= loginMember.getUserNo() %>&myplantId=<%= myplant.getMyplantId() %>&MyplantImageURL=<%= myplant.getMyplantImageURL() %>";
						}
						</script>
					</div>
					
					</div> <!-- myplantDetail -->
				

	</div> <!-- content body  -->
	</div> <!-- main -->	
</div> <!-- container -->

<script type="text/javascript" src="/malant/resources/diary/js/myplant.js"></script> 

</body>
</html>