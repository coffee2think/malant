package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.Paging;

/**
 * Servlet implementation class MyBoardListServlet
 */
@WebServlet("/myblist")
public class MyBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MyBoardListServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userno = request.getParameter("userno");
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 10;

		BoardService bservice = new BoardService();

		int listCount = bservice.getListCount();

		Paging paging = new Paging(listCount, currentPage, limit, "myblist");
		paging.calculator();

		ArrayList<Board> myblist = bservice.selectMyList(userno, paging.getStartRow(), paging.getEndRow());

		RequestDispatcher view = null;

		view = request.getRequestDispatcher("views/board/myBoardMain.jsp");
		/* request.setAttribute("userno", userno); */

		request.setAttribute("paging", paging);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("myblist", myblist);

		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
