<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.order.model.vo.ProductOrder, java.util.ArrayList, store.shoppingBasket.model.vo.ShoppingBasket"%>
<%
ArrayList<ShoppingBasket> osheet = (ArrayList<ShoppingBasket>) session.getAttribute("olist");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="/malant/resources/store/css/orderInputForm.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://js.tosspayments.com/v1/payment-widget"></script>

</head>
<body>
	<div class="container">
		<div class="content">
			<div class="order-productline">
				<h1>주문 상품</h1>
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
					for (ShoppingBasket sb : osheet) {
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
						for (ShoppingBasket sb : osheet) {
							total += sb.getTotalPrice();
						}
						out.print(total);
						%></td>
					</tr>
				</table>
			</div>
			<div id="payment-method"></div>
			<div id="agreement"></div>
			<input type="reset" value="취소하기">
			<button id="payment-button">결제하기</button>
			<div style="height: 100px;"></div>
		</div>
	</div>


	<script>
	
		/////////////////////////////////////////////결제 API ////////////////////////////////////////////////////////////

		String inputString = "test_sk_KNbdOvk5rk4aeDe0ypE8n07xlzmj";
        byte[] bytesToEncode = inputString.getBytes(StandardCharsets.UTF_8);
			
		const clientKey = "test_ck_ex6BJGQOVD9JEkOdBwXrW4w2zNbg"
		const customerKey = "Gt7oSZ1n2nAv1kvgAvrql" // userNo
		const headers = {
			"Authorization" : Basic Base64.getEncoder().encodeToString(bytesToEncode)
		}
		const button = document.getElementById("payment-button")

		// ------  결제위젯 초기화 ------ 
		// 비회원 결제에는 customerKey 대신 ANONYMOUS를 사용하세요.
		const paymentWidget = PaymentWidget(clientKey, customerKey)

		// ------  결제위젯 렌더링 ------ 
		// 결제수단 UI를 렌더링할 위치를 지정합니다. `#payment-method`와 같은 CSS 선택자와 결제 금액 객체를 추가하세요.
		// DOM이 생성된 이후에 렌더링 메서드를 호출하세요.
		// https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션
		paymentWidget.renderPaymentMethods("#payment-method", {
			value : 10000,
		}, {
			variantKey : "test"
		} // 렌더링하고 싶은 결제 UI의 variantKey
		)

		// ------  이용약관 렌더링 ------
		// 이용약관 UI를 렌더링할 위치를 지정합니다. `#agreement`와 같은 CSS 선택자를 추가하세요.
		// https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자
		paymentWidget.renderAgreement('#agreement')

		// ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
		// 더 많은 결제 정보 파라미터는 결제위젯 SDK에서 확인하세요.
		// https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
		button
				.addEventListener(
						"click",
						function() {
							paymentWidget
									.requestPayment({
										orderId : "ldkawjlkdalskjdlaks", // 주문 ID(직접 만들어주세요)
										orderName : "토스 티셔츠 외 2건", // 주문명
										successUrl : 'http://localhost:8010/malant/views/store/order/paySuccess.jsp',
										failUrl : 'http://localhost:8010/malant/views/store/order/paySuccess.jsp',
										customerEmail : "customer123@gmail.com",
										customerName : "김토스"
									})
						})
	</script>
</body>