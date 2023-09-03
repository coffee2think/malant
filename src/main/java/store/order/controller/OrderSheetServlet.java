package store.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderSheetServlet
 */
@WebServlet("/Osheet")
public class OrderSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSheetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyerName = request.getParameter("buyerName");
		String buyerContact = request.getParameter("buyerContact");
		String recipient = request.getParameter("recipient");
		String recipientContact = request.getParameter("recipient_contact");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		String deliveryNote = request.getParameter("delivery_note");

		// 주문 상품 목록에서 총 가격 계산하기 (예시)
		int total = 0;
		for (ShoppingBasket sb : olist) {
		    total += sb.getTotalPrice();
		}

		// ProductOrder 객체 생성하고 필드 설정하기
		ProductOrder productOrder = new ProductOrder();
		productOrder.setBuyerName(buyerName);
		productOrder.setBuyerContact(buyerContact);
		productOrder.setRecipient(recipient);
		productOrder.setRecipientContact(recipientContact);
		productOrder.setCodePostal(postcode);
		productOrder.setDeliveryAddress(address);
		productOrder.setDeliveryAddress2(detailAddress);
		productOrder.setShippingAddressName(extraAddress);
		productOrder.setDeliveryNote(deliveryNote);
		productOrder.setTotalPrice(total);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
