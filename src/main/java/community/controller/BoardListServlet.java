package community.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.Paging;
import community.model.service.BoardService;
import community.model.vo.Board;
import community.model.vo.Comment;
import member.model.service.MemberService;
import member.model.vo.Member;


/**
 * Servlet implementation class BoardListSortByDateServlet
 */
@WebServlet("/bdlist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 10;

		BoardService bservice = new BoardService();

		int listCount = bservice.getListCount();

		Paging paging = new Paging(listCount, currentPage, limit, "myblist");
		paging.calculator();

		ArrayList<Board> list = bservice.selectList(paging.getStartRow(), paging.getEndRow());
		
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/board/boardListView.jsp");
			
			request.setAttribute("paging", paging);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("list", list);

			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message",  "커뮤나타 게시글 목록 조회 실패!");
			view.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
