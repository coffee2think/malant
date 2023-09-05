package myplant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import myplant.model.service.MyplantService;
import myplant.model.vo.Myplant;

/**
 * Servlet implementation class MyplantListServlet
 */
@WebServlet("/mplist")
public class MyplantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyplantListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// myplant list 조회서블릿
		String userNo = request.getParameter("user_no");


		//출력할 페이지 지정
		int currentPage = 1;
		
		//전송 온 페이지 값이 있다면 추출함
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한페이지 당 출력할 목록 개수 지정
			int limit = 8;
		
		//조회용 모델측 서비스 객체 생성
		MyplantService mpservice = new MyplantService();
		
		//총 페이지 수 계산을 위한 전체 목록 개수 조회
		int listCount = mpservice.getListCount(userNo);
		
		//뷰 페이지에서 사용할 페이징 관련 값 계산 처리
		Paging paging = new Paging(listCount, currentPage, limit, "mplist");
		paging.calculator();
		
		//모델 서비스로 해당 페이지에 출력할 게시글만 조회해 옴 
		ArrayList<Myplant> list = mpservice.selectMyplantList(paging, userNo);
		
		//받은 결과에 따라 성공 또는 실패 페이지 내보내기 
		RequestDispatcher view = null;
		if(list.size() >= 0) {
			view = request.getRequestDispatcher("views/diary/myplantMain.jsp");

			
			//System.out.println("listservlet result : " + userNo);
			
			request.setAttribute("list", list);
			request.setAttribute("paging", paging);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("user_no", userNo);
			
			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			
			request.setAttribute("massage", "나의 식물 목록 로딩 실패");
				
		}
		view.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
