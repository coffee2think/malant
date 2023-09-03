<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, myplant.model.vo.Myplant, java.sql.Date, member.model.vo.Member" %>   
<%
	ArrayList<Myplant> list = (ArrayList<Myplant>)request.getAttribute("list");	

    Myplant myp = new Myplant(); 
    
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
<script type="text/javascript">

function requestDelete() {
	
	location.href = "/malant/mpdelete?userNo=<%= myp.getUserNo() %>&myplantId=<%= myp.getMyplantId() %>";

}

</script>
</head>
<body>
<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
	<div id="main">

		<div class="menu"><a href="/malant/views/diary/diary.jsp">다이어리</a></div> 
		<div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
		<div class="menu"><a href="/malant/views/diary/myplant.jsp">반려식물</a></div>	

	    
	<div id="contentbody">   
	
	<div class="pagingview">
	<%@ include file="../diary/myplantPagingView.jsp" %>
	</div>
	
	<% if (list.size() > 0 ) { %>
		
		<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			<form action="/malant/mpnew?user_no=<%= loginMember.getUserNo() %>" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)
					

					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL"></div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE"></div>
					<div>함께한 날 &nbsp; </div>
					
					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
	
					</div> <!-- myplantAdd -->
					</form>

		<% for (Myplant mp : list) { %>
		
			<div id="myplantListbody">
			
				<div id="myplantbox" class="myplantbox"> 
						<div class="nickname">애칭 <%= mp.getMyplantName() %></div>
						<div class="image"><img src="#"></div>
						<div class="information">
							<div class="ID">ID : <%= mp.getMyplantId() %></div>
							<div class="variety">품종 : <%= mp.getMyplantVariety() %></div>
							<div class="Dday">함께한 날 : <%= mp.getMyplantStartDate() %></div>
							<div class="memo">메모 : <%= mp.getMyplantMemo() %></div>
						</div>
					</div><!-- myplantbox -->
	
				<div id="myplantDetail" class="myplantDetail"> 디테일화면 (팝업)

					
					<div>애칭: <%= mp.getMyplantName() %></div>
					<div>품종: <%= mp.getMyplantVariety() %></div>
					<div><img src="<%= mp.getMyplantImageURL() %>"></div>0
					<div>키우기 시작한 날: <%= mp.getMyplantStartDate() %></div>
					<div>함께한 날: </div>
					<div>메모: <%= mp.getMyplantMemo() %></div>

					<div>
						<input type="button" id="modify" class="modify" value="수정">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<input type="button" class="close-btn" value="확인">
					</div>
	
					</div> <!-- myplantDetail -->
					
					
					<form action="/malant/mpupdate" method="post" enctype="multipart/form-data">
					<div id="myplantModify" class="myplantModify"> 디테일 편집화면 (팝업)

					
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME" value="<%= mp.getMyplantName() %>"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY" value="<%= mp.getMyplantVariety() %>"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL" value="<%= mp.getMyplantImageURL() %>"></div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO" value="<%= mp.getMyplantMemo() %>"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE" value="<%= mp.getMyplantStartDate() %>"></div>
					<div>함께한 날 &nbsp; </div>

					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
	
					</div> <!-- myplantModify -->
					</form>
						<% } %> <!-- for문 -->
					<!-- <div id="ovelay" ></div> -->
			</div> <!-- myplantListbody -->
			
		<% }else if(list.size() == 0) { %>
		
			<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			<form action="/malant/mpnew?user_no=<%= loginMember.getUserNo() %>" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)

					<%= loginMember.getUserNo() %>
					
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL"></div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE"></div>
					<div>함께한 날 &nbsp; </div>
	

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