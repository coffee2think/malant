<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, myplant.model.vo.Myplant, java.sql.Date" %>   
<%
	ArrayList<Myplant> list = (ArrayList<Myplant>)request.getAttribute("list");	
	
	Myplant myplant = (Myplant)request.getAttribute("myplant");

	int nowpage = 1;
	if(request.getAttribute("currentPage") != null){
		nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
	}
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
</head>
<body>
<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
	<div id="main">
	
		<div class="menu"><a href="/malant/dlist?user_no=<%= loginMember.getUserNo() %>">다이어리</a></div> 
		<div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
		<div class="menu"><a href="/malant/mplist?user_no=<%= loginMember.getUserNo() %>">반려식물</a></div>	

	    
	<div id="contentbody">   
	
	<div class="pagingview">
	<%@ include file="../diary/myplantPagingView.jsp" %>
	</div>
	
	<% if (list.size() > 0 ) { %>
		
		<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			<form action="/malant/mpnew" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)
					
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL"></div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE"></div>

					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
	
					</div> <!-- myplantAdd -->
					</form>

		<% for (Myplant mp : list) { %>
		
			<div id="myplantListbody">
			
				<div id="myplantbox" class="myplantbox"> 
						<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">	
						<div class="nickname">애칭 <%= mp.getMyplantName() %></div>
						<div>
							<% if(mp.getMyplantImageURL() != null) { %>
								<img class="image"  src="/malant/mpdown?MYPLANT_IMAGE_URL=<%= mp.getMyplantImageURL() %>">
							<% }else { %>
							    <img class="image" src="/malant/resources/diary/images/myplant_null_photo.png">
							<% } %>
						</div>
						<div class="information">
							<div class="ID">ID : <%= mp.getMyplantId() %></div>
							<div class="variety">품종 : <%= mp.getMyplantVariety() %></div>
							<div class="">키우기 시작한 날: <%= mp.getMyplantStartDate() %></div>
							<div class="memo">메모 : <%= mp.getMyplantMemo() %></div>
						</div>
					</div><!-- myplantbox -->
					

				<div id="myplantDetail" class="myplantDetail"> 디테일화면 (팝업)

					<input type="hidden" name="MYPLANT_ID" value="<%= mp.getMyplantId() %>">
					<input type="hidden" name="MYPLANT_IMAGE_URL" value="<%= mp.getMyplantImageURL() %>">
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<div class="">애칭: <%= mp.getMyplantName() %></div>
					<div class="">품종: <%= mp.getMyplantVariety() %></div>
					<div class="">사진 <% if(mp.getMyplantImageURL() != null){ %>
					<a href="/first/bfdown?ofile=<%= mp.getMyplantImageURL() %>">
						<%= mp.getMyplantImageURL() %></a>
							<% }else{ %>
								&nbsp;
							<% } %></div>
					<div class="">키우기 시작한 날: <%= mp.getMyplantStartDate() %></div>
					<div class="">메모: <%= mp.getMyplantMemo() %></div>

					<div>
						<input type="button" id="modify" class="modify" value="수정">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<input type="button" class="close-btn" value="확인">
					</div>
					<script type="text/javascript">
					function requestDelete() {
						location.href = "/malant/mpdelete?userNo=<%= loginMember.getUserNo() %>&myplantId=<%= mp.getMyplantId() %>&MyplantImageURL=<%= myplant.getMyplantImageURL() %>";
					}
					</script>
	
					</div> <!-- myplantDetail -->
			
			
					<form action="/malant/mpupdate" method="post" enctype="multipart/form-data">
					<div id="myplantModify" class="myplantModify"> 디테일 편집화면 (팝업)

					<input type="hidden" name="MYPLANT_ID" value="<%= mp.getMyplantId() %>">
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<input type="hidden" name="page" value="<%= nowpage %>">
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME" value="<%= mp.getMyplantName() %>"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY" value="<%= mp.getMyplantVariety() %>"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL" value="<%= mp.getMyplantImageURL() %>"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE" value="<%= mp.getMyplantStartDate()%>"> </div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO" value="<%= mp.getMyplantMemo() %>"></div>

					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
					
					<script type="text/javascript">

					function requestDelete() {
						location.href = "/malant/mpdelete?userNo=<%= loginMember.getUserNo() %>&myplantId=<%= mp.getMyplantId() %>&MyplantImageURL=<%= myplant.getMyplantImageURL() %>";
					}
					</script>
	
					</div> <!-- myplantModify -->
					</form>
				<% } %> <!-- for문 -->	
						
					<!-- <div id="ovelay" ></div> -->
			</div> <!-- myplantListbody -->
			
		<% }else if(list.size() == 0) { %>
		
			<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			<form action="/malant/mpnew?user_no=<%= loginMember.getUserNo() %>" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)

				
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL"></div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE"></div>

					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
	
					</div> <!-- myplantAdd -->
					</form>
		<% } %>
		
	</div> <!-- content body  -->
	</div> <!-- main -->	
</div> <!-- container -->

 <script type="text/javascript" src="/malant/resources/diary/js/myplant.js"></script> 

</body>
</html>