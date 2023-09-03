package store.order.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.order.model.service.OrderService;
import store.order.model.vo.ProductOrder;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductOrder productOrder = new ProductOrder();
		
		productOrder.setBuyerName(request.getParameter("buyerName"));
		productOrder.setBuyerContact(request.getParameter("buyerContact"));
		productOrder.setRecipient(request.getParameter("recipient"));
		productOrder.setRecipientContact(request.getParameter("recipient_contact"));
		productOrder.setCodePostal(request.getParameter("zonecode"));
		productOrder.setDeliveryAddress(request.getParameter("address"));
		productOrder.setDeliveryAddress2(request.getParameter("detailAddress"));
		productOrder.setShippingAddressName(request.getParameter("extraAddress"));
		productOrder.setDeliveryNote(request.getParameter("delivery_note"));
		productOrder.setProductName(request.getParameter("productName"));
		productOrder.setThumbnailImg(request.getParameter("productThumnail"));
		productOrder.setTotalPrice(Integer.valueOf(request.getParameter("totalprice")));
		
		String orderid = null;
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] oderidValus = request.getParameter("userNo").getBytes(Charset.forName("UTF-8"));
		md.update(oderidValus);
		orderid = Base64.getEncoder().encodeToString(oderidValus);
		
		productOrder.setOrderId(orderid);
		
		
		int result = new OrderService().

		
		

}
}
