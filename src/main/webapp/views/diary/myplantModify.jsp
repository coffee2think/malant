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
<script type="text/javascript">
window.onload = function(){
	//선택한 사진 파일 이미지 미리보기 처리
	var photofile = document.getElementById("multifile");
	photofile.addEventListener.('change', function(event){
		const files = event.currentTarget.files;
		const file = files [0];
		const previewImg = document.getElementById("photo");
		console.log(file.name);
		
		const reader = new FileReader();
		reader.onload = (e) => {
			previewImg.setAttribute('src', e.target.result);
			previewImg.setAttribute('data-file', file.name);
		};
		reader.readAsDataURL(file);
	});
}
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

 					<form action="/malant/mpupdate" method="post" enctype="multipart/form-data">
					<div id="myplantModify" class="myplantModify"> 편집화면

					<input type="hidden" name="MYPLANT_ID" value="<%= myplant.getMyplantId() %>">
					<input type="hidden" name="USER_NO" value="<%= loginMember.getUserNo() %>">
					<input type="hidden" name="page" value="<%= currentPage %>">
					<div>애칭 &nbsp; <input type="text" name="MYPLANT_NAME" value="<%= myplant.getMyplantName() %>"></div>
					<div>품종 &nbsp; <input type="text" name="MYPLANT_VARIETY" value="<%= myplant.getMyplantVariety() %>"></div>
					<div>사진 &nbsp; <input type="file" name="MYPLANT_IMAGE_URL" value="<%= myplant.getMyplantImageURL() %>">
							<div id="previewbox" style="width:220px;height:220px;border:1px slid black;padding:10px;margin:10px;">
							<img id="photo" src="/malant/resources/diary/myplant_upimages/<%= myplant.getMyplantImageURL() %>"
							width="200" height="200" align="center" style="position:relative;left:10px;top:10px;">
					
					</div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="MYPLANT_START_DATE" value="<%= myplant.getMyplantStartDate()%>"> </div>
					<div>메모 &nbsp; <input type="text" name="MYPLANT_MEMO" value="<%= myplant.getMyplantMemo() %>"></div>

					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="button" onclick="requestDelete(); return false;" value="삭제">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
					
					<script type="text/javascript">

					function requestDelete() {
						location.href = "/malant/mpdelete?userNo=<%= loginMember.getUserNo() %>&myplantId=<%= myplant.getMyplantId() %>&MyplantImageURL=<%= myplant.getMyplantImageURL() %>";
					}
					</script>
					
					</div> <!-- myplantModify -->
					</form>  

	
	</div> <!-- content body  -->
	</div> <!-- main -->	
</div> <!-- container -->

<script type="text/javascript" src="/malant/resources/diary/js/myplant.js"></script> 

</body>
</html>