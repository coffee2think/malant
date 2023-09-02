package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.model.service.SearchService;
import search.model.vo.Plant;

/**
 * Servlet implementation class SearchPlantServlet
 */
@WebServlet("/plsearch")
public class SearchPlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPlantServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 식물 검색용 컨트롤러
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		ArrayList<Plant> list = new SearchService().selectPlantList(keyword);
		
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/search/searchResultView.jsp");
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", keyword +  " 검색 실패");
		}
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
