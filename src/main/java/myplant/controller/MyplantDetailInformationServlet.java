package myplant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myplant.model.service.MyplantService;
import myplant.model.vo.Myplant;

/**
 * Servlet implementation class MyplantInformationServlet
 */
@WebServlet("/mpinfo")
public class MyplantDetailInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyplantDetailInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 상세보기 처리용 컨트롤러
		request.setCharacterEncoding("utf-8"); 
		
		String userNo = request.getParameter("USER_NO");
		String myplantId = request.getParameter("MYPLANT_ID");
		
		//페이징 처리를 위한 페이지 변수
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//모델 서비스 객체 생성
		MyplantService mpservice = new MyplantService();
		
		//해당 게시글 리턴받음 : select
		Myplant myplant = mpservice.selectMyplantInfo(userNo, myplantId);
		
		RequestDispatcher view = null;
		if(myplant != null) {
			view = request.getRequestDispatcher("views/diary/myplant.jsp");
			
			request.setAttribute("myplant",	 myplant);
			request.setAttribute("currentPage", currentPage);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			
			request.setAttribute("message", "반려식물 정보 보기 실패");
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
