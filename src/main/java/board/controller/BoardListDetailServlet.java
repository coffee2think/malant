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
import board.model.service.CommentService;
import board.model.vo.Board;
import board.model.vo.Comment;

/**
 * Servlet implementation class BoardListDetailServlet
 */
@WebServlet("/bdetail")
public class BoardListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bnum = Integer.parseInt(request.getParameter("bno"));
	
		BoardService bservice = new BoardService();
		
		ArrayList<Comment> clist = new CommentService().selectCommentList(bnum);
		ArrayList<String> cdate = new ArrayList<String>(clist.size());
		
		for(int i = 0; i < clist.size(); i++) {
			String dateStr = clist.get(i).getCommentDate().toString();
			cdate.add(dateStr);
		}
		
		Board board = bservice.selectBoardByBoardNo(bnum);

		RequestDispatcher view = null;
	
		if(board != null) {
			view = request.getRequestDispatcher("views/board/boardDetailList.jsp");
			request.setAttribute("clist", clist);
			request.setAttribute("board", board);
			request.setAttribute("cdate", cdate);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bnum + "번 글 상세조회 실패!");
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
