<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Paging" %>    
<%
	Paging paging = (Paging)request.getAttribute("paging");
	
	int startPage = paging.getStartPage();
	int endPage = paging.getEndPage();
	int maxPage = paging.getMaxPage();
	int currentPage = paging.getCurrentPage();
	int limit = paging.getLimit();
	
	String urlMapping = paging.getUrlMapping();
	
	String action = (String)request.getAttribute("action");
	String keyword = null, begin = null, end = null;
 
 	if(action != null){
		if(action.equals("date")) {
			begin = (String)request.getAttribute("begin");
			end = (String)request.getAttribute("end");
		}else {
			keyword = (String)request.getAttribute("keyword");
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
a{
	textdecoration="none";
}
</style>
</head>
<body>
<%-- 목록 페이징 처리 --%>
<% if(action == null){ %>
<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		[맨처음] &nbsp;
	<% }else{ //currentPage > 1 %>
		<a href="/malant/<%= urlMapping %>?page=1">[맨처음]</a> &nbsp;
	<% } %>
	<%-- 이전 페이지 그룹으로 이동 --%>
	<% if((currentPage - 8) < startPage && (currentPage - 8) > 1){  //이전그룹이 있다면 %>
		<a href="/malant/<%= urlMapping %>?page=<%= startPage - 8 %>">[이전그룹]</a> &nbsp;
	<% }else{ //이전그룹이 없다면 %>
		[이전그룹] &nbsp;
	<% } %>
	
	<%-- 현재 페이지가 속한 페이지그룹 숫자 출력 --%>
	<% for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%>
			<font color="blue" size="4"><b><%= p %></b></font>
	<%     }else{ %>
			<a href="/malant/<%= urlMapping %>?page=<%= p %>"><%= p %></a>
	<% }} %>
	
	<%-- 다음 페이지 그룹으로 이동 --%>
	<% if((currentPage + 8) > endPage && (currentPage + 8) < maxPage){  //다음그룹이 있다면 %>
		<a href="/malant/<%= urlMapping %>?page=<%= startPage + 8 %>">[다음그룹]</a> &nbsp;
	<% }else{ //다음그룹이 없다면 %>
		[다음그룹] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		[맨끝] &nbsp;
	<% }else{ //currentPage < maxPage  %>
		<a href="/malant/<%= urlMapping %>?page=<%= maxPage %>">[맨끝]</a> &nbsp;
	<% } %>
</div>
<% } %>


</body>
</html>