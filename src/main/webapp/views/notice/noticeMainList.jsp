<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice, java.util.ArrayList"%>
<%
ArrayList<Notice> nlist = (ArrayList<Notice>) request.getAttribute("nlist");
Notice notice = (Notice) request.getAttribute("nno");
%>
<!DOCTYPE html>
<html>
<head lang="ko">
<style type="text/css">
.notice-image {
	display: flex;
	flex-wrap: wrap;
	justify-content: center; /* 가로 가운데 정렬 */
	margin-left: 300px; /* body의 기본 마진 제거 */
}

.notice-item {
	width: calc(33.33% - 20px); /* 각 이미지는 33.33%의 너비를 가지도록 설정하고 간격을 제거 */
	box-sizing: border-box; /* 이미지 사이에 공백 없도록 설정 */
	padding: 5px; /* 이미지 주위에 약간의 공백을 추가 */
	text-align: center; /* 이미지와 텍스트를 가운데 정렬 */
	margin: 10px; /* 아이템 간 간격 추가 */
	display: flex;
	flex-direction: column; /* 이미지와 텍스트를 세로로 배치 */
	align-items: center; /* 세로 가운데 정렬 */
}

.notice-image img {
	width: 500px; /* 이미지를 100% 너비로 표시하여 부모 요소에 맞게 조절 */
}
</style>

<script>
function deleteNotice(noticeNo) {
	if (confirm("정말로 삭제하시겠습니까?")) {
        location.href = "/malant/ndelete?nno=" + noticeNo;
    }
}
function readImage(input) {
    if (input.files && input.files[0]) {
       const reader = new FileReader();
       reader.onload = function(e) {
          const previewImage = document.getElementById("preview-image");
          previewImage.src = e.target.result;
       }
       reader.readAsDataURL(input.files[0]);
    }
 }

 const inputImage = document.getElementById("input-image");
 inputImage.addEventListener("change", function() {
    readImage(this);
 });

 function checkImageSelection(inputElement) {
     var previewImage = document.getElementById("preview-image");
     
     // 파일이 선택되었는지 확인
     if (inputElement.files.length === 0) {
         alert("파일을 선택하세요."); 
         previewImage.src = "/malant/resources/board/images/8.png"; 
     } else {

         var reader = new FileReader();
         reader.onload = function(e) {
             previewImage.src = e.target.result;
         };
         reader.readAsDataURL(inputElement.files[0]);
     }
 }

</script>
</head>
<body>
	<div class="notice-main">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<div class='notice-image'>
			<div class="notice-item">	
				<% if (loginMember.getUserId().equals("admin001")) {%>
					<button id="notice-write" onclick="checkImageSelection();">파일 업로드</button>
<input type="file" id="input-image" name="input-image" onchange="checkImageSelection(this);">
<img name="preview-image" id="preview-image" src="/malant/resources/notice/notice_content_img/p.png" style="width: 350px;">
                   <br>
					<input type="hidden" name="adminno" readonly><br>
					 타입 :
					<input type="radio" name="noticetype" value="BANNER"> BANNER
					<input type="radio" name="noticetype" value="NOTICE"> NOTICE
					<input type="radio" name="noticetype" value="EVENT"> EVENT
					<br><br>
					제목 : 
					<input type="text" name="title" readonly><br><br>
					내용 : 
					<input type="text" name="content"><br><br>
					이벤트 시작일 (이벤트 타입만 체크하세요):<br>
					<input type="date" name="eventstart"><br><br>
					이벤트 종료일 (이벤트 타입만 체크하세요):<br>
					<input type="date" name="eventend"><br>
					
					<input type="submit" value="쓰기">
					<br><br><br><br>
				<% } %>
			</form>
			<%
			for (int i = 0; i < nlist.size(); i++) {
			%>
				<a href="/malant/ncontentlist?notice=<%=nlist.get(i).getNoticeNo()%>">
					<img src="<%=nlist.get(i).getContentImage()%>">
				</a>
				<div><%=nlist.get(i).getTitle()%></div>
				<% if (loginMember.getUserId().equals("admin001")) { %>
				  <%--  <button onclick="updateNotice(<%=nlist.get(i).getNoticeNo()%>)">공지사항수정</button>  --%>
				    <button onclick="deleteNotice(<%=nlist.get(i).getNoticeNo()%>)">공지사항삭제</button>
				 <% }else{ %>
				
				<%
				if (nlist.get(i).getNoticeType().equals("NOTICE")) {
				%>
				<div>
					등록일:
					<%=nlist.get(i).getPostDate()%></div>
				<%
				} else if (nlist.get(i).getNoticeType().equals("EVENT")) {
				%>
				이벤트 기간 :
				<%=nlist.get(i).getEventStart()%>
				~
				<%=nlist.get(i).getEventEnd()%>
				<% } %>
				
			</div>
			
			<% }}  %>
	
		</div>
	
	</div>

</body>
</html>