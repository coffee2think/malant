package store.shoppingBasket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.shoppingBasket.model.service.ShoppingBasketService;
import store.shoppingBasket.model.vo.ShoppingBasket;

/**
 * Servlet implementation class DeleteBasketServlet
 */
@WebServlet("/sbdelete")
public class DeleteBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBasketServlet() {
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
		 response.setContentType("text/html;charset=UTF-8");
		 
	        PrintWriter out = response.getWriter();
	        String selectedProductIds = request.getParameter("selectedProductIds");
	        String userNo = request.getParameter("userNo");
	        String[] productIdArray = selectedProductIds.split(",");
	        
	        int result = new ShoppingBasketService().deleteShoppingBasket(userNo, productIdArray);
	        
	        

	        for (String productId : productIdArray) {
	            out.println("삭제할 제품 ID: " + productId + "<br>");
	        }
 
	        out.println("선택한 제품이 삭제되었습니다.");
	    }
		
	}

}
