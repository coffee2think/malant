package diary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.model.service.DiaryService;
import diary.model.vo.Diary;

/**
 * Servlet implementation class DiaryMoveupServlet
 */
@WebServlet("/dmoveup")
public class DiaryMoveupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryMoveupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diaryId = request.getParameter("diaryNo");
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		Diary diary = new DiaryService().selectDiary(diaryId);
		
		RequestDispatcher view = null;
		if(diary != null) {
			view = request.getRequestDispatcher("views/board/boardUpdateView.jsp");
			request.setAttribute("board", diary);
			request.setAttribute("currentPage", currentPage);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "일기 수정 페이지로 이동 실패");
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
