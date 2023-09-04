package store.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.shoppingBasket.model.vo.ShoppingBasket;

/**
 * Servlet implementation class InputOrderInfoServlet
 */
@WebServlet("/oinput")
public class InputOrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputOrderInfoServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
//		request.setCharacterEncoding("utf-8");
//		
//		ArrayList<ShoppingBasket> olist = new ArrayList<>();
//
//		String[] productIds = request.getParameterValues("productid");
//		String[] productThumbnails = request.getParameterValues("productThumnail");
//		String[] productNames = request.getParameterValues("productName");
//		String[] prices = request.getParameterValues("price");
//		String[] deliveryCharges = request.getParameterValues("deliveryCharge");
//		String[] quantities = request.getParameterValues("quantity");
//		String[] totalPrices = request.getParameterValues("totalPrice");
//		String total = request.getParameter("total");
//
//		for (int i = 0; i < productIds.length; i++) {
//			ShoppingBasket oinput = new ShoppingBasket();
//			oinput.setProductId(productIds[i]);
//			oinput.setProductThumnail(productThumbnails[i]);
//			oinput.setProductName(productNames[i]);
//			oinput.setPrice(Integer.valueOf(prices[i]));
//			oinput.setDeliveryChage(Integer.valueOf(deliveryCharges[i]));
//			oinput.setQuantity(Integer.valueOf(quantities[i]));
//			oinput.setTotalPrice(Integer.valueOf(totalPrices[i]));
//
//			olist.add(oinput);
//		}
//
//		request.setAttribute("olist", olist);
//		request.setAttribute("total", total);
//
//		request.getRequestDispatcher("/views/store/order/orderSheet.jsp").forward(request, response);
//	}
}
