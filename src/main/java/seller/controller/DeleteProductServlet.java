package seller.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller.model.service.SellersService;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/sellpdelete")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello world");
		
		int productId = Integer.parseInt(request.getParameter("pid"));
		String sellerNo = request.getParameter("sellerNo");
		String thumnail = request.getParameter("Thumnail");
		
		int result = new SellersService().sellerDeleteProduct(productId);
		System.out.println(result);
		RequestDispatcher view = null;
		if(result > 0) {
		        File file = new File(thumnail);
		        String fileName = file.getName();
		         if(fileName != null) {
		            String savePath = request.getSession().getServletContext()
		                  .getRealPath("/resources/store/images");
		            new File(savePath + "\\" + fileName).delete();
		         }        
		        
	        if(fileName != null) {
	           String savePath = request.getSession().getServletContext()
	                 .getRealPath("/resources/store/images");
	           
	           new File(savePath + "\\" + fileName).delete();
	        }
	        
	        response.sendRedirect("/malant/sellplist?sellerNo="+sellerNo);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "상품 삭제 실패");
			view.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
