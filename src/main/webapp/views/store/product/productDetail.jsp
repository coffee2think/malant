<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.product.model.vo.ProductDetail, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="/malant/resources/store/css/productDetail.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>




</head>
<body>
	<div class="container">
		<!-- 사이드바 -->

		<%@ include file="../common/storeSidebar.jsp"%>

		<div class="content">
			<div id="pdetail-name"><%=pdetail.get(0).getProductName()%></div>
			<table id="pdetail-seller-price" cellspacing="5" cellpadding="0"
				border="1px">
				<tr>
					<th>판매처</th>
					<td><%=pdetail.get(0).getSellerName()%></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><%=pdetail.get(0).getPrice()%></td>
				</tr>
				<tr>
					<th>배송비</th>
					<td><%=pdetail.get(0).getDeliveryCharge()%></td>
				</tr>
			</table>


			<form class="oinputform" action="/malant/oinput" method="post">
				<input type="hidden" name="productid"
					value="<%=pdetail.get(0).getProductId()%>"> <label
					for="quantity">수량 선택</label>
					<select id="quantity" name="quantity">
					<%
        				for (int i = 1; i <= 99; i++) {
        			%>
					<option value="<%=i%>"><%=i%></option>
					<%
       				 }
        			%>
				</select>
				<input type="submit" value="구매하기">
			</form>

			<div class="buttons">
				<button class="cartButton">장바구니</button>
			</div>
			<div id="pdetail-thumnail">
				<img src="<%=pdetail.get(0).getThumbnailImg()%>" width="400px"
					align="right">
			</div>
			<div class="pdetail-detailimg">
				<img src="<%=pdetail.get(0).getProductDetailImg()%>" width="100%"
					align="right">
				<%
				if (pdetail.get(0).getProductDescription() != null) {
				%>
				<%=pdetail.get(0).getProductDescription()%>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>