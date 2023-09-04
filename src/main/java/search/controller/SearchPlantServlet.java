package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
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
		SearchService service = new SearchService();
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		
		// 페이징 처리 준비
		String page = request.getParameter("page");
		int currentPage = page != null ? Integer.parseInt(page) : 1;
		int limit = 12;
		int listCount  = service.getListCount(keyword);
		Paging paging = new Paging(listCount, currentPage, limit, "plsearch");
		paging.calculator();
		
		// 키워드 검색
		ArrayList<Plant> list = new SearchService().selectPlantList(keyword, paging.getStartRow(), paging.getEndRow());
		System.out.println("keyword : " + keyword);
		System.out.println("startRow : " + paging.getStartRow() + ", endRow : " + paging.getEndRow());
		System.out.println("list : " + list);
		
		// 결과 전송
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("views/search/searchResultView.jsp");
		request.setAttribute("keyword", keyword);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);	
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("action", "name");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
