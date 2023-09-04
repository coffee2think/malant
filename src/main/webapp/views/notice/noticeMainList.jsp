<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice, java.util.ArrayList"%>
<%
	ArrayList<Notice> nlist = (ArrayList<Notice>) request.getAttribute("nlist");
	int currentLimit = ((Integer) request.getAttribute("limit")).intValue();
	int nowpage = 1;
	if (request.getAttribute("currentPage") != null) {
		nowpage = ((Integer) request.getAttribute("currentPage")).intValue();
	}
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

</head>
<body>
	<div class="notice-main">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<div class='notice-image'>
			<% for (int i = 0; i < nlist.size(); i++) { %>
			<div class="notice-item">
				<a href="/malant/ncontentlist?nno=<%= nlist.get(i).getNoticeNo() %>">
				<img src="<%= nlist.get(i).getContentImage() %>">
				</a>
				<div><%= nlist.get(i).getTitle() %></div>
				<% if(nlist.get(i).getNoticeType().equals("NOTICE")){ %>
				<div>
					등록일:
					<%= nlist.get(i).getPostDate() %></div>
				<% }else if(nlist.get(i).getNoticeType().equals("EVENT")) {%>
					이벤트 기간 :
					<%= nlist.get(i).getEventStart() %> ~ <%= nlist.get(i).getEventEnd() %>
				<% } %>
			</div>
			
			<% if ((i + 1) % 3 == 0) { %>
			<div style="clear: both;"></div>
			<!-- 매 3번째 아이템 다음 줄로 넘어가기 위한 clear -->
			<% } %>
			<% } %>
		</div>
			<div> 
				<%@ include file="../common/pagingView.jsp" %>
			</div>
	</div>

</body>
</html>