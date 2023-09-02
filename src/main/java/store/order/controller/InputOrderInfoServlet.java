package store.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.order.model.service.OrderService;
import store.order.model.vo.ProductOrder;
import store.product.model.service.ProductService;
import store.product.model.vo.ProductDetail;
import member.model.vo.*;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 호출 성공");
		String productid = request.getParameter("productid");
		String quantitystr = request.getParameter("quantity");
		int quantity = Integer.valueOf(quantitystr);
		
		System.out.printf(productid, quantity);
		
		ProductOrder porder = new OrderService().selectProductOrder(productid, quantity);

		
		RequestDispatcher view = null;
		if (porder != null) {
			view = request.getRequestDispatcher("views/store/order/orderInput.jsp");
			request.setAttribute("porder", porder);
			System.out.println("servlet성공 : " + porder.toString());
		} else {
			System.out.println("servlet실패 : ");
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "조회된 상품이 없습니다.");
		}
		view.forward(request, response);
	}
}
