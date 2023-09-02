<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.order.model.vo.ProductOrder, java.util.ArrayList"%>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="/malant/resources/store/css/orderInputForm.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>


</head>
<body>
	<container>
	<div class="container">
		<!-- 사이드바 -->
		<%@ include file="../common/storeSidebar.jsp"%>
	</div>
	<div class="content">
		<h1>주문 상품</h1>
		<hr color=#dddd>
		<table border="1px">
			<tr>
				<td></td>
				<td>제품 정보</td>
				<td>가  격</td>
				<td>배송비</td>
				<td>수  량</td>
				<td>총 금액</td>
			</tr>
			<tr>
				<td><img src= "<%= pdetail.get(0).getThumbnailImg() %>"></td>
				<td>행 2, 열 2</td>
				<td>행 2, 열 3</td>
				<td>행 2, 열 4</td>
				<td>행 2, 열 5</td>
			</tr>
		</table>
	</div>
	</container>
</body>
</html>