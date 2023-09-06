<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.product.model.vo.ProductDetail, java.util.ArrayList, member.model.vo.Member"%>
<%
	Member loginMember = (Member)request.getAttribute("loginMember");
	ArrayList<ProductDetail> sellplist = (ArrayList<ProductDetail>)request.getAttribute("sellplist"); 
	int currentPage = (request.getAttribute("currentPage") != null) ? (int) request.getAttribute("currentPage") : 1;
	int pageCount = (request.getAttribute("pageCount") != null) ? (int) request.getAttribute("pageCount") : 1;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="/malant/resources/common/css/font.css" />
<link rel="stylesheet" href="/malant/resources/store/css/seller.css">
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>

</head>
<body>
	<a class="add-button" onclick="javascript: location.href='/malant/views/seller/UpdateProduct.jsp'">상품 등록</a>
	<h1>상품 목록</h1>

	<table border="1">
		<thead>
			<tr>
				<th>대표사진</th>
				<th>상품명</th>
				<th>가격</th>
				<th>등록일</th>
				<th>상품노출</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody>
			<% if (sellplist != null && !sellplist.isEmpty()) { %>
			<% for (ProductDetail product : sellplist) { %>
			<tr>
				<td><img src="<%= product.getThumbnailImg() %>" width="100"
					height="100" alt="<%= product.getProductName() %>"></td>
				<td><%= product.getProductName() %></td>
				<td><%= product.getPrice() %></td>
				<td><%= product.getProductRegistDate()%></td>
				<td><select>
						<option value="온">온</option>
						<option value="오프">오프</option>
				</select></td>
				<td><a href="#">수정</a> | <a href="#">삭제</a></td>
			</tr>
			<% } %>
			<% } else { %>
			<tr>
				<td colspan="6">조회된 상품이 없습니다.</td>
			</tr>
			<% } %>

		</tbody>
	</table>

	<div>
		<!-- 페이징 처리 부분 -->
		<% if (pageCount > 1) { %>
		<ul>
			<% if (currentPage > 1) { %>
			<li><a href="<%= request.getRequestURI() %>?page=1">처음</a></li>
			<li><a
				href="<%= request.getRequestURI() %>?page=<%= currentPage - 1 %>">이전</a></li>
			<% } %>
			<% for (int i = 1; i <= pageCount; i++) { %>
			<% if (i == currentPage) { %>
			<li><span><%= i %></span></li>
			<% } else { %>
			<li><a href="<%= request.getRequestURI() %>?page=<%= i %>"><%= i %></a></li>
			<% } %>
			<% } %>
			<% if (currentPage < pageCount) { %>
			<li><a
				href="<%= request.getRequestURI() %>?page=<%= currentPage + 1 %>">다음</a></li>
			<li><a
				href="<%= request.getRequestURI() %>?page=<%= pageCount %>">마지막</a></li>
			<% } %>
		</ul>
		<% } %>
	</div>
</body>
</html>
