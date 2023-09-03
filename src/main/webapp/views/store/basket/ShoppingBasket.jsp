<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.shoppingBasket.model.vo.ShoppingBasket, java.util.ArrayList"%>
<%
ArrayList<ShoppingBasket> sblist = (ArrayList<ShoppingBasket>) request.getAttribute("sblist");
session.setAttribute("sblist", sblist);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="/malant/resources/store/css/orderInputForm.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>

<style>
#all-buy {
	display: block;
	margin: 0 auto;
	text-align: center;
	margin-top: 20px;
	width: 100px;
	height: 50px;
}
</style>


</head>
<body>
	<div class="container">
		<!-- 사이드바 -->
		<%@ include file="../common/storeSidebar.jsp"%>
		<div class="content">
			<div class="order-productline">
				<h1>장바구니</h1>
				<hr border=100vh>
				<table style="width: -webkit-fill-available; text-align: center;"
					border="1px;">
					<tr>
						<td></td>
						<td>제품 정보</td>
						<td>가 격</td>
						<td>배송비</td>
						<td>수 량</td>
						<td>총 금액</td>
					</tr>
					<%
					for (ShoppingBasket sb : sblist) {
					%>
					<tr>
						<td><img width="100px" height="100px"
							src="<%=sb.getProductThumnail()%>"></td>
						<td><%=sb.getProductName()%></td>
						<td><%=sb.getPrice()%></td>
						<td><%=sb.getDeliveryChage()%></td>
						<td><%=sb.getQuantity()%></td>
						<td><%=sb.getTotalPrice()%></td>
					</tr>
					<%
					}
					%>
					<tr>
						<td colspan="6" style="text-align: right;">총금액 : <%
						int total = 0;
						for (ShoppingBasket sb : sblist) {
							total += sb.getTotalPrice();
						}
						out.print(total);
						%></td>
					</tr>
				</table>
				<button id="all-buy" onClick="location.href='/malant/views/store/order/orderSheet.jsp'">전체 구매하기</button>
			</div>
		</div>
	</div>
</body>
</html>
