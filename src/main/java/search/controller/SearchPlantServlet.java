package search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		int listCount = 0;
		ArrayList<Plant> list = new ArrayList<>();
		
		// request에서 값 꺼내기
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		
		String difficulty = request.getParameter("difficulty");
		String growthRate = request.getParameter("growth_rate");
		String smell = request.getParameter("smell");
		String placement = request.getParameter("placement");
		String purification = request.getParameter("purification");
		
		String diffVal = null;
		String growVal = null;
		String smellVal = null;
		String placeVal = null;
		String puriVal = null;
		
		if(!difficulty.equals("all")) {
			diffVal = difficulty;
		}
		
		if(!growthRate.equals("all")) {
			growVal = growthRate;
		}
		
		if(!smell.equals("all")) {
			smellVal = smell;
		}
		
		if(!placement.equals("all")) {
			placeVal = placement;
		}
		
		if(!purification.equals("all")) {
			puriVal = purification;
		}
		
		System.out.println("keyword : " + keyword);
		System.out.println("difficulty : " + difficulty);
		System.out.println("growthRate : " + growthRate);
		System.out.println("smell : " + smell);
		System.out.println("placement : " + placement);
		System.out.println("purification : " + purification);
		
		
		
		Map<String, String> filters = new HashMap<>();
		filters.put("difficulty", difficulty);
		filters.put("growthRate", growthRate);
		filters.put("smell", smell);
		filters.put("placement", placement);
		filters.put("purification", purification);
		
		// 페이징 처리 준비
		String page = request.getParameter("page");
		int currentPage = page != null ? Integer.parseInt(page) : 1;
		int limit = 8;
		Paging paging = null;
		
		// 검색 수행
		if(keyword.length() > 0) { // 키워드가 있을 경우 키워드 검색
			listCount  = service.getListCount(keyword);
			
			paging = new Paging(listCount, currentPage, limit, "plsearch");
			paging.calculator();
			
			list = service.selectPlantList(keyword, paging.getStartRow(), paging.getEndRow());
			
			System.out.println("keyword : " + keyword);
			System.out.println("list : " + list);
		} else { // 키워드가 없을 경우 필터 검색
			listCount  = service.getListCountByFilter(filters);
//			listCount = service.getListTest(diffVal, growVal, smellVal, placeVal, puriVal);
			
			System.out.println("listCount : " + listCount);
			
			paging = new Paging(listCount, currentPage, limit, "plsearch");
			paging.calculator();
			
			list = service.selectPlantListByFilter(filters, paging.getStartRow(), paging.getEndRow());
			System.out.println("filters : ");
			filters.forEach((key, value) -> {
	            System.out.println(key + " : " + value);
	        });
			System.out.println("list : " + list);
		}
		
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
